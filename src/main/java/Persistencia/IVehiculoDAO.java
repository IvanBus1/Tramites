package Persistencia;

import Entidades.Vehiculo;
import java.util.List;

/**
 *
 * @author IVAN
 */
public interface IVehiculoDAO {

    /**
     * Método para agregar un vehículo a la base de datos.
     *
     * @param vehiculo El vehículo a agregar
     * @return El vehículo agregado
     */
    public Vehiculo agregar(Vehiculo vehiculo);

    /**
     * Método para obtener una lista de vehículos asociados a un cliente en base
     * a su RFC.
     *
     * @param rfc El RFC del cliente del cual se desea obtener la lista de
     * vehículos
     * @return Una lista de vehículos encontrados asociados al cliente
     * especificado
     */
    public List<Vehiculo> listaAutosCliente(String rfc);

}
