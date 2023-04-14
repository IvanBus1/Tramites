package Persistencia;

import Entidades.Persona;
import java.util.Date;
import java.util.List;

/**
 *
 * @author IVAN
 */
public interface IPersonaDAO {

    /**
     * Método para agregar una persona a la base de datos.
     *
     * @param persona La persona a agregar
     * @return La persona agregada
     */
    public Persona agregar(Persona persona);

    /**
     * Método para buscar una persona por su nombre y RFC en la base de datos.
     *
     * @param nombre El nombre de la persona a buscar
     * @param rfc El RFC de la persona a buscar
     * @return La persona encontrada
     */
    public Persona buscarRFC(String nombre, String rfc);

    /**
     * Método para obtener una lista de personas similares en base a su nombre,
     * apellido paterno, apellido materno y RFC en la base de datos.
     *
     * @param nombre El nombre de la persona a comparar
     * @param apellidoP El apellido paterno de la persona a comparar
     * @param apellidoM El apellido materno de la persona a comparar
     * @param rfc El RFC de la persona a comparar
     * @return Una lista de personas similares encontradas
     */
    public List<Persona> personasSimilares(String nombre, String apellidoP, String apellidoM, String rfc);

    /**
     * Método para obtener una lista de personas similares en base a su RFC y
     * fecha de nacimiento en la base de datos.
     *
     * @param rfc El RFC de la persona a comparar
     * @param fechaN La fecha de nacimiento de la persona a comparar
     * @return Una lista de personas similares encontradas
     */
    public List<Persona> personasSimilares2(String rfc, Date fechaN);

}
