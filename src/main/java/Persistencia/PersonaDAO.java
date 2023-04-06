package Persistencia;

import Entidades.Persona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author IVAN
 */
public class PersonaDAO implements IPersonaDAO {

    private IConexionBD conexionbd;

    public PersonaDAO(IConexionBD conexionbd) {
        this.conexionbd = conexionbd;
    }

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

    @Override
    public Persona buscarRFC(String nombre, String rfc) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();

            TypedQuery<Persona> query = emf.createQuery("select p from Persona p where p.rfc=:rfc and p.nombre=:nombre", Persona.class);
            query.setParameter("rfc", rfc);
            query.setParameter("nombre", nombre);
            Persona persona= query.getSingleResult();
            emf.getTransaction().commit();

            return persona;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }
    
    public List<Persona> obtenerTodos() {
       try{
       EntityManager emf = conexionbd.crearcone();
       emf.getTransaction().begin();
       
       Query query = emf.createQuery("SELECT p FROM Persona p", Persona.class);
   
       emf.getTransaction().commit();
       
       return query.getResultList();
       
       }catch (Exception ex){
           System.out.println(ex);
           return null;
       }
   }

}
