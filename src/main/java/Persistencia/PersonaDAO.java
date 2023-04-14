package Persistencia;

import Entidades.Persona;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author IVAN
 */
public class PersonaDAO implements IPersonaDAO {

    /**
     * Atributo para la conexion a la base de datos
     */
    private IConexionBD conexionbd;

    /**
     * Constructor de la clase PersonaDAO.
     *
     * @param conexionbd Objeto que implementa la interfaz IConexionBD para
     * establecer la conexión a la base de datos.
     */
    public PersonaDAO(IConexionBD conexionbd) {
        this.conexionbd = conexionbd;
    }

    /**
     * Agrega una persona a la base de datos.
     *
     * @param persona La persona a agregar.
     * @return La persona agregada, o null si ocurre un error.
     */
    @Override
    public Persona agregar(Persona persona) {
        try {

            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();
            emf.persist(persona);

            emf.getTransaction().commit();

            return persona;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }

    /**
     * Busca una persona por nombre y RFC en la base de datos.
     *
     * @param nombre El nombre de la persona a buscar.
     * @param rfc El RFC de la persona a buscar.
     * @return La persona encontrada, o null si no se encuentra ninguna persona
     * con el nombre y RFC dados.
     */
    @Override
    public Persona buscarRFC(String nombre, String rfc) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();

            TypedQuery<Persona> query = emf.createQuery("select p from Persona p where p.rfc=:rfc and p.nombre=:nombre", Persona.class);
            query.setParameter("rfc", rfc);
            query.setParameter("nombre", nombre);
            Persona persona = query.getSingleResult();
            emf.getTransaction().commit();

            return persona;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }

    /**
     * Obtiene una lista de todas las personas en la base de datos.
     *
     * @return Una lista de todas las personas en la base de datos, o null si
     * ocurre un error.
     */
    public List<Persona> obtenerTodos() {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();

            Query query = emf.createQuery("SELECT p FROM Persona p", Persona.class);

            emf.getTransaction().commit();

            return query.getResultList();

        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    /**
     * Obtiene una lista de personas que coinciden con los criterios de búsqueda
     * especificados, incluyendo nombre, apellidos y RFC. Los criterios de
     * búsqueda son opcionales, y se realizan búsquedas con coincidencia parcial
     * utilizando el operador %LIKE% en la consulta SQL.
     *
     * @param nombre El nombre de la persona a buscar. Puede ser nulo o vacío
     * para no considerar este criterio de búsqueda.
     * @param apellidoP El apellido paterno de la persona a buscar. Puede ser
     * nulo o vacío para no considerar este criterio de búsqueda.
     * @param apellidoM El apellido materno de la persona a buscar. Puede ser
     * nulo o vacío para no considerar este criterio de búsqueda.
     * @param rfc El RFC de la persona a buscar. Puede ser nulo o vacío para no
     * considerar este criterio de búsqueda.
     * @return Una lista de objetos Persona que coinciden con los criterios de
     * búsqueda especificados. Null si no se encuentran resultados o si ocurre
     * una excepción.
     */
    @Override
    public List<Persona> personasSimilares(String nombre, String apellidoP, String apellidoM, String rfc) {

        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();

            // Crear la consulta SQL con los criterios de búsqueda utilizando %LIKE%
            TypedQuery<Persona> query = emf.createQuery("SELECT p FROM Persona p WHERE "
                    + "(p.nombre LIKE :nombre AND p.apellidoPaterno LIKE :apellidoP "
                    + "AND p.apellidoMaterno LIKE :apellidoM AND p.rfc LIKE :rfc) "
                    + "OR (p.nombre LIKE :nombre AND p.apellidoPaterno LIKE :apellidoP "
                    + "AND p.apellidoMaterno LIKE :apellidoM) "
                    + "OR (p.nombre LIKE :nombre AND p.apellidoPaterno LIKE :apellidoP) "
                    + "OR (p.nombre LIKE :nombre)", Persona.class);
            query.setParameter("nombre", "%" + nombre + "%");
            query.setParameter("apellidoP", "%" + apellidoP + "%");
            query.setParameter("apellidoM", "%" + apellidoM + "%");
            query.setParameter("rfc", "%" + rfc + "%");

            List<Persona> personas = query.getResultList();

            emf.getTransaction().commit();
            emf.close();

            return personas;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    /**
     * Obtiene una lista de personas que coinciden con los criterios de búsqueda
     * especificados, incluyendo el RFC y la fecha de nacimiento. Los criterios
     * de búsqueda son opcionales, y se realizan búsquedas exactas en la base de
     * datos utilizando Criteria API de JPA.
     *
     * @param rfc El RFC de la persona a buscar. Puede ser nulo o vacío para no
     * considerar este criterio de búsqueda.
     * @param fechaN La fecha de nacimiento de la persona a buscar. Puede ser
     * nula para no considerar este criterio de búsqueda.
     * @return Una lista de objetos Persona que coinciden con los criterios de
     * búsqueda especificados. Null si no se encuentran resultados o si ocurre
     * una excepción.
     */
    @Override
    public List<Persona> personasSimilares2(String rfc, Date fechaN) {

        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();

            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<Persona> perso = cb.createQuery(Persona.class);
            Root<Persona> op = perso.from(Persona.class);
            List<Predicate> predi = new ArrayList<Predicate>();
            if (rfc != null && !rfc.equalsIgnoreCase("")) {
                predi.add(cb.like(op.get("rfc"), "%" + rfc + "%"));

            }
            if (fechaN != null) {
                predi.add(cb.equal(op.get("fechaNacimiento"), fechaN));
            }

            if (!predi.isEmpty()) {
                perso.where(predi.toArray(new Predicate[predi.size()]));
            }

            TypedQuery<Persona> chino = emf.createQuery(perso);

            List<Persona> personas = chino.getResultList();

            emf.getTransaction().commit();
            emf.close();

            return personas;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

}
