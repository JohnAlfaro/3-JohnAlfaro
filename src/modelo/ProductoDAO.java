package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;

    Conexion con = new Conexion();
    Connection conexion;

    public List<Producto> listar() {
        List<Producto> listaProductos = new ArrayList<>();
        String sql;
        sql = "SELECT * FROM productos";
        try {
            conexion = con.Conectar();
            stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio(rs.getFloat(3));
                listaProductos.add(producto);
            }

        } catch (SQLException ex) {
        }

        return listaProductos;
    }

    public Producto buscar(int IdProducto) {
        Producto producto = new Producto();
        String sql;
        sql = "SELECT * FROM productos WHERE IdProducto=" + IdProducto;
        try {
            conexion = con.Conectar();
            stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                producto.setId(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio(rs.getFloat(3));
            }

        } catch (SQLException ex) {
        }

        return producto;
    }

    public void añadir(Object[] o) {
        String sql;
        sql = "INSERT INTO productos(Nombre, Precio) VALUES('" + o[0] + "'," + o[1] + ")";

        try {
            conexion = con.Conectar();
            stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
        }

    }

    public void actualizar(Object[] o) {
        String sql;
        sql = "UPDATE productos SET Nombre='" + o[1] + "', Precio =" + o[2] + " WHERE IdProducto=" + o[0];

        try {
            conexion = con.Conectar();
            stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
        }
    }

    public void eliminar(int id) {
        String sql;
        sql = "DELETE FROM productos WHERE IdProducto=" + id;

        try {
            conexion = con.Conectar();
            stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
        }

    }

}
