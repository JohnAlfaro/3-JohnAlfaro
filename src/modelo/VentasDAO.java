package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VentasDAO {

    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;

    Producto producto = new Producto();
    ProductoDAO pdao = new ProductoDAO();

    Conexion con = new Conexion();
    Connection conexion;

    public List<Ventas> buscarVentasPorOrden(int IdOrden) {
        List<Ventas> listaVentas = new ArrayList<>();

        String sql;
        sql = "SELECT * FROM ventas WHERE IdOrden=" + IdOrden;
        try {
            conexion = con.Conectar();
            stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Ventas venta = new Ventas();
                venta.setIdVenta(rs.getInt(1));
                venta.setIdProducto(rs.getInt(3));
                venta.setCantidad(rs.getInt(4));
                venta.setTotalVenta(rs.getFloat(5));
                venta.setProducto(pdao.buscar(rs.getInt(3)));
                listaVentas.add(venta);
            }

        } catch (SQLException ex) {
        }

        return listaVentas;
    }
}
