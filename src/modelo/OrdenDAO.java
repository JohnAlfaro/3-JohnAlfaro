package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdenDAO {

    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;

    Conexion con = new Conexion();
    Connection conexion;

    public String numeroSerie() {
        String serie;
        serie = null;
        String sql;
        sql = "SELECT MAX(NumeroSerie) FROM ordenes";
        try {
            conexion = con.Conectar();
            stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                serie = rs.getString(1);
            }
        } catch (SQLException ex) {
        }
        return serie;

    }

    public String IdOrden() {
        String idOrden = "";
        String sql;
        sql = "SELECT MAX(IdOrden) FROM ordenes";
        try {
            conexion = con.Conectar();
            stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                idOrden = rs.getString(1);
            }
        } catch (SQLException ex) {
        }
        return idOrden;
    }

    public List<Orden> listarCola() {
        List<Orden> listaOrdenes = new ArrayList<>();
        String sql;
        sql = "SELECT * FROM ordenes WHERE Estado=1";
        try {
            conexion = con.Conectar();
            stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Orden orden = new Orden();
                orden.setIdOrden(rs.getInt(1));
                orden.setNumeroSerie(rs.getString(2));
                orden.setNombreCliente(rs.getString(3));
                orden.setTotalOrden(rs.getFloat(5));
                listaOrdenes.add(orden);
            }

        } catch (SQLException ex) {
        }
        return listaOrdenes;
    }

    public List<Orden> listarPreparacion() {
        List<Orden> listaOrdenes = new ArrayList<>();
        String sql;
        sql = "SELECT * FROM ordenes WHERE Estado=2";
        try {
            conexion = con.Conectar();
            stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Orden orden = new Orden();
                orden.setIdOrden(rs.getInt(1));
                orden.setNumeroSerie(rs.getString(2));
                orden.setNombreCliente(rs.getString(3));
                orden.setTotalOrden(rs.getFloat(5));
                listaOrdenes.add(orden);
            }

        } catch (SQLException ex) {
        }
        return listaOrdenes;
    }

    public List<Orden> listarFinalizado() {
        List<Orden> listaOrdenes = new ArrayList<>();
        String sql;
        sql = "SELECT * FROM ordenes WHERE Estado=3";
        try {
            conexion = con.Conectar();
            stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Orden orden = new Orden();
                orden.setIdOrden(rs.getInt(1));
                orden.setNumeroSerie(rs.getString(2));
                orden.setNombreCliente(rs.getString(3));
                orden.setTotalOrden(rs.getFloat(5));
                listaOrdenes.add(orden);
            }

        } catch (SQLException ex) {
        }
        return listaOrdenes;
    }

    public List<Orden> listarEntregado() {
        List<Orden> listaOrdenes = new ArrayList<>();
        String sql;
        sql = "SELECT * FROM ordenes WHERE Estado=4";
        try {
            conexion = con.Conectar();
            stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Orden orden = new Orden();
                orden.setIdOrden(rs.getInt(1));
                orden.setNumeroSerie(rs.getString(2));
                orden.setNombreCliente(rs.getString(3));
                orden.setTotalOrden(rs.getFloat(5));
                listaOrdenes.add(orden);
            }

        } catch (SQLException ex) {
        }
        return listaOrdenes;
    }

    public void guardarOrden(Orden o) {
        int estado = 1;
        String sql;
        sql = "INSERT INTO ordenes(NombreCliente, NumeroSerie, Estado, TotalOrden)"
                + " VALUES('" + o.getNombreCliente() + "','" + o.getNumeroSerie() + "',"
                + estado + "," + o.getTotalOrden() + ")";

        try {
            conexion = con.Conectar();
            stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
        }
    }

    public void guardarVentas(Ventas v) {
        String sql;
        sql = "INSERT INTO ventas(IdOrden, IdProducto, Cantidad, TotalVenta)"
                + " VALUES(" + v.getIdOrden() + "," + v.getIdProducto() + ","
                + v.getCantidad() + "," + v.getTotalVenta() + ")";

        try {
            conexion = con.Conectar();
            stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
        }
    }

    public void actualizaEstado(int idOrden, int estado) {
        String sql;
        sql = "UPDATE ordenes SET Estado=" + estado + " WHERE IdOrden=" + idOrden;

        try {
            conexion = con.Conectar();
            stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
        }
    }
}
