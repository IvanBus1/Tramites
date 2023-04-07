
package Persistencia;

import Entidades.Vehiculo;
import javax.persistence.EntityManager;

/**
 *
 * @author IVAN
 */
public class VehiculoDAO implements IVehiculoDAO{

     
    private IConexionBD conexionbd;

    public VehiculoDAO (IConexionBD conexionbd) {
        this.conexionbd = conexionbd;
    }
    

    @Override
    public Vehiculo agregar(Vehiculo vehiculo) {
         try{
        EntityManager emf= conexionbd.crearcone();
       emf.getTransaction().begin();
       emf.persist(vehiculo);
       
       
       
       emf.getTransaction().commit();
       
       return vehiculo;
        }catch (Exception ex){
            System.out.println(ex);
            return null;
        }
    
    }
    
}
