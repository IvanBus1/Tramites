
package Persistencia;

import Entidades.Vehiculo;

/**
 *
 * @author IVAN
 */
public interface IVehiculoDAO {
    
    /**
     * Metodo para añadir un vehiculo
     * @param persona
     * @return vehiculo
     */
     public Vehiculo agregar (Vehiculo vehiculo);
}
