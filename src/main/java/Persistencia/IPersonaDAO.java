
package Persistencia;

import Entidades.Persona;

/**
 *
 * @author IVAN
 */
public interface IPersonaDAO {
    
    /**
     * Metodo para añadir una persona
     * @param persona
     * @return Persona
     */
     public Persona agregar (Persona persona);
     
     public Persona buscarRFC(String nombre,String rfc);
}
