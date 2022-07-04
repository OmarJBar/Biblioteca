/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.consultas;

import modelo.pojos.pMetodos;
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
public class consultasMetodos extends conector {

    /**
     * metodo para GUARDAR Metodos de pago que retorna una sentencia sql
     * utilizando punteros
     *
     * @param metodo objeto tipo Metodo de pago
     * @return retorna un booleano para verificar la insercion de datos
     */
    public boolean guardar(pMetodos metodo) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("insert"));

            ps.setString(1, metodo.getCod_metodo());
            ps.setString(2, metodo.getNom_metodo());

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

    /**
     * metodo para MODIFICAR Metodos de pago que retorna una sentencia sql
     * utilizando punteros
     *
     * @param metodo objeto tipo Metodo de pago
     * @return retorna un booleano para verificar la insercion de datos
     */
    public boolean modificar(pMetodos metodo) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("update"));

            ps.setString(1, metodo.getNom_metodo());
            ps.setString(2, metodo.getCod_metodo());

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

    /**
     * metodo para ELIMINAR Metodos de pago que retorna una sentencia sql
     * utilizando punteros
     *
     * @param metodo objeto tipo Metodo de pago
     * @return retorna un booleano para verificar la insercion de datos
     */
    public boolean eliminar(pMetodos metodo) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("delete"));
            ps.setString(1, metodo.getCod_metodo());

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

    /**
     * metodo para BUSCAR Metodos de pago que retorna una sentencia sql
     * utilizando punteros
     *
     * @param metodo objeto tipo Metodo de pago
     * @return retorna un booleano para verificar la insercion de datos
     */
    public boolean buscar(pMetodos metodo) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;
        ResultSet res = null;

        try {
            ps = con.prepareStatement(cadena("select"));
            ps.setString(1, metodo.getCod_metodo());

            res = ps.executeQuery();
            if (res.next()) {
                metodo.setCod_metodo(res.getString("cod_metodo"));
                metodo.setNom_metodo(res.getString("descripcion"));
            }
            if (metodo.getNom_metodo().equals("")) {
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

    /**
     *  metodo para realizar consultas sql
     * @param tipo pide un String para ver que consulta realizara
     * @return 
     */
    public String cadena(String tipo) {
        String cadenasql = "";
        if (tipo.equals("insert")) {
            cadenasql = "insert into metodo_pago(cod_metodo,descripcion) values(?,?)";

        }
        if (tipo.equals("update")) {
            cadenasql = "UPDATE metodo_pago SET descripcion=? WHERE cod_metodo=?";

        }
        if (tipo.equals("delete")) {
            cadenasql = "DELETE FROM metodo_pago WHERE cod_metodo=?";

        }
        if (tipo.equals("select")) {
            cadenasql = "Select* from metodo_pago where cod_metodo=?";
        }

        return cadenasql;

    }
/**
 * metodo para finalizar la conexion
 * @param con recibe una  variable de tipo connection
 */
    public void cerrarS(Connection con) {
        try {
            con.close();//cerrar la conexion               
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cerrar la base de datos", "error", 0);
        }
    }
}
