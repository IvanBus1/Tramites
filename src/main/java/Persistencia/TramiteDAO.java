/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Tramite;
import javax.persistence.EntityManager;

/**
 *
 * @author icedo
 */
public class TramiteDAO implements ITramiteDAO{
    
    
    private IConexionBD conexionbd;

    public TramiteDAO(IConexionBD conexionbd) {
        this.conexionbd = conexionbd;
    }
    
    @Override
    public Tramite agregar(Tramite tramite) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();
            emf.persist(tramite);

            emf.getTransaction().commit();

            return tramite;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    
}
