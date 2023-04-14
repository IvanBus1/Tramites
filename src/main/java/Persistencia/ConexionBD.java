package Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author IVAN
 */
public class ConexionBD implements IConexionBD {

    /**
     * Método para crear una instancia de EntityManager y establecer conexión
     * con la base de datos.
     *
     * @return Una instancia de EntityManager que representa la conexión con la
     * base de datos
     */
    @Override
    public EntityManager crearcone() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU"); 
        EntityManager em = emf.createEntityManager(); 
        return em; 
    }

}
