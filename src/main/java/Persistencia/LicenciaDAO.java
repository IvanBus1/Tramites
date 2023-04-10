/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Licencia;
import javax.persistence.EntityManager;

/**
 *
 * @author icedo
 */
public class LicenciaDAO implements ILicenciaDAO{
    
    private IConexionBD conexionbd;

    public LicenciaDAO(IConexionBD conexionbd) {
        this.conexionbd = conexionbd;
    }
    
    @Override
    public Licencia agregar(Licencia licencia) {
        try {
            EntityManager emf = conexionbd.crearcone();
            emf.getTransaction().begin();
            emf.persist(licencia);

            emf.getTransaction().commit();

            return licencia;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
    

    
}
