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

    //prueba
    public Tramite agregar (Tramite tramite);

    public List<Tramite> tramitesPersona(int id);
    public List<Tramite> tramitesPersonaP(int id,String tipotramite);
    public List<Tramite> tramitesPersonaEnRangoFechas(int id, Date fechaInicio, Date fechaFin);

}