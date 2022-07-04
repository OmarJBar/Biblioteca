/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.consultas;

import modelo.pojos.pCategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.conector;

/**
 *
 * @author omar
 */
public class consultasCategoria extends  conector{
    /**
     * metodo para GUARDAR categoria que retorna una sentencia sql utilizando
     * punteros
     *
     * @param categoria  
     * @return
     */
    public boolean guardar(pCategoria categoria) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("insert"));

            ps.setString(1, categoria.getCod_categoria());
            ps.setString(2, categoria.getNombre());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
            return true;

        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "error al guardar, revise los datos ingresados", "error", 0);
            return false;
        } finally {
            cerrarS(con);
        }
    }

    public boolean modificar(pCategoria categoria) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("update"));

            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getCod_categoria());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
            return true;
        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "error al modificar, revise los datos ingresados", "error", 0);
            return false;
        } finally {
            cerrarS(con);
        }
    }

    public boolean eliminar(pCategoria categoria) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("delete"));
            ps.setString(1, categoria.getCod_categoria());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
            return true;
        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "error al eliminar registro, revise el numero de serie", "error", 0);
            return false;
        } finally {
            cerrarS(con);
        }
    }

    public boolean buscar(pCategoria categoria) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;
        ResultSet res = null;

        try {
            ps = con.prepareStatement(cadena("select"));
            ps.setString(1, categoria.getCod_categoria());

            res = ps.executeQuery();
            if (res.next()) {
                categoria.setCod_categoria(res.getString("cod_categoria"));
                categoria.setNombre(res.getString("nombre"));

            }
            if (categoria.getNombre().equals("")) {
                throw new NullPointerException();
            }
            return true;
        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "error al buscar registro, revise el numero de serie", "error", 0);
            return false;
        } finally {
            cerrarS(con);
        }
    }
    

    public String cadena(String tipo) {
        String cadenasql = "";
        if (tipo.equals("insert")) {
            cadenasql = "insert into categoria(cod_categoria,nombre) values(?,?)";

        }
        if (tipo.equals("update")) {
            cadenasql = "UPDATE categoria SET nombre=? WHERE cod_categoria=?";

        }
        if (tipo.equals("delete")) {
            cadenasql = "DELETE FROM categoria WHERE cod_categoria=?";

        }
        if (tipo.equals("select")) {
            cadenasql = "Select* from categoria where cod_categoria=?";
        }

        return cadenasql;
        
    }

    public void cerrarS(Connection con) {
        try {
            con.close();//cerrar la conexion               
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cerrar la base de datos", "error", 0);
        }
    }
}
