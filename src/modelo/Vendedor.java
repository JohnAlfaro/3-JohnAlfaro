package modelo;

public class Vendedor {

    int id;
    String contrasena, nombre, usuario;

    public Vendedor() {
    }

    public Vendedor(int id, String contrasena, String nombre, String usuario) {
        this.id = id;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

   

}
