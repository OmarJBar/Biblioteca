/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.pojos.pEditorial;
import modelo.consultas.consultasEditorial;
import vista.Menu;

/**
 *
 * @author omar
 */
public class CtrlEditorial implements ActionListener {

    private pEditorial editorial;
    private consultasEditorial conEditorial;
    private Menu vista;

    public CtrlEditorial(pEditorial editorial, consultasEditorial conEditorial, Menu vista) {
        this.editorial = editorial;
        this.conEditorial = conEditorial;
        this.vista = vista;
        this.vista.btnSaveEditorial.addActionListener(this);
        this.vista.btnModEditorial.addActionListener(this);
        this.vista.btnDelEditorial.addActionListener(this);
        this.vista.btnSearchEditorial.addActionListener(this);

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
        if (e.getSource() == vista.btnSaveEditorial) {
            editorial=new pEditorial();
            editorial.setCod_editorial(vista.txtCodEditorial.getText());
            editorial.setNombre(vista.txtNomEditorial.getText());

            conEditorial.guardar(editorial);
        }

        //modificar
        if (e.getSource() == vista.btnModEditorial) {
            editorial=new pEditorial();
            editorial.setCod_editorial(vista.txtCodEditorial.getText());
            editorial.setNombre(vista.txtNomEditorial.getText());

            conEditorial.modificar(editorial);
        }

        //eliminar
        if (e.getSource() == vista.btnDelEditorial) {
            editorial=new pEditorial();
            editorial.setCod_editorial(vista.txtCodEditorial.getText());

            conEditorial.eliminar(editorial);
        }

        //buscar
        if (e.getSource() == vista.btnSearchEditorial) {
            editorial=new pEditorial();
            editorial.setCod_editorial(vista.txtCodEditorial.getText());
            conEditorial.buscar(editorial);
            
            vista.txtNomEditorial.setText(editorial.getNombre());

        }

    }

}
