package Persistencia;

import Entidades.Placa;
import java.util.List;

public interface IPlacaDAO {

    /**
     * Método para agregar una placa a la base de datos.
     *
     * @param placa La placa a agregar
     * @return La placa agregada
     */
    public Placa agregar(Placa placa);

    /**
     * Método para obtener una lista de placas de un vehículo en base a su ID de
     * vehículo.
     *
     * @param id_vehiculo El ID del vehículo del cual se desea obtener las
     * placas
     * @return Una lista de placas encontradas del vehículo especificado
     */
    public List<Placa> listaPlacasAuto(int id_vehiculo);

    /**
     * Método para desactivar una placa en la base de datos.
     *
     * @param placa La placa a desactivar
     * @return La placa desactivada
     */
    public Placa desactivarPlaca(Placa placa);

    
    
    /**
     * Método para obtener una lista de placas de un vehículo en base a su ID de
     * vehículo.
     *
     * @param id_vehiculo El ID del vehículo del cual se desea obtener las
     * placas
     * @return Una lista de placas encontradas del vehículo especificado
     */
    public List<Placa> listaPlacasAutoSinEstado(int id_vehiculo);
   
}

