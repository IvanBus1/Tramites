
package Persistencia;

import Entidades.Vehiculo;
import java.util.List;

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
     
       public List<Vehiculo> listaAutosCliente(String rfc);
}
