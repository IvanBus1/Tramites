/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Placa;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *Clase para las placas
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
     * Busca las placas por su número de placa y estado 'Activa' en la base de
     * datos.
     *
     * @param num_placa El numero de placa de la placa a buscar.
     * @return La licencia encontrada, o null si no se encuentra ninguna
     * licencia activa con el ID de trámite dado.
     */
    @Override
    public Placa buscarNumPlacayEstado(String num_placa) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();

            TypedQuery<Placa> query = emf.createQuery("select p from Placa p where p.num_placa=:NumPlaca and p.estado='Activa'", Placa.class);
            query.setParameter("NumPlaca", num_placa);
            Placa placa = query.getSingleResult();
            emf.getTransaction().commit();

            return placa;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    /**
     * Verifica si existe una placa asociada a el vehiculo en la base de
     * datos.
     *
     * @param id_vehiculo El ID del vehiculo a verificar
     * @return true si existen placas asociadas a el vehiculo , false si no
     */
    @Override
    public boolean verificarPlaca(int id_vehiculo) {
        try {
            EntityManager emf = conexionbd.crearcone();
            Query query = emf.createQuery("SELECT COUNT(p) FROM Placa p WHERE p.vehiculo.id_vehiculo = :idVehiculo");
            query.setParameter("idVehiculo", id_vehiculo);
            Long count = (Long) query.getSingleResult();
            return count > 0;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
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

            // Utilizar una constante o variable estática para el valor "Activa"
            String estadoActiva = "Activa";

            TypedQuery<Placa> query = emf.createQuery("SELECT p FROM Placa p WHERE p.vehiculo.id_vehiculo = :id_vehiculo AND p.estado = :estado", Placa.class);
            query.setParameter("id_vehiculo", id_vehiculo);
            query.setParameter("estado", estadoActiva); // Utilizar un parámetro con nombre para el valor "Activa"

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
            placa.setEstado("Inactiva");
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
