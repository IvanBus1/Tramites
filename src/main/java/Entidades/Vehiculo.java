package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Hector e Ivan
 */
@Entity
@Table(name = "Vehiculo")
public class Vehiculo implements Serializable {

    /**
     * Atributo que representa el id del vehiculo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdVehiculo")
    private Integer id_vehiculo;

    /**
     * Atributo que representa el numero de serie del vehiculo
     */
    @Basic
    @Column(name = "Numero_serie")
    private String num_serie;

    /**
     * Atributo que representa la linea del vehiculo
     */
    @Basic
    @Column(name = "Linea")
    private String linea;

    /**
     * Atributo que representa la marca del vehiculo
     */
    @Basic
    @Column(name = "Marca")
    private String marca;

    /**
     * Atributo que representa el color del vehiculo
     */
    @Basic
    @Column(name = "Color")
    private String color;

    /**
     * Atributo que representa el modelo del vehiculo
     */
    @Basic
    @Column(name = "Modelo")
    private String modelo;

    /**
     * Método para obtener el ID del vehículo.
     *
     * @return El ID del vehículo
     */
    public Integer getId_vehiculo() {
        return id_vehiculo;
    }

    /**
     * Método para establecer el ID del vehículo.
     *
     * @param id_vehiculo El ID del vehículo
     */
    public void setId_vehiculo(Integer id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    /**
     * Método para obtener el número de serie del vehículo.
     *
     * @return El número de serie del vehículo
     */
    public String getNum_serie() {
        return num_serie;
    }

    /**
     * Método para establecer el número de serie del vehículo.
     *
     * @param num_serie El número de serie del vehículo
     */
    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    /**
     * Método para obtener la línea del vehículo.
     *
     * @return La línea del vehículo
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Método para establecer la línea del vehículo.
     *
     * @param linea La línea del vehículo
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Método para obtener la marca del vehículo.
     *
     * @return La marca del vehículo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Método para establecer la marca del vehículo.
     *
     * @param marca La marca del vehículo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método para obtener el color del vehículo.
     *
     * @return El color del vehículo
     */
    public String getColor() {
        return color;
    }

    /**
     * Método para establecer el color del vehículo.
     *
     * @param color El color del vehículo
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Metodo para obtener el modelo del vehiculo
     *
     * @return el modelo del vehiculo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Método para establecer el Modelo del vehículo.
     *
     * @param modelo El modelo del vehículo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Constructor de la clase Vehiculo con parámetros.
     *
     * @param id_vehiculo El ID del vehículo
     * @param num_serie El número de serie del vehículo
     * @param linea La línea del vehículo
     * @param marca La marca del vehículo
     * @param color El color del vehículo
     * @param modelo El modelo del vehículo
     * @param persona La persona asociada al vehículo
     */
    public Vehiculo(Integer id_vehiculo, String num_serie, String linea, String marca, String color, String modelo, Persona persona) {
        this.id_vehiculo = id_vehiculo;
        this.num_serie = num_serie;
        this.linea = linea;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.persona = persona;
        this.placas = new ArrayList<>();
    }

    /**
     * Constructor de la clase Vehiculo sin parámetros.
     */
    public Vehiculo() {
    }

    /**
     * Método para obtener la persona asociada al vehículo.
     *
     * @return La persona asociada al vehículo
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Método para establecer la persona asociada al vehículo.
     *
     * @param persona La persona asociada al vehículo
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Método para obtener las placas asociadas al vehículo.
     *
     * @return La lista de placas asociadas al vehículo
     */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
     * Metodo para setear las placas al vehiculo
     *
     * @param placas Las placas del vehiculo
     */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    /**
     * Metodo toString para el numero de serie del vehiculo
     *
     * @return cadena de texto con el numero de serie del vehiculo
     */
    @Override
    public String toString() {
        return "" + num_serie;
    }
    /**
     * Atributo de tipo persona que indica el dueño del vehiculo
     */
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    /**
     * Lista de placas de la persona
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculo")
    private List<Placa> placas;

}
