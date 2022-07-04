/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.consultas;

import modelo.pojos.pIdioma;
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
public class consultasIdioma extends conector {

    /**
     * metodo para GUARDAR idiomas que retorna una sentencia sql utilizando
     * punteros
     *
     * @param idioma toma como parametro del pojo idioma
     * @return
     */
    public boolean guardar(pIdioma idioma) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("insert"));

            ps.setString(1, idioma.getCodIdioma());
            ps.setString(2, idioma.getLengua());

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
     * metodo para MODIFICAR idiomas que retorna una sentencia sql utilizando
     * punteros
     *
     * @param idioma toma como parametro del pojo idioma
     * @return
     */
    public boolean modificar(pIdioma idioma) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("update"));

            ps.setString(1, idioma.getLengua());
            ps.setString(2, idioma.getCodIdioma());

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
     * metodo para ELIMINAR idiomas que retorna una sentencia sql utilizando
     * punteros
     *
     * @param idioma toma como parametro del pojo idioma
     * @return
     */
    public boolean eliminar(pIdioma idioma) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("delete"));
            ps.setString(1, idioma.getCodIdioma());

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
     * metodo para BUSCAR idiomas que retorna una sentencia sql utilizando
     * punteros
     *
     * @param idioma toma como parametro del pojo idioma
     * @return
     */
    public boolean buscar(pIdioma idioma) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;
        ResultSet res = null;

        try {
            ps = con.prepareStatement(cadena("select"));
            ps.setString(1, idioma.getCodIdioma());

            res = ps.executeQuery();
            if (res.next()) {
                idioma.setCodIdioma(res.getString("cod_idioma"));
                idioma.setLengua(res.getString("lengua"));

            }
            if (idioma.getLengua().equals("")) {
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
     * metodo que realiza consultas
     * @param tipo Recibe un String
     * @return retorna una consulta tipo String
     */
    private String cadena(String tipo) {
        String cadenasql = "";
        if (tipo.equals("insert")) {
            cadenasql = "insert into idioma(cod_idioma,lengua) values(?,?)";

        }
        if (tipo.equals("update")) {
            cadenasql = "UPDATE idioma SET lengua=? WHERE cod_idioma=?";

        }
        if (tipo.equals("delete")) {
            cadenasql = "DELETE FROM idioma WHERE cod_idioma=?";

        }
        if (tipo.equals("select")) {
            cadenasql = "Select* from idioma where cod_idioma=?";
        }

        return cadenasql;

    }
    
    /**
     * metodo para cerrar conexion 
     * @param con recibe una conexion para cerrarla
     */
    private void cerrarS(Connection con) {
        try {
            con.close();//cerrar la conexion               
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cerrar la base de datos", "error", 0);
        }
    }
}
