package Persistencia;

import Entidades.Vehiculo;
import java.util.List;

/**
 *Clase para los metodos de los vehiculos
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
     * Método para buscar un vehículo usando su numero de serie en la base de datos.
     *
     * @param num_serie El num_serie que se usara para buscar
     * @return El vehículo encontrado
     */
    public Vehiculo buscarPorNumeroSerie(String num_serie);
    

    
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
