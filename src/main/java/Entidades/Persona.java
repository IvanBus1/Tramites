/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author icedo
 */
@Entity
@Table(name="Persona")
public class Persona implements Serializable {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdPersona")
    private Integer id_persona;

    @Basic
    @Column(name="RFC")
    private String rfc;
    
    @Basic
    @Column(name="Nombre")
    private String nombre;
    
    @Basic
    @Column(name="ApellidoPaterno")
    private String apellidoPaterno;
    
    @Basic
    @Column(name="ApellidoMaterno")
    private String apellidoMaterno;
    
    @Basic
    @Column(name="FechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    
    @Basic
    @Column(name="Telefono")
    private String telefono;
    
    @Basic
    @Column(name="EsDiscapacitado")
    private boolean discapacitado;

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    public Persona(Integer id_persona, String rfc, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String telefono, boolean discapacitado) {
        this.id_persona = id_persona;
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.discapacitado = discapacitado;
    }

    public Persona() {
    }
    
   

    
    
    
    
    
    
}
