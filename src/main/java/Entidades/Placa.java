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
 * Clase que representa la clase placas
 * @author IVAN
 */
@Entity(name = "Placa")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Tipo")
@Table(name = "Placa")
public class Placa extends Tramite {

    /**
     * atributo que representa el numero de la placa del carro
     */
    @Basic
    @Column(name = "NumPlaca")
    private String num_placa;

    /**
     * atributo que representa la fecha de regreso de la placa
     */
    @Basic
    @Column(name = "FechaInactividad")
    @Temporal(TemporalType.DATE)
    private Date fecha_inactividad;

    /**
     * atributo que representa el estado de la placa
     */
    @Basic
    @Column(name = "Estado")
    private String estado;

    /**
     * atributo que representa el vehiculo al que pertenece
     */
    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;

    /**
     *
     * Constructor de la clase Placa con parámetros completos.
     *
     * @param num_placa El número de la placa.
     * @param fecha_inactividad La fecha de inactividad de la placa.
     * @param estado El estado de la placa.
     * @param vehiculo El vehículo asociado a la placa.
     * @param id_tramite El identificador del trámite.
     * @param precio El precio del trámite.
     * @param fecha_solicitud La fecha de solicitud del trámite.
     * @param persona La persona asociada al trámite.
     */
    public Placa(String num_placa, Date fecha_inactividad, String estado, Vehiculo vehiculo, Integer id_tramite, int precio, Date fecha_solicitud, Persona persona) {
        super(id_tramite, precio, fecha_solicitud, persona);
        this.num_placa = num_placa;
        this.fecha_inactividad = fecha_inactividad;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    /**
     *
     * Constructor de la clase Placa con parámetros mínimos.
     *
     * @param num_placa El número de la placa.
     * @param fecha_inactividad La fecha de inactividad de la placa.
     * @param estado El estado de la placa.
     * @param vehiculo El vehículo asociado a la placa.
     */
    public Placa(String num_placa, Date fecha_inactividad, String estado, Vehiculo vehiculo) {
        this.num_placa = num_placa;
        this.fecha_inactividad = fecha_inactividad;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    /**
     *
     * Constructor de la clase Placa con parámetros de la placa
     * @param num_placa El numero de placa de la placa
     * @param estado El estado de la placa.
     * @param vehiculo El vehículo asociado a la placa.
     * @param precio El precio del trámite.
     * @param persona La persona asociada al trámite.
     */
    public Placa(String num_placa,String estado, Vehiculo vehiculo, int precio, Persona persona) {
        super(precio, new Date(), persona);
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    /**
     *
     * Método que obtiene el vehículo asociado a la placa.
     *
     * @return El vehículo asociado a la placa.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     *
     * Método que establece el vehículo asociado a la placa.
     *
     * @param vehiculo El vehículo asociado a la placa.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    


        /**
         *
         * Método que obtiene el número de placa.
         *
         * @return El número de placa.
         */
        public String getNum_placa() {
            return num_placa;
        }

        /**
         *
         * Método que establece el número de placa.
         *
         * @param num_placa El número de placa.
         */
        public void setNum_placa(String num_placa) {
            this.num_placa = num_placa;
        }

        /**
         *
         * Método que obtiene la fecha de inactividad de la placa.
         *
         * @return La fecha de inactividad de la placa.
         */
        public Date getFecha_inactividad() {
            return fecha_inactividad;
        }

        /**
         *
         * Método que establece la fecha de inactividad de la placa.
         *
         * @param fecha_inactividad La fecha de inactividad de la placa.
         */
        public void setFecha_inactividad(Date fecha_inactividad) {
            this.fecha_inactividad = fecha_inactividad;
        }

        /**
         *
         * Método que obtiene el estado de la placa.
         *
         * @return El estado de la placa.
         */
        public String getEstado() {
            return estado;
        }

        /**
         *
         * Método que establece el estado de la placa.
         *
         * @param estado El estado de la placa.
         */
        public void setEstado(String estado) {
            this.estado = estado;
        }

        /**
         *
         * Constructor vacío de la clase Placa.
         */
        public Placa() {
        }
    }


