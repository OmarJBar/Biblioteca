/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.consultas;

import modelo.pojos.pEditorial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.conector;
import modelo.conector;

/**
 *
 * @author omar
 */

//UPDATE editorial SET nombre=? WHERE cod_editorial=? 


public class consultasEditorial extends conector{
    /**
     * metodo para GUARDAR editorial que retorna una sentencia sql utilizando
     * punteros
     *
     * @param e 
     * @return
     */
    public boolean guardar(pEditorial e) {
        
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("insert"));
            ps.setString(1, e.getCod_editorial().toLowerCase());
            ps.setString(2, e.getNombre());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
            return true;

        } catch (SQLException  | NullPointerException error) {
            JOptionPane.showMessageDialog(null, "error al guardar", "error", 0);
            return false;
        } finally {

            cerrarS(con);
        }
    }

    
    public boolean modificar(pEditorial e) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("update"));
            
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getCod_editorial().toLowerCase());
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
            return true;
        } catch (SQLException  | NullPointerException error) {
            JOptionPane.showMessageDialog(null, "error al modificar", "error", 0);
            return false;
        } finally {
            cerrarS(con);
        }
    }

    
    public boolean eliminar(pEditorial e) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("delete"));
            ps.setString(1, e.getCod_editorial().toLowerCase());
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
            return true;
        } catch (SQLException  | NullPointerException error) {
            JOptionPane.showMessageDialog(null, "error al eliminar registro", "error", 0);
            return false;
        } finally {
            cerrarS(con);
        }
    }

    
    public boolean buscar(pEditorial e) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;
        ResultSet res=null;
        
        
        try {
            ps = con.prepareStatement(cadena("select"));
            ps.setString(1, e.getCod_editorial().toLowerCase());
            
            res=ps.executeQuery();
            if (res.next()) {
                e.setCod_editorial(res.getString("cod_editorial"));
                e.setNombre(res.getString("nombre"));
   
            }
            if (e.getNombre().equals("")) {
                throw new NullPointerException();
            }
            return true;
        } catch (SQLException   | NullPointerException error) {
            JOptionPane.showMessageDialog(null, "error al buscar registro", "error", 0);
            return false;
        } finally {
            cerrarS(con);
        }
    }

    public String cadena(String tipo){
        String cadenasql="";
        if (tipo.equals("insert")) {
            cadenasql="insert into editorial(cod_editorial, nombre) values(?,?)";
            
        }if (tipo.equals("update")) {
            cadenasql="UPDATE editorial SET  nombre=? WHERE cod_editorial=?";
            
        }if (tipo.equals("delete")) {
            cadenasql="DELETE FROM editorial WHERE cod_editorial=?";
            
        }if (tipo.equals("select")) {
            cadenasql="Select* from editorial where cod_editorial=?";
        }
        
        return cadenasql;
    }
    
    public void cerrarS(Connection con) {
        try {
            con.close();//cerrar la conexion               
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "No se pudo cerrar la base de datos", "error", 0);
        }
    }
}
