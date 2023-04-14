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

    /**
     * Atributo para la conexion a la bd
     */
    private IConexionBD conexionbd;

    /**

Constructor de la clase TramiteDAO.
@param conexionbd Objeto que maneja la conexión a la base de datos.
*/
    public TramiteDAO(IConexionBD conexionbd) {
        this.conexionbd = conexionbd;
    }

    /**
     * Metodo para agregar un tramite
     * @param tramite objeto de tipo tramite
     * @return  un tramite
     */
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

    /**
     * Metodo para consultar una lista de personas en base a su id
     * @param id id de la persona de la cual se buscaran sus tramites
     * @return tramites lista de tramites
     */
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

    /**
     * Metodo para buscar los tramites de las personas en base al tipo de tramite
     * @param id id de la persona de la cual se buscaran los tramites
     * @param tipotramite tipo del tramites por el cual se filtrara(placa o licencia)
     * @return lista de tramites en base a los filtros aplicados
     */
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

    /**
     * Metodo para buscar los tramites de una persona en base al rango de fechas que se le mande
     * @param id id de la persona a la cual se le buscaran los tramites
     * @param fechaInicio fecha en la que inicia la busqueda de tramites
     * @param fechaFin fecha en la que termina la busqueda de  tramites
     * @return lista de tramites filtrados
     */
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


   
}