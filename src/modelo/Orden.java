package modelo;

public class Orden {

    int idOrden, estado;
    String numeroSerie, nombreCliente;
    float totalOrden;

    public Orden() {
    }

    public Orden(int idOrden, String numeroSerie, int estado, String nombreCliente, float totalOrden) {
        this.idOrden = idOrden;
        this.numeroSerie = numeroSerie;
        this.estado = estado;
        this.nombreCliente = nombreCliente;
        this.totalOrden = totalOrden;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public float getTotalOrden() {
        return totalOrden;
    }

    public void setTotalOrden(float totalOrden) {
        this.totalOrden = totalOrden;
    }

}
