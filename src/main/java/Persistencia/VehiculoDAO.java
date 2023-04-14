
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

     /**
      * Atributo para la conexion a la base de datos
      */
    private IConexionBD conexionbd;

    /**
     * Constructor para la conexion a la base de datos
     * @param conexionbd atributo para la conexion
     */
    public VehiculoDAO (IConexionBD conexionbd) {
        this.conexionbd = conexionbd;
    }
    

    /**
     * Metodo para agregar un vehiculo a la base de datos
     * @param vehiculo vehiculo que sera agregado a la base de datos
     * @return vehiculo agregado
     */
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

    /**
     * Metodo para buscar los autos de un cliente en especifico
     * @param rfc rfc del cliente 
     * @return  lista de autos del cliente en especifico
     */
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
