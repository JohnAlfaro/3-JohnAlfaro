package modelo;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class VendedorDAO {

    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;

    Conexion con = new Conexion();
    Connection conexion;
    Vendedor ev = new Vendedor();

    public Vendedor Validar(String contrasena, String user) {

        String sql;
        sql = "SELECT * FROM vendedor WHERE Password='" + contrasena +"' AND User='" + user + "'";
        try {
            conexion = con.Conectar();
            stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                ev.setId(rs.getInt(1));
                ev.setContrasena(rs.getString(2));
                ev.setNombre(rs.getString(3));
                ev.setUsuario(rs.getString(4));
            }

        } catch (SQLException ex) {

        }

        return ev;
    }

}
