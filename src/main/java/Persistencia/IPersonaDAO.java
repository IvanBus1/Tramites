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
     * Método para buscar una persona por su rfc en la base de datos.
     *
     * @param rfc el rfc que se usa para buscar
     * @return La persona encontrada
     */
    public Persona buscarPorRfc(String rfc);

    /**
     * Método para buscar una persona por su nombre completo y rfc en la base de
     * datos.
     *
     * @param rfc el rfc que se usa para buscar
     * @param nombre el nombre que se usa para buscar
     * @param apellidoPaterno el apellidoPaterno que se usa para buscar
     * @param apellidoMaterno el apellidoMaterno que se usa para buscar
     * @return La persona encontrada
     */
    public Persona buscarPorNombresRfc(String nombre, String apellidoPaterno, String apellidoMaterno, String rfc);

    /**
     * Método para buscar varias personas por su rfc en la base de datos.
     *
     * @param rfc el rfc que se usa para buscar
     * @return Las personas encontradas
     */
    public List<Persona> buscarVariosRfc(String rfc);

    /**
     * Método para buscar varias personas por su nombre completo y rfc en la
     * base de datos.
     *
     * @param rfc el rfc que se usa para buscar
     * @param nombre el nombre que se usa para buscar
     * @param apellidoPaterno el apellidoPaterno que se usa para buscar
     * @param apellidoMaterno el apellidoMaterno que se usa para buscar
     * @return Las personas encontradas
     */
    public List<Persona> buscarVariosNombresRfc(String nombre, String apellidoPaterno, String apellidoMaterno, String rfc);

    /**
     * Método para buscar una persona por su telefono en la base de datos.
     *
     * @param telefono el telefono que se usa para buscar
     * @return La persona encontrada
     */
    public Persona buscarTelefono(String telefono);

    /**
     * Método para buscar varias personas por su telefono en la base de datos.
     *
     * @param telefono el telefono que se usa para buscar
     * @return Las personas encontradas
     */
    public List<Persona> buscarVariosTelefonos(String telefono);

    /**
     * Método para buscar una persona por su nombre y RFC en la base de datos.
     *
     * @param nombre El nombre de la persona a buscar
     * @param rfc El RFC de la persona a buscar
     * @return La persona encontrada
     */
    public Persona buscarNombreRFC(String nombre, String rfc);

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

    /**
     * Obtiene una lista de personas similares por RFC.
     *
     * @param rfc El RFC de la persona a buscar.
     * @return Una lista de objetos de tipo Persona que coinciden con el RFC
     * proporcionado.
     */
    public List<Persona> personasSimilares3(String rfc);

    /**
     * Obtiene una lista de personas similares por nombre.
     *
     * @param nombre El nombre o parte del nombre de las personas a buscar.
     * @return Una lista de objetos de tipo Persona que coinciden con el nombre
     * proporcionado.
     */
    public List<Persona> personasSimilaresPorNombre(String nombre);

}
