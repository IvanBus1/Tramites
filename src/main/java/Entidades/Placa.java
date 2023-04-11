/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author icedo
 */
@Entity(name="Placa")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="Tipo")
@Table(name="Placa")
public class Placa extends Tramite {

    
    

    @Basic
    @Column(name="NumPlaca")
    private String num_placa;
    
    @Basic
    @Column(name="FechaInactividad")
    @Temporal(TemporalType.DATE)
    private Date fecha_inactividad;
    
    
    @Basic
    @Column(name="Estado")
    private String estado;
    
    @ManyToOne
    @JoinColumn(name="id_vehiculo")
    private Vehiculo vehiculo;

    public Placa(String num_placa, Date fecha_inactividad, String estado, Vehiculo vehiculo, Integer id_tramite, int precio, Date fecha_solicitud, Persona persona) {
        super(id_tramite, precio, fecha_solicitud, persona);
        this.num_placa = num_placa;
        this.fecha_inactividad = fecha_inactividad;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    public Placa(String num_placa, Date fecha_inactividad, String estado, Vehiculo vehiculo) {
        this.num_placa = num_placa;
        this.fecha_inactividad = fecha_inactividad;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    public Placa(String estado, Vehiculo vehiculo, int precio, Persona persona) {
        super(precio, new Date(), persona);
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    

    public String getNum_placa() {
        return num_placa;
    }

    public void setNum_placa(String num_placa) {
        this.num_placa = num_placa;
    }

    public Date getFecha_inactividad() {
        return fecha_inactividad;
    }

    public void setFecha_inactividad(Date fecha_inactividad) {
        this.fecha_inactividad = fecha_inactividad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Placa() {
    }
    
    
    
    

    
    
}
