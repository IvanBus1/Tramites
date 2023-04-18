package GUI;

/**
 * Clase para generar el reporte en pdf
 *
 * @author IVAN
 */
public class Reportepdf {

    /**
     * Atributo que representa el nombre de la persona
     */
    private String nombre;
    /**
     * Atributo que representa el tipo del tramite
     */
    private String tipo;
    /**
     * Atributo que representa el costo del tramite
     */
    private String costo;
    /**
     * Atributo que representa la fecha
     */
    private String fecha;

    /**
     *
     * Constructor por defecto de la clase Reportepdf.
     */
    public Reportepdf() {
    }

    /**
     *
     * Constructor de la clase Reportepdf que inicializa los datos del reporte.
     *
     * @param nombre El nombre del reporte
     * @param tipo El tipo del reporte
     * @param Costo El costo del reporte
     * @param fecha La fecha del reporte
     */
    public Reportepdf(String nombre, String tipo, String Costo, String fecha) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.costo = Costo;
        this.fecha = fecha;
    }

    /**
     *
     * Método getter para obtener el nombre del reporte.
     *
     * @return El nombre del reporte
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * Método setter para establecer el nombre del reporte.
     *
     * @param nombre El nombre del reporte
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * Método getter para obtener el tipo del reporte.
     *
     * @return El tipo del reporte
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * Método setter para establecer el tipo del reporte.
     *
     * @param tipo El tipo del reporte
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * Método getter para obtener el costo del reporte.
     *
     * @return El costo del reporte
     */
    public String getCosto() {
        return costo;
    }

    /**
     *
     * Método setter para establecer el costo del reporte.
     *
     * @param Costo El costo del reporte
     */
    public void setCosto(String Costo) {
        this.costo = Costo;
    }

    /**
     *
     * Método getter para obtener la fecha del reporte.
     *
     * @return La fecha del reporte
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * Método setter para establecer la fecha del reporte.
     *
     * @param fecha La fecha del reporte
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
