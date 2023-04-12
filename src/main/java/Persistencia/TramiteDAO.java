package Persistencia;

import Entidades.Tramite;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author icedo
 */
public class TramiteDAO implements ITramiteDAO {

    private IConexionBD conexionbd;

    public TramiteDAO(IConexionBD conexionbd) {
        this.conexionbd = conexionbd;
    }

    @Override
    public Tramite agregar(Tramite tramite) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();
            emf.persist(tramite);

            emf.getTransaction().commit();

            return tramite;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public List<Tramite> tramitesPersona(int id) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();

            TypedQuery<Tramite> query = emf.createQuery("SELECT t FROM Tramite t WHERE t.persona.id_persona = :idPersona", Tramite.class);
            query.setParameter("idPersona", id);
            List<Tramite> tramites = query.getResultList();

            emf.getTransaction().commit();
            emf.close();

            return tramites;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }

    @Override
    public List<Tramite> tramitesPersonaP(int id, String tipotramite) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();

            TypedQuery<Tramite> query = emf.createQuery("SELECT t FROM Tramite t WHERE t.persona.id_persona = :idPersona AND t.tipo = :tipoTramite", Tramite.class);
            query.setParameter("idPersona", id);
            query.setParameter("tipoTramite", tipotramite);
            List<Tramite> tramites = query.getResultList();

            emf.getTransaction().commit();
            emf.close();

            return tramites;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public List<Tramite> tramitesPersonaEnRangoFechas(int id, Date fechaInicio, Date fechaFin) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();
            System.out.println(fechaInicio);
            System.out.println(fechaFin);
            TypedQuery<Tramite> query = emf.createQuery("SELECT t FROM Tramite t WHERE t.persona.id_persona = :idPersona AND t.fecha_solicitud BETWEEN :fechaInicio AND :fechaFin", Tramite.class);
            query.setParameter("idPersona", id);
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);
            List<Tramite> tramites = query.getResultList();

            emf.getTransaction().commit();
            emf.close();
            System.out.println("todo bien");
            return tramites;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
//prueba

   
}