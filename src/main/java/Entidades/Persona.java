/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hector e Ivan
 */
@Entity
@Table(name = "Persona")
public class Persona implements Serializable {

    /**
     * Atributo que representa el id de la persona
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPersona")
    private Integer id_persona;

    /**
     * Atributo que representa el rfc de la persona
     */
    @Basic
    @Column(name = "RFC")
    private String rfc;

    /**
     * Atributo que representa el nombre de la persona
     */
    @Basic
    @Column(name = "Nombre")
    private String nombre;

    /**
     * Atributo que representa el apellido paterno de la persona
     */
    @Basic
    @Column(name = "ApellidoPaterno")
    private String apellidoPaterno;

    /**
     * Atributo que representa apellido materno de la persona
     */
    @Basic
    @Column(name = "ApellidoMaterno")
    private String apellidoMaterno;

    /**
     * Atributo que representa la fecha de nacimiento de la persona
     */
    @Basic
    @Column(name = "FechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    /**
     * Atributo que representa el telefono de la persona
     */
    @Basic
    @Column(name = "Telefono")
    private String telefono;

    /**
     * Atributo que representa si una persona es discapacitada o no
     */
    @Basic
    @Column(name = "EsDiscapacitado")
    private boolean discapacitado;

    /**
     * Lista que representa los tramites que ha realizado una persona
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Tramite> tramites;

    /**
     * Lista que representa las licencias que ha tenido una persona
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Licencia> licencias;

    /**
     * Lista que representa los vehiculos que ha tenido una persona
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Vehiculo> vehiculos;

    /**
     * Metodo que obtiene el id de la persona
     *
     * @return id_persona
     */
    public Integer getId_persona() {
        return id_persona;
    }

    /**
     * metodo que setea el valor del id de la persona
     *
     * @param id_persona
     */
    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    /**
     * Metodo que obtiene el rfc de la persona
     *
     * @return rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Metodo que setea el valor del rfc de la persona
     *
     * @param rfc
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     *
     * Método que obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * Método que establece el nombre de la persona.
     *
     * @param nombre El nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * Método que obtiene el apellido paterno de la persona.
     *
     * @return El apellido paterno de la persona.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     *
     * Método que establece el apellido paterno de la persona.
     *
     * @param apellidoPaterno El apellido paterno de la persona.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     *
     * Método que obtiene el apellido materno de la persona.
     *
     * @return El apellido materno de la persona.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     *
     * Método que establece el apellido materno de la persona.
     *
     * @param apellidoMaterno El apellido materno de la persona.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     *
     * Método que obtiene la fecha de nacimiento de la persona.
     *
     * @return La fecha de nacimiento de la persona.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * Método que establece la fecha de nacimiento de la persona.
     *
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * Método que obtiene el número de teléfono de la persona.
     *
     * @return El número de teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * Método que establece el número de teléfono de la persona.
     *
     * @param telefono El número de teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * Método que verifica si la persona tiene discapacidad.
     *
     * @return {@code true} si la persona tiene discapacidad, {@code false} si
     * no.
     */
    public boolean isDiscapacitado() {
        return discapacitado;
    }

    /**
     *
     * Método que establece si la persona tiene discapacidad.
     *
     * @param discapacitado {@code true} si la persona tiene discapacidad,
     * {@code false} si no.
     */
    public void setDiscapacitado(boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    /**
     *
     * Método que obtiene la lista de trámites de la persona.
     *
     * @return La lista de trámites de la persona.
     */
    public List<Tramite> getTramites() {
        return tramites;
    }

    /**
     *
     * Método que establece la lista de trámites de la persona.
     *
     * @param tramites La lista de trámites de la persona.
     */
    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    /**
     *
     * Constructor de la clase Persona con parámetros.
     *
     * @param id_persona El identificador de la persona.
     * @param rfc El Registro Federal de Contribuyentes (RFC) de la persona.
     * @param nombre El nombre de la persona.
     * @param apellidoPaterno El apellido paterno de la persona.
     * @param apellidoMaterno El apellido materno de la persona.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @param telefono El número de teléfono de la persona.
     * @param discapacitado {@code true} si la persona tiene discapacidad,
     * {@code false} si no.
     */
    public Persona(Integer id_persona, String rfc, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String telefono, boolean discapacitado) {
        this.id_persona = id_persona;
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.discapacitado = discapacitado;
        this.tramites = new ArrayList<>();
        this.licencias = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
    }

    /**
     *
     * Constructor de la clase Persona sin parámetros.
     */
    public Persona() {
    }

    /**
     *
     * Método que obtiene la lista de vehículos de la persona.
     *
     * @return La lista de vehículos de la persona.
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     *
     * Método que establece la lista de vehículos de la persona.
     *
     * @param vehiculos La lista de vehículos de la persona.
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     *
     * Método que obtiene la lista de licencias de la persona.
     *
     * @return La lista de licencias de la persona.
     */
    public List<Licencia> getLicencias() {
        return licencias;
    }

    /**
     *
     * Método que establece la lista de licencias de la persona.
     *
     * @param licencias La lista de licencias de la persona.
     */
    public void setLicencias(List<Licencia> licencias) {
        this.licencias = licencias;
    }
}
