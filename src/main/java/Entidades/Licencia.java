/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author icedo
 */
@Entity
@PrimaryKeyJoinColumn(name="IdLicencia")
@DiscriminatorValue(value="Licencia")
@Table(name="Licencia")
public class Licencia extends Tramite {

  

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name="Vigencia")
    private Date vigencia;
    
    
    @Basic
    @Column(name="Tipo")
    private String tipo;

    public Licencia(Date vigencia, String tipo, Integer id_tramite, int precio, Date fecha_solicitud) {
        super(id_tramite, precio, fecha_solicitud);
        this.vigencia = vigencia;
        this.tipo = tipo;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Licencia(){
        
    }
    
    
    

  
    
}
