package modelo.consultas;

import modelo.pojos.pLibro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.conector;

public class consultasLibro extends conector {

    /**
     * metodo para GUARDAR libros que retorna una sentencia sql utilizando
     * punteros
     *
     * @param l objeto tipo libro
     * @return
     */
    public boolean guardar(pLibro l) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("insert"));
            ps.setString(1, l.getSerie());
            ps.setString(2, l.getIsbn());
            ps.setString(3, l.getNomLibro());
            ps.setInt(4, l.getPrecio());
            ps.setString(5, l.getCod());
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
     * @param l objeto de tipo libro
     * @return
     */
    public boolean modificar(pLibro l) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("update"));

            ps.setString(1, l.getIsbn());
            ps.setString(2, l.getNomLibro());
            ps.setInt(3, l.getPrecio());
            ps.setString(4, l.getCod());
            ps.setString(5, l.getSerie());
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
     * @param l objeto de tipo libro
     * @return
     */
    public boolean eliminar(pLibro l) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(cadena("delete"));
            ps.setString(1, l.getSerie());
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
     * @param l objeto de tipo libro
     * @return
     */
    public boolean buscar(pLibro l) {
        Connection con = this.getConnection();
        PreparedStatement ps = null;
        ResultSet res = null;

        try {
            ps = con.prepareStatement(cadena("select"));
            ps.setString(1, l.getSerie());

            res = ps.executeQuery();
            if (res.next()) {

                l.setSerie(res.getString("serie"));
                l.setIsbn(res.getString("isbn"));
                l.setNomLibro(res.getString("titulo"));
                l.setPrecio(res.getInt("precio"));
                l.setCod(res.getString("cod_editorial"));
            }
            if (l.getNomLibro().equals("")) {
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
     * Metodo utilizado para llenar jComboBox
     * @return RETORNA objetos de tipo arraylist para un jCombo
     */
    public ArrayList<String> fillComboEditorial() {
        Connection con = this.getConnection();
        PreparedStatement ps = null;
        ResultSet res = null;

        ArrayList<String> lista = new ArrayList<>();
        try {
            ps = con.prepareStatement(combo("editorial"));
            res = ps.executeQuery();

            while (res.next()) {
                lista.add(res.getString("cod_editorial"));
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
            cadenasql = "insert into libro(serie,isbn,titulo,precio,cod_editorial) values(?,?,?,?,?)";
        }
        if (tipo.equals("update")) {
            cadenasql = "UPDATE libro SET  isbn=?, titulo=?, precio=?, cod_editorial=? WHERE serie=?";
        }
        if (tipo.equals("delete")) {
            cadenasql = "DELETE FROM libro WHERE serie=?";
        }
        if (tipo.equals("select")) {
            cadenasql = "Select* from libro where serie=?";
        }
        return cadenasql;
    }

    private String combo(String tipo) {
        String cadenasql = "";
        if (tipo.equals("editorial")) {
            cadenasql = "select* from editorial";
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
