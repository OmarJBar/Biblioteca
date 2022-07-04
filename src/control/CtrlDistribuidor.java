/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.consultas.consultasDistribuidor;
import modelo.pojos.pDistribuidor;
import vista.Menu;

/**
 *
 * @author omar
 */
public class CtrlDistribuidor implements ActionListener {
    private pDistribuidor distribuidor;
    private consultasDistribuidor conDistribuidor;
    private Menu vista;

    public CtrlDistribuidor(pDistribuidor distribuidor, consultasDistribuidor conDistribuidor, Menu vista) {
        this.distribuidor = distribuidor;
        this.conDistribuidor = conDistribuidor;
        this.vista = vista;
        
        this.vista.btnDistSave.addActionListener(this);
        this.vista.btnDistMod.addActionListener(this);
        this.vista.btnDistDel.addActionListener(this);
        this.vista.btnDistSearch.addActionListener(this);
    }

    /**
     * metodo que recibe en este caso un evento de MENU
     * 
     * @param e evento
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e){
        
        //guardar
        if (e.getSource() == vista.btnDistSave) {
            distribuidor= new pDistribuidor();
            
            distribuidor.setRut(vista.txtDistRut.getText());
            distribuidor.setNombre(vista.txtDistNombre.getText());
            distribuidor.setPais(vista.txtDistPais.getText());
            distribuidor.setFono(vista.txtDistFono.getText());
            
            conDistribuidor.guardar(distribuidor);
        }

        //modificar
        if (e.getSource() == vista.btnDistMod) {
            distribuidor= new pDistribuidor();
            distribuidor.setRut(vista.txtDistRut.getText());
            distribuidor.setNombre(vista.txtDistNombre.getText());
            distribuidor.setPais(vista.txtDistPais.getText());
            distribuidor.setFono(vista.txtDistFono.getText());

            conDistribuidor.modificar(distribuidor);
        }

        //eliminar
        if (e.getSource() == vista.btnDistDel) {
            distribuidor= new pDistribuidor();
            distribuidor.setRut(vista.txtDistRut.getText());

            conDistribuidor.eliminar(distribuidor);
        }

        //buscar
        if (e.getSource() == vista.btnDistSearch) {
            distribuidor= new pDistribuidor();
            distribuidor.setRut(vista.txtDistRut.getText());
            conDistribuidor.buscar(distribuidor);
            
            vista.txtDistNombre.setText(distribuidor.getNombre());
            vista.txtDistPais.setText(distribuidor.getPais());
            vista.txtDistFono.setText(distribuidor.getFono());
            
        }
    }
}
