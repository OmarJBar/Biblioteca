package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conector {

    private static final String name = "newbiblioteca";
    private static final String user = "root";
    private static final String pass = "root";
    private static final String url = "jdbc:mysql://localhost:3306/newbiblioteca";

    private Connection con = null;

    /**
     *
     * metodo para hacer la conexion a la base de datos
     *
     * @return 
     */
    public Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            // conexion a la DB

            con = (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            

        } // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e) {

            JOptionPane.showMessageDialog(null, "Error de conexion ");

        }
        return con;

    }

}
