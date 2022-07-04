/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.consultas.consultasMetodos;
import modelo.pojos.pMetodos;
import vista.Menu;

/**
 *
 * @author omar
 */
public class CtrlMetodos implements ActionListener {
    private pMetodos metodo;
    private consultasMetodos conMetodo;
    private Menu vista;
    
    
    public CtrlMetodos(pMetodos metodo, consultasMetodos conMetodo, Menu vista) {
        this.metodo = metodo;
        this.conMetodo = conMetodo;
        this.vista = vista;
        
        this.vista.btnPagoSave.addActionListener(this);
        this.vista.btnPagoMod.addActionListener(this);
        this.vista.btnPagoDel.addActionListener(this);
        this.vista.btnPagoSearch.addActionListener(this);
    }
    
    /**
     * metodo que recibe en este caso un evento de MENU
     * 
     * @param e evento
     * 
     */
    public void actionPerformed(ActionEvent e) {

        //guardar
        if (e.getSource() == vista.btnPagoSave) {
            metodo=new pMetodos();
            metodo.setCod_metodo(vista.txtPagoCod.getText());
            metodo.setNom_metodo(vista.txtPagoNombre.getText());

            conMetodo.guardar(metodo);
        }

        //modificar
        if (e.getSource() == vista.btnPagoMod) {
            metodo=new pMetodos();
            metodo.setCod_metodo(vista.txtPagoCod.getText());
            metodo.setNom_metodo(vista.txtPagoNombre.getText());

            conMetodo.modificar(metodo);
        }

        //eliminar
        if (e.getSource() == vista.btnPagoDel) {
            metodo=new pMetodos();
            metodo.setCod_metodo(vista.txtPagoCod.getText());

            conMetodo.eliminar(metodo);
        }

        //buscar
        if (e.getSource() == vista.btnPagoSearch) {
            metodo=new pMetodos();
            metodo.setCod_metodo(vista.txtPagoCod.getText());
            conMetodo.buscar(metodo);

            vista.txtPagoNombre.setText(metodo.getNom_metodo());
        }
    }
    
}
