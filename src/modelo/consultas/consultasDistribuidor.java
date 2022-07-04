/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.consultas;

import modelo.pojos.pDistribuidor;
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
public class consultasDistribuidor extends conector{
    /**
     * metodo para GUARDAR distribuidor que retorna una sentencia sql utilizando
     * punteros
     *
     * @param distribuidor  
     * @return
     */
    public boolean guardar(pDistribuidor distribuidor) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("insert"));

            ps.setString(1, distribuidor.getRut());
            ps.setString(2, distribuidor.getNombre());
            ps.setString(3, distribuidor.getPais());
            ps.setString(4, distribuidor.getFono());
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
            return true;

        } catch (SQLException  | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "error al guardar, revise los datos ingresados", "error", 0);
            return false;
        } finally {
            cerrarS(con);
        }
    }

    public boolean modificar(pDistribuidor distribuidor) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("update"));

            ps.setString(1, distribuidor.getNombre());
            ps.setString(2, distribuidor.getPais());
            ps.setString(3, distribuidor.getFono());
            ps.setString(4, distribuidor.getRut());

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

    public boolean eliminar(pDistribuidor distribuidor) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("delete"));
            ps.setString(1, distribuidor.getRut());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
            return true;
        } catch (SQLException  | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "error al eliminar registro, revise el numero de serie", "error", 0);
            return false;
        } finally {
            cerrarS(con);
        }
    }

    public boolean buscar(pDistribuidor distribuidor) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;
        ResultSet res = null;

        try {
            ps = con.prepareStatement(cadena("select"));
            ps.setString(1, distribuidor.getRut());

            res = ps.executeQuery();
            if (res.next()) {
                distribuidor.setRut(res.getString("rut_distrib"));
                distribuidor.setNombre(res.getString("nombre"));
                distribuidor.setPais(res.getString("pais"));
                distribuidor.setFono(res.getString("fono"));
                
            }
            if (distribuidor.getNombre().equals("")) {
                throw new NullPointerException();
            }
            return true;
        } catch (SQLException  | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "error al buscar registro, revise el numero de serie", "error", 0);
            return false;
        } finally {
            cerrarS(con);
        }
    }
    

    public String cadena(String tipo) {
        String cadenasql = "";
        if (tipo.equals("insert")) {
            cadenasql = "insert into distribuidor(rut_distrib,nombre,pais,fono) values(?,?,?,?)";

        }
        if (tipo.equals("update")) {
            cadenasql = "UPDATE distribuidor SET nombre=?, pais=?, fono=? WHERE rut_distrib=?";

        }
        if (tipo.equals("delete")) {
            cadenasql = "DELETE FROM distribuidor WHERE rut_distrib=?";

        }
        if (tipo.equals("select")) {
            cadenasql = "Select* from distribuidor where rut_distrib=?";
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
