/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.consultas.consultasCategoria;

import modelo.pojos.pCategoria;

import vista.Menu;

/**
 *
 * @author omar
 */
public class CtrlCategoria implements ActionListener {

    private pCategoria categoria;
    private consultasCategoria conCategoria;
    private Menu vista;

    public CtrlCategoria() {
    }

    public CtrlCategoria(consultasCategoria conCategoria, Menu vista) {
        this.conCategoria = conCategoria;
        this.vista = vista;
        this.vista.btnSaveCategoria.addActionListener(this);
        this.vista.btnModCategoria.addActionListener(this);
        this.vista.btnDelCategoria.addActionListener(this);
        this.vista.btnSearchCategoria.addActionListener(this);
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
        if (e.getSource() == vista.btnSaveCategoria) {
            categoria = new pCategoria();
            
            categoria.setCod_categoria(vista.txtCodCategoria.getText());
            categoria.setNombre(vista.txtNomCategoria.getText());

            conCategoria.guardar(categoria);
        }

        //modificar
        if (e.getSource() == vista.btnModCategoria) {
            categoria = new pCategoria();
            
            categoria.setCod_categoria(vista.txtCodCategoria.getText());
            categoria.setNombre(vista.txtNomCategoria.getText());

            conCategoria.modificar(categoria);
        }

        //eliminar
        if (e.getSource() == vista.btnDelCategoria) {
            categoria = new pCategoria();
            
            categoria.setCod_categoria(vista.txtCodCategoria.getText());

            conCategoria.eliminar(categoria);
        }

        //buscar
        if (e.getSource() == vista.btnSearchCategoria) {
            categoria = new pCategoria();
            
            categoria.setCod_categoria(vista.txtCodCategoria.getText());
            conCategoria.buscar(categoria);

            vista.txtNomCategoria.setText(categoria.getNombre());
        }
    }
}
