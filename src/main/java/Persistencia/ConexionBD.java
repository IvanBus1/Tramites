
package Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author IVAN
 */
public class ConexionBD implements IConexionBD {

    @Override
    public EntityManager crearcone() {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
      EntityManager em = emf.createEntityManager();
      return em;
    }
    
}
