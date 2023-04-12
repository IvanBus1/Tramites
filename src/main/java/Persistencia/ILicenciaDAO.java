/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.Licencia;
import java.util.List;



/**
 *
 * @author icedo
 */
public interface ILicenciaDAO {
    
    public Licencia agregar (Licencia licencia);
    
    public boolean verificarLicencia (int idPersona);
    
    public Licencia desactivarLicencia(Licencia licencia);
    
    public List<Licencia> listaLicenciasPer(int id_persona);    
    
    public Licencia buscarIdyEstado(int id_tramite);
    
}
