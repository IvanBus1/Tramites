package Persistencia;

import javax.persistence.EntityManager;

/**
 *Clase para la conexion a la bd
 * @author IVAN
 */
public interface IConexionBD {

    /**
     * Método para crear una instancia de EntityManager y establecer conexión
     * con la base de datos.
     *
     * @return Una instancia de EntityManager que representa la conexión con la
     * base de datos
     */
    public EntityManager crearcone();

}
