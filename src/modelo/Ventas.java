package modelo;

public class Ventas {

    int idVenta, idOrden, idProducto, cantidad;
    float totalVenta;
    Producto producto;

    public Ventas() {
    }

    public Ventas(int idVenta, int idOrden, int idProducto, int cantidad, Producto producto) {
        this.idVenta = idVenta;
        this.idOrden = idOrden;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
    
}

