/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Placa;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author IVAN
 */
public class PlacaDAO implements IPlacaDAO {

    private IConexionBD conexionbd;

    /**
     * Constructor de la clase PlacaDAO.
     *
     * @param conexionbd Objeto que implementa la interfaz IConexionBD para la
     * conexión a la base de datos.
     */
    public PlacaDAO(IConexionBD conexionbd) {
        this.conexionbd = conexionbd;
    }

    /**
     * Agrega una nueva Placa a la base de datos.
     *
     * @param placa Objeto de la clase Placa a agregar.
     * @return Objeto de la clase Placa agregado, o null si ocurre un error.
     */
    @Override
    public Placa agregar(Placa placa) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();
            emf.persist(placa);
            emf.flush();
            emf.refresh(placa);
            emf.getTransaction().commit();

            return placa;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    /**
     * Obtiene una lista de placas asociadas a un vehículo específico que estén
     * en estado "Activo".
     *
     * @param id_vehiculo Identificador del vehículo del cual se desean obtener
     * las placas.
     * @return Lista de objetos de la clase Placa que están asociados al
     * vehículo y tienen estado "Activo", o null si ocurre un error.
     */
    @Override
    public List<Placa> listaPlacasAuto(int id_vehiculo) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();

            // Utilizar una constante o variable estática para el valor "Activo"
            String estadoActivo = "Activo";

            TypedQuery<Placa> query = emf.createQuery("SELECT p FROM Placa p WHERE p.vehiculo.id_vehiculo = :id_vehiculo AND p.estado = :estado", Placa.class);
            query.setParameter("id_vehiculo", id_vehiculo);
            query.setParameter("estado", estadoActivo); // Utilizar un parámetro con nombre para el valor "Activo"

            List<Placa> placas = query.getResultList();

            emf.getTransaction().commit();
            emf.close();

            return placas;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    /**
     * Desactiva una Placa cambiando su estado a "Inactivo" y estableciendo la
     * fecha de inactividad.
     *
     * @param placa Objeto de la clase Placa a desactivar.
     * @return Objeto de la clase Placa desactivado, o null si ocurre un error.
     */
    @Override
    public Placa desactivarPlaca(Placa placa) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();
            placa.setEstado("Inactivo");
            placa.setFecha_inactividad(new Date());
            emf.merge(placa);

            emf.getTransaction().commit();

            return placa;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    /**
     * Obtiene una lista de placas asociadas a un vehículo específico, sin
     * importar su estado.
     *
     * @param id_vehiculo Identificador del vehículo del cual se desean obtener
     * las placas.
     * @return Lista de objetos de la clase Placa que están asociados al
     * vehículo, o null si ocurre un error.
     */
    @Override
    public List<Placa> listaPlacasAutoSinEstado(int id_vehiculo) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();

            TypedQuery<Placa> query = emf.createQuery("SELECT p FROM Placa p WHERE p.vehiculo.id_vehiculo = :id_vehiculo", Placa.class);
            query.setParameter("id_vehiculo", id_vehiculo);

            List<Placa> placas = query.getResultList();

            emf.getTransaction().commit();
            emf.close();

            return placas;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
}
