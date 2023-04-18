/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.Tramite;
import java.util.Date;
import java.util.List;

/**
 *Clase para los metodos del tramite
 * @author icedo
 */
public interface ITramiteDAO {

    /**
     * Método para agregar un trámite a la base de datos.
     *
     * @param tramite El trámite a agregar
     * @return El trámite agregado
     */
    public Tramite agregar(Tramite tramite);

    /**
     * Método para obtener una lista de trámites de una persona en base a su ID
     * de persona.
     *
     * @param id El ID de la persona de la cual se desea obtener los trámites
     * @return Una lista de trámites encontrados de la persona especificada
     */
    public List<Tramite> tramitesPersona(int id);

    /**
     * Método para obtener una lista de trámites de una persona en base a su ID
     * de persona y tipo de trámite.
     *
     * @param id El ID de la persona de la cual se desea obtener los trámites
     * @param tipotramite El tipo de trámite del cual se desea obtener la lista
     * @return Una lista de trámites encontrados de la persona especificada y
     * del tipo de trámite especificado
     */
    public List<Tramite> tramitesPersonaP(int id, String tipotramite);

    /**
     * Método para obtener una lista de trámites de una persona en base a su ID
     * de persona y un rango de fechas.
     *
     * @param id El ID de la persona de la cual se desea obtener los trámites
     * @param fechaInicio La fecha de inicio del rango de fechas
     * @param fechaFin La fecha de fin del rango de fechas
     * @return Una lista de trámites encontrados de la persona especificada
     * dentro del rango de fechas especificado
     */
    public List<Tramite> tramitesPersonaEnRangoFechas(int id, Date fechaInicio, Date fechaFin);

    /**
     * Obtiene todos los trámites disponibles.
     *
     * @return Una lista de objetos de tipo Tramite que representan todos los
     * trámites disponibles.
     */
    public List<Tramite> obtenerTodosTramites();

    /**
     * Obtiene los trámites de una persona por tipo de trámite.
     *
     * @param tipotramite El tipo de trámite a buscar.
     * @return Una lista de objetos de tipo Tramite que representan los trámites
     * de la persona para el tipo de trámite especificado.
     */
    public List<Tramite> tramitesPersonaTipo(String tipotramite);

    /**
     * Obtiene los trámites de una persona dentro de un rango de fechas
     * específico.
     *
     * @param fechaInicio La fecha de inicio del rango de fechas.
     * @param fechaFin La fecha de fin del rango de fechas.
     * @return Una lista de objetos de tipo Tramite que representan los trámites
     * de la persona dentro del rango de fechas especificado.
     */
    public List<Tramite> tramitesPersonaEnRangoFechasGeneral(Date fechaInicio, Date fechaFin);

}
