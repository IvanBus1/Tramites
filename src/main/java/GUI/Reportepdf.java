package GUI;

public class Reportepdf {

    private String nombre;
    private String tipo;
    private String costo;
    private String fecha;

    public Reportepdf() {
    }

    public Reportepdf(String nombre, String tipo, String Costo, String fecha) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.costo = Costo;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String Costo) {
        this.costo = Costo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
