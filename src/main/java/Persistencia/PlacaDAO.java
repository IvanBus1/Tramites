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
//prueba
    private IConexionBD conexionbd;

    public PlacaDAO(IConexionBD conexionbd) {
        this.conexionbd = conexionbd;
    }

    @Override
    public Placa agregar(Placa placa) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();
            emf.persist(placa);

            emf.getTransaction().commit();

            return placa;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

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

    
}