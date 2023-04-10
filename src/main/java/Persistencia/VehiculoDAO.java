
package Persistencia;

import Entidades.Vehiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

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

    @Override
    public List<Vehiculo> listaAutosCliente(String rfc) {
    try {
        EntityManager emf = conexionbd.crearcone();
       emf.getTransaction().begin();
      

        TypedQuery<Vehiculo> query = emf.createQuery("SELECT v FROM Vehiculo v WHERE v.persona.rfc = :rfc", Vehiculo.class);
        query.setParameter("rfc", rfc);
        List<Vehiculo> vehiculos = query.getResultList();

        emf.getTransaction().commit();
        emf.close();

        return vehiculos;
    } catch (Exception ex) {
        System.out.println(ex);
        return null;
    }
    }

    
    
}
