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
 * Esta clase representa un trámite y utiliza el patrón de diseño "Joined
 * Inheritance". Se utiliza la anotación @Entity para indicar que es una entidad
 * en la base de datos. La anotación @Inheritance se utiliza para definir la
 * estrategia de herencia, en este caso Joined. La anotación
 * @DiscriminatorColumn se utiliza para especificar el nombre de la columna que
 * se utilizará para diferenciar entre las subclases en la tabla de la
 * superclase. La anotación @Table se utiliza para especificar el nombre de la
 * tabla en la base de datos que contendrá los datos de esta entidad.
 */
@Entity(name = "Tramite")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Tipo")
@Table(name = "Tramite")
public class Tramite implements Serializable {

    /**
     * Atributo que representa el id del tramite
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTramite")
    private Integer id_tramite;

    /**
     * Atributo que representa el precio del tramite
     */
    @Basic
    @Column(name = "Precio")
    private int precio;

    /**
     * Atributo que representa el tipo del tramite
     */
    @Basic
    @Column(name = "Tipo")
    private String tipo;

    /**
     * Atributo que representa la fecha de solicitud del tramite
     */
    @Basic
    @Column(name = "FechaSolicitud")
    @Temporal(TemporalType.DATE)
    private Date fecha_solicitud;

    /**
     * Atributo que representa la persona que realizo el tramite
     */
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    /**
     * Método para obtener el ID del trámite.
     *
     * @return El ID del trámite
     */
    public Integer getId_tramite() {
        return id_tramite;
    }

    /**
     * Método para establecer el ID del trámite.
     *
     * @param id_tramite El ID del trámite
     */
    public void setId_tramite(Integer id_tramite) {
        this.id_tramite = id_tramite;
    }

    /**
     * Método para obtener el precio del trámite.
     *
     * @return El precio del trámite
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Método para establecer el precio del trámite.
     *
     * @param precio El precio del trámite
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Método para obtener la fecha de solicitud del trámite.
     *
     * @return La fecha de solicitud del trámite
     */
    public Date getFecha_solicitud() {
        return fecha_solicitud;
    }

    /**
     * Método para establecer la fecha de solicitud del trámite.
     *
     * @param fecha_solicitud La fecha de solicitud del trámite
     */
    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    /**
     * Constructor de la clase Tramite con todos los parámetros.
     *
     * @param id_tramite ID del trámite
     * @param precio Precio del trámite
     * @param fecha_solicitud Fecha de solicitud del trámite
     * @param persona Objeto Persona asociado al trámite
     */
    public Tramite(Integer id_tramite, int precio, Date fecha_solicitud, Persona persona) {
        this.id_tramite = id_tramite;
        this.precio = precio;
        this.fecha_solicitud = fecha_solicitud;
        this.persona = persona;
    }

    /**
     * Constructor de la clase Tramite sin ID del trámite.
     *
     * @param precio Precio del trámite
     * @param fecha_solicitud Fecha de solicitud del trámite
     * @param persona Objeto Persona asociado al trámite
     */
    public Tramite(int precio, Date fecha_solicitud, Persona persona) {
        this.precio = precio;
        this.fecha_solicitud = fecha_solicitud;
        this.persona = persona;
    }

    /**
     * Método para obtener el tipo de trámite.
     *
     * @return El tipo de trámite
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método para establecer el tipo de trámite.
     *
     * @param tipo El tipo de trámite
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método para obtener el objeto Persona asociado al trámite.
     *
     * @return El objeto Persona asociado al trámite
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Método para establecer el objeto Persona asociado al trámite.
     *
     * @param persona El objeto Persona asociado al trámite
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Constructor vacío de la clase Tramite.
     */
    public Tramite() {
    }

}
