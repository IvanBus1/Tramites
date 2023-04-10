
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
@Table(name="Vehiculo")
public class Vehiculo implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdVehiculo")
    private Integer id_vehiculo;

    
    
    @Basic
    @Column(name="Numero_serie")
    private int num_serie;
    
    @Basic
    @Column(name="Linea")
    private String linea;
    
    @Basic
    @Column(name="Marca")
    private String marca;
    
    @Basic
    @Column(name="Color")
    private String color;
    
    @Basic
    @Column(name="Modelo")
    private String modelo;

    public Integer getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(Integer id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(int num_serie) {
        this.num_serie = num_serie;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Vehiculo(Integer id_vehiculo, int num_serie, String linea, String marca, String color, String modelo, Persona persona) {
        this.id_vehiculo = id_vehiculo;
        this.num_serie = num_serie;
        this.linea = linea;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.persona = persona;
        this.placas= new ArrayList<>();
    }

   

    public Vehiculo() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Placa> getPlacas() {
        return placas;
    }

    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    @Override
    public String toString() {
        return "" + num_serie ;
    }

    
    
    
    @ManyToOne
    @JoinColumn(name="id_persona")
    private Persona persona;
  
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculo")
    private List<Placa> placas;
    
}
