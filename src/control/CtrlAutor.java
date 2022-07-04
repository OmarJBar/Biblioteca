/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.consultas.consultasAutor;
import modelo.pojos.pAutor;
import vista.Menu;

/**
 *
 * @author omar
 */
public class CtrlAutor implements ActionListener {

    private pAutor autor;
    private consultasAutor conAutor;
    private Menu vista;

    public CtrlAutor() {
    }

    public CtrlAutor(pAutor autor, consultasAutor conAutor, Menu vista) {
        this.autor = autor;
        this.conAutor = conAutor;
        this.vista = vista;
        this.vista.btnSaveAutor.addActionListener(this);
        this.vista.btnModAutor.addActionListener(this);
        this.vista.btnDelAutor.addActionListener(this);
        this.vista.btnSearchAutor.addActionListener(this);
    }

    /**
     * metodo que recibe en este caso un evento de MENU
     *
     * @param e evento
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //guardar
        if (e.getSource() == vista.btnSaveAutor) {
            autor = new pAutor();
            autor.setCodAutor(vista.txtCodAutor.getText());
            autor.setNombre(vista.txtNombreAutor.getText());
            autor.setApellido(vista.txtApeAutor.getText());

            conAutor.guardar(autor);
        }

        //modificar
        if (e.getSource() == vista.btnModAutor) {
            autor = new pAutor();
            autor.setCodAutor(vista.txtCodAutor.getText());
            autor.setNombre(vista.txtNombreAutor.getText());
            autor.setApellido(vista.txtApeAutor.getText());

            conAutor.modificar(autor);
        }

        //eliminar
        if (e.getSource() == vista.btnDelAutor) {
            autor = new pAutor();
            autor.setCodAutor(vista.txtCodAutor.getText());

            conAutor.eliminar(autor);
        }

        //buscar
        if (e.getSource() == vista.btnSearchAutor) {
            autor = new pAutor();
            autor.setCodAutor(vista.txtCodAutor.getText());
            conAutor.buscar(autor);

            vista.txtNombreAutor.setText(autor.getNombre());
            vista.txtApeAutor.setText(autor.getApellido());

        }
    }
}
