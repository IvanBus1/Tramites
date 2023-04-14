/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Licencia;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author icedo
 */
public class LicenciaDAO implements ILicenciaDAO {

    /**
     * Atributo para la conexion a la base de datos
     */
    private IConexionBD conexionbd;

    /**
     * Constructor que recibe una instancia de la interfaz IConexionBD para
     * establecer la conexión a la base de datos.
     *
     * @param conexionbd La instancia de IConexionBD a utilizar
     */
    public LicenciaDAO(IConexionBD conexionbd) {
        this.conexionbd = conexionbd;
    }

    /**
     * Agrega una nueva licencia a la base de datos.
     *
     * @param licencia La licencia a agregar
     * @return La licencia agregada, o null si ocurrió un error
     */
    @Override
    public Licencia agregar(Licencia licencia) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();
            emf.persist(licencia);

            emf.getTransaction().commit();

            return licencia;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    /**
     * Verifica si existe una licencia asociada a una persona en la base de
     * datos.
     *
     * @param idPersona El ID de la persona a verificar
     * @return true si existe una licencia asociada a la persona, false si no
     */
    @Override
    public boolean verificarLicencia(int idPersona) {
        try {
            EntityManager emf = conexionbd.crearcone();
            Query query = emf.createQuery("SELECT COUNT(l) FROM Licencia l WHERE l.persona.id_persona = :idPersona");
            query.setParameter("idPersona", idPersona);
            Long count = (Long) query.getSingleResult();
            return count > 0;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    /**
     * Desactiva una licencia cambiando su estado a "Inactiva" y su vigencia a
     * la fecha actual en la base de datos.
     *
     * @param licencia La licencia a desactivar
     * @return La licencia desactivada, o null si ocurrió un error
     */
    @Override
    public Licencia desactivarLicencia(Licencia licencia) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();
            licencia.setEstado("Inactiva");
            licencia.setVigencia(new Date());
            emf.merge(licencia);

            emf.getTransaction().commit();

            return licencia;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    /**
     * Busca una licencia por ID de trámite y estado 'Activa' en la base de
     * datos.
     *
     * @param idTramite El ID de trámite de la licencia a buscar.
     * @return La licencia encontrada, o null si no se encuentra ninguna
     * licencia activa con el ID de trámite dado.
     */
    @Override
    public Licencia buscarIdyEstado(int id_tramite) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();

            TypedQuery<Licencia> query = emf.createQuery("select l from Licencia l where l.id_tramite=:idTramite and l.estado='Activa'", Licencia.class);
            query.setParameter("idTramite", id_tramite);
            Licencia licencia = query.getSingleResult();
            emf.getTransaction().commit();

            return licencia;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Obtiene una lista de licencias de una persona en estado 'Activa' en la
     * base de datos.
     *
     * @param idPersona El ID de la persona para la cual se obtienen las
     * licencias.
     * @return Una lista de licencias activas de la persona, o null si ocurre un
     * error.
     */
    @Override
    public List<Licencia> listaLicenciasPer(int id_persona) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();

            String estadoActiva = "Activa";

            TypedQuery<Licencia> query = emf.createQuery("SELECT l FROM Licencia l WHERE l.persona.id_persona = :idPersona AND l.estado = :estado", Licencia.class);
            query.setParameter("id_tramite", id_persona);
            query.setParameter("activa", estadoActiva);

            List<Licencia> licencias = query.getResultList();

            emf.getTransaction().commit();
            emf.close();

            return licencias;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

}
