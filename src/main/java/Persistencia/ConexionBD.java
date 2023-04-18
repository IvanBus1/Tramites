package Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase para la conexion a la bd
 *
 * @author IVAN
 */
public class ConexionBD implements IConexionBD {

    /**
     *
     * Crea una instancia de EntityManager y establece conexión con la base de
     * datos.
     *
     * @return Una instancia de EntityManager que representa la conexión con la
     * base de datos.
     */
    @Override
    public EntityManager crearcone() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        return em;
    }

}
