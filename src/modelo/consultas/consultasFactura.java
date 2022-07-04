/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.consultas;

import modelo.pojos.pFactura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.conector;

/**
 *
 * @author omar
 */
public class consultasFactura extends conector {
    
    /**
     * metodo para GUARDAR facturas que retorna una sentencia sql utilizando
     * punteros
     *
     * @return
     */

    public boolean guardar(pFactura factura) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("insert"));
            ps.setString(1, factura.getFolio());
            ps.setInt(2, factura.getNeto());
            ps.setInt(3, factura.getIva());
            ps.setInt(4, factura.getTotal());
            ps.setString(5, factura.getFecha());
            ps.setString(6, factura.getfCod_metodo());
            ps.setString(7, factura.getfRut());
            
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
     * metodo para MODIFICAR libros que retorna una sentencia sql utilizando
     * punteros
     *
     * @param factura objeto de tipo libro
     * @return
     */
    public boolean modificar(pFactura factura) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("update"));
            ps.setInt(2, factura.getNeto());
            ps.setInt(3, factura.getIva());
            ps.setInt(4, factura.getTotal());
            ps.setString(5, factura.getFecha());
            ps.setString(6, factura.getfCod_metodo());
            ps.setString(7, factura.getfRut());
            ps.setString(5, factura.getFolio());
            
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
     * metodo para ELIMINAR libros que retorna una sentencia sql utilizando
     * punteros
     *
     * @param factura objeto de tipo libro
     * @return
     */
    public boolean eliminar(pFactura factura) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("delete"));
            ps.setString(1, factura.getFolio());
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
     * metodo para BUSCAR libros que retorna una sentencia sql utilizando
     * punteros
     *
     * @param factura objeto de tipo libro
     * @return
     */
    public boolean buscar(pFactura factura) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;
        ResultSet res = null;

        try {
            ps = con.prepareStatement(cadena("select"));
            ps.setString(1, factura.getFolio());

            res = ps.executeQuery();
            if (res.next()) {

                factura.setFolio(res.getString("folio"));
                factura.setNeto(res.getInt("precio_neto"));
                factura.setIva(res.getInt("costo_iva"));
                factura.setTotal(res.getInt("precio_total"));
                factura.setFecha(res.getString("fecha_compra"));
                factura.setfCod_metodo(res.getString("cod_metodo"));
                factura.setfRut(res.getString("rut_distrib"));
            }
            if (factura.getfCod_metodo().equals("")) {
                throw new SQLException();
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
     * Metodo utilizado para llenar jComboBox de distribuidor
     *
     * @return RETORNA un arraylist para un jCombo
     */
    public ArrayList<String> fillComboDistrib() {
        Connection con = this.getConnection();
        PreparedStatement ps = null;
        ResultSet res = null;

        ArrayList<String> lista = new ArrayList<>();
        try {
            ps = con.prepareStatement(combo("distrib"));
            res = ps.executeQuery();

            while (res.next()) {
                lista.add(res.getString("rut_distrib"));
            }
        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar Combobox", "error", 0);

        } finally {
            cerrarS(con);
        }

        return lista;
    }
    /**
     * Metodo utilizado para llenar jComboBox de metodos de pagos
     * @return  RETORNA un arraylist para un jCombo
     */
    public ArrayList<String> fillComboMetodo() {
        Connection con = this.getConnection();
        PreparedStatement ps = null;
        ResultSet res = null;

        ArrayList<String> lista = new ArrayList<>();
        try {
            ps = con.prepareStatement(combo("metodo"));
            res = ps.executeQuery();

            while (res.next()) {
                lista.add(res.getString("cod_metodo"));
            }
        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar Combobox", "error", 0);

        } finally {
            cerrarS(con);
        }

        return lista;
    }
    
    private String cadena(String tipo) {

        String cadenasql = "";
        if (tipo.equals("insert")) {
            cadenasql = "insert into factura(folio,precio_neto,costo_iva,precio_total,fecha_compra,cod_metodo,rut_distrib) values(?,?,?,?,?,?,?)";
        }
        if (tipo.equals("update")) {
            cadenasql = "UPDATE factura SET  precio_neto=?, costo_iva=?, precio_total=?, fecha_compra=?, cod_metodo=?, rut_distrib=? WHERE folio=?";
        }
        if (tipo.equals("delete")) {
            cadenasql = "DELETE FROM factura WHERE folio=?";
        }
        if (tipo.equals("select")) {
            cadenasql = "Select* from factura where folio=?";
        }
        return cadenasql;
    }

    private String combo(String tipo) {
        String cadenasql = "";
        if (tipo.equals("distrib")) {
            cadenasql = "select* from distribuidor";
        }if (tipo.equals("metodo")) {
            cadenasql = "select* from metodo_pago";
        }
        return cadenasql;
    }

    private void cerrarS(Connection con) {
        try {
            con.close();//cerrar la conexion               
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cerrar la base de datos", "error", 0);
        }
    }
}
