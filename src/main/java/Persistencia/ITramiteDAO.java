/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.Tramite;
import java.util.Date;
import java.util.List;

/**
 *
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

}
