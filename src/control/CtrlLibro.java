package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.consultas.consultasLibro;
import modelo.pojos.pLibro;
import vista.Menu;

public class CtrlLibro implements ActionListener {

    private pLibro libro;
    private consultasLibro conLibro;
    private Menu vista;

    public CtrlLibro() {
    }

    public CtrlLibro(pLibro libro, consultasLibro conLibro, Menu vista) {
        this.libro = libro;
        this.conLibro = conLibro;
        this.vista = vista;

        this.vista.btnSaveLibro.addActionListener(this);
        this.vista.btnModLibro.addActionListener(this);
        this.vista.btnDelLibro.addActionListener(this);
        this.vista.btnSearchLibro.addActionListener(this);
        this.vista.btnLibro.addActionListener(this);

    }

    /**
     * metodo que recibe en este caso un evento de MENU
     * 
     * @param e evento
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnLibro) {
            combo();
        }

        //guardar
        if (e.getSource() == vista.btnSaveLibro) {
            libro = new pLibro();
            libro.setSerie(vista.txtSerieLibro.getText());
            libro.setIsbn(vista.txtIsbnLibro.getText());
            libro.setNomLibro(vista.txtIsbnLibro.getText());
            libro.setPrecio(Integer.valueOf(vista.txtPrecioLibro.getText()));
            libro.setCod(vista.jComboBox1.getSelectedItem().toString());

            conLibro.guardar(libro);
            
        }

        //modificar
        if (e.getSource() == vista.btnModLibro) {
            libro = new pLibro();
            libro.setSerie(vista.txtSerieLibro.getText());
            libro.setIsbn(vista.txtIsbnLibro.getText());
            libro.setNomLibro(vista.txtTituloLibro.getText());
            libro.setPrecio(Integer.valueOf(vista.txtPrecioLibro.getText()));
            libro.setCod(vista.jComboBox1.getSelectedItem().toString());

            conLibro.modificar(libro);
        }

        //eliminar
        if (e.getSource() == vista.btnDelLibro) {
            libro = new pLibro();
            libro.setSerie(vista.txtSerieLibro.getText());

            conLibro.eliminar(libro);
        }

        //buscar
        if (e.getSource() == vista.btnSearchLibro) {
            libro = new pLibro();
            libro.setSerie(vista.txtSerieLibro.getText());
            conLibro.buscar(libro);

            vista.txtIsbnLibro.setText(libro.getIsbn());
            vista.txtTituloLibro.setText(libro.getNomLibro());
            vista.txtPrecioLibro.setText(String.valueOf(libro.getPrecio()));
            vista.txtCodEdLibro.setText(libro.getCod());
        }

    }

    private void combo() {
        vista.jComboBox1.removeAllItems();
        ArrayList<String> lista = new ArrayList<>();
        lista = conLibro.fillComboEditorial();
        for (String string : lista) {

            vista.jComboBox1.addItem(string);

        }
    }

}
