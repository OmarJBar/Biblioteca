/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.consultas;

import modelo.pojos.pAutor;
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
public class consultasAutor extends conector {

    /**
     * metodo para GUARDAR autor que retorna una sentencia sql utilizando
     * punteros
     *
     * @param autor
     * @return
     */
    public boolean guardar(pAutor autor) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        //insert
        try {
            ps = con.prepareStatement(cadena("insert"));
            ps.setString(1, autor.getCodAutor());
            ps.setString(2, autor.getNombre());
            ps.setString(3, autor.getApellido());

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
     * metodo para MODIFICAR autor que retorna una sentencia sql utilizando
     * punteros
     *
     * @param autor 
     * @return Boolean
     */
    //Update
    public boolean modificar(pAutor autor) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("update"));

            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getApellido());
            ps.setString(3, autor.getCodAutor());

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
     * metodo para ELIMINAR autor que retorna una sentencia sql utilizando
     * punteros
     *
     * @param autor 
     * @return Boolean
     */
    //delete
    public boolean eliminar(pAutor autor) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("delete"));
            ps.setString(1, autor.getCodAutor());
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
     * metodo para BUSCAR autor que retorna una sentencia sql utilizando
     * punteros
     *
     * @param autor  toma como parametro del pojo idioma
     * @return Boolean
     */
    //select
    public boolean buscar(pAutor autor) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;
        ResultSet res = null;

        try {
            ps = con.prepareStatement(cadena("select"));
            ps.setString(1, autor.getCodAutor());

            res = ps.executeQuery();
            if (res.next()) {
                autor.setCodAutor(res.getString("cod_autor"));
                autor.setNombre(res.getString("nombre"));
                autor.setApellido(res.getString("apePat"));

            }
            if (autor.getNombre().equals("")) {
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
     *
     * @param tipo Recibe un String
     * @return retorna una consulta tipo String
     */
    public String cadena(String tipo) {
        String cadenasql = "";
        if (tipo.equals("insert")) {
            cadenasql = "insert into autor(cod_autor,nombre,apePat) values(?,?,?)";

        }
        if (tipo.equals("update")) {
            cadenasql = "UPDATE autor SET  nombre=?, apePat=? WHERE cod_autor=?";

        }
        if (tipo.equals("delete")) {
            cadenasql = "DELETE FROM autor WHERE cod_autor=?";

        }
        if (tipo.equals("select")) {
            cadenasql = "Select* from autor where cod_autor=?";
        }

        return cadenasql;
    }

    /**
     * metodo para cerrar conexion
     *
     * @param con recibe una conexion para cerrarla
     */
    public void cerrarS(Connection con) {
        try {
            con.close();//cerrar la conexion               
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cerrar la base de datos", "error", 0);
        }
    }
}
