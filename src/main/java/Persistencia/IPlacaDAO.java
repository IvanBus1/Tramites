package Persistencia;

import Entidades.Placa;
import java.util.List;


public interface IPlacaDAO {
    
     public Placa agregar (Placa placa);


      public List<Placa> listaPlacasAuto(int id_vehiculo);

      public Placa desactivarPlaca(Placa placa);

      
}
//prueba