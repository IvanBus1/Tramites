
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
 * @author Hector e Ivan
 */
@Entity(name="Tramite")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="Tipo")
@Table(name="Tramite")
public class Tramite implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdTramite")
    private Integer id_tramite;

    @Basic
    @Column(name="Precio")
    private int precio;
    
    @Basic
    @Column(name="FechaSolicitud")
    @Temporal(TemporalType.DATE)
    private Date fecha_solicitud;
    
    @ManyToOne
    @JoinColumn(name="id_persona")
    private Persona persona;

    public Integer getId_tramite() {
        return id_tramite;
    }

    public void setId_tramite(Integer id_tramite) {
        this.id_tramite = id_tramite;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public Tramite(Integer id_tramite, int precio, Date fecha_solicitud, Persona persona) {
        this.id_tramite = id_tramite;
        this.precio = precio;
        this.fecha_solicitud = fecha_solicitud;
        this.persona = persona;
    }

    

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Tramite() {
    }
    
    
    
    

    
    
}
