/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.Licencia;
import java.util.List;

/**
 *Clase para los metodos de la licencia
 * @author icedo
 */
public interface ILicenciaDAO {

    /**
     * Método para agregar una licencia a la base de datos.
     *
     * @param licencia La licencia a agregar
     * @return La licencia agregada
     */
    public Licencia agregar(Licencia licencia);

    /**
     * Método para verificar si una persona tiene una licencia activa en la base
     * de datos.
     *
     * @param idPersona El ID de la persona a verificar
     * @return true si la persona tiene una licencia activa, false de lo
     * contrario
     */
    public boolean verificarLicencia(int idPersona);

    /**
     * Método para desactivar una licencia en la base de datos.
     *
     * @param licencia La licencia a desactivar
     * @return La licencia desactivada
     */
    public Licencia desactivarLicencia(Licencia licencia);

    /**
     * Método para obtener una lista de licencias asociadas a una persona en la
     * base de datos.
     *
     * @param id_persona El ID de la persona para la cual se desea obtener la
     * lista de licencias
     * @return Una lista de licencias asociadas a la persona
     */
    public List<Licencia> listaLicenciasPer(int id_persona);

    /**
     * Método para buscar una licencia por su ID y estado en la base de datos.
     *
     * @param id_tramite El ID del trámite de licencia a buscar
     * @return La licencia encontrada
     */
    public Licencia buscarIdyEstado(int id_tramite);

}
