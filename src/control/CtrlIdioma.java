/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.consultas.consultasIdioma;
import modelo.pojos.pIdioma;
import vista.Menu;

/**
 *
 * @author omar
 */
public class CtrlIdioma implements ActionListener {

    private pIdioma idioma;
    private consultasIdioma conIdioma;
    private Menu vista;

    public CtrlIdioma() {
    }

    public CtrlIdioma(pIdioma idioma, consultasIdioma conIdioma, Menu vista) {
        this.idioma = idioma;
        this.conIdioma = conIdioma;
        this.vista = vista;
        this.vista.btnSaveIdioma.addActionListener(this);
        this.vista.btnModIdioma.addActionListener(this);
        this.vista.btnDelIdioma.addActionListener(this);
        this.vista.btnSearchIdioma.addActionListener(this);
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
        if (e.getSource() == vista.btnSaveIdioma) {
            idioma=new pIdioma();
            idioma.setCodIdioma(vista.txtCodIdioma.getText());
            idioma.setLengua(vista.txtNomLengua.getText());

            conIdioma.guardar(idioma);
        }

        //modificar
        if (e.getSource() == vista.btnModIdioma) {
            idioma=new pIdioma();
            idioma.setCodIdioma(vista.txtCodIdioma.getText());
            idioma.setLengua(vista.txtNomLengua.getText());

            conIdioma.modificar(idioma);
        }

        //eliminar
        if (e.getSource() == vista.btnDelIdioma) {
            idioma=new pIdioma();
            idioma.setCodIdioma(vista.txtCodIdioma.getText());
           

            conIdioma.eliminar(idioma);
        }

        //buscar
        if (e.getSource() == vista.btnSearchIdioma) {
            idioma=new pIdioma();
            idioma.setCodIdioma(vista.txtCodIdioma.getText());
            conIdioma.buscar(idioma);

            vista.txtNomLengua.setText(idioma.getLengua());
        }
    }
}
