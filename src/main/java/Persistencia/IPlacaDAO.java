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
     * Método para buscar una placa por su numero de placa y estado en la base de datos.
     *
     * @param num_placa El numero de placa que se usará para buscar
     * @return La placa encontrada
     */
    public Placa buscarNumPlacayEstado(String num_placa);
    
    /**
     * Método para buscar si un vehiculo cuenta con placas por su id de vehiculo en la base de datos.
     *
     * @param id_vehiculo El id de vehiculo que se usará para verificar
     * @return La placa agregada
     */
    public boolean verificarPlaca(int id_vehiculo);
    
    
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

