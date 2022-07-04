/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.time.LocalDate.now;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.consultas.consultasFactura;
import modelo.pojos.pFactura;

import vista.Menu;

/**
 *
 * @author omar
 */
public class CtrlFactura implements ActionListener {

    private pFactura factura;
    private consultasFactura conFactura;
    private Menu vista;

    public CtrlFactura(pFactura factura, consultasFactura conFactura, Menu vista) {
        this.factura = factura;
        this.conFactura = conFactura;
        this.vista = vista;
        this.vista.btnFacturaSave.addActionListener(this);
        this.vista.btnFacturaMod.addActionListener(this);
        this.vista.btnFacturaDel.addActionListener(this);
        this.vista.btnFacturaSearch.addActionListener(this);
        this.vista.btnFacturas.addActionListener(this);
    }

    /**
     * metodo que recibe en este caso un evento de MENU
     * 
     * @param e evento
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnFacturas) {
            comboBoxs();
        }

        //guardar
        if (e.getSource() == vista.btnFacturaSave) {
            factura = new pFactura();
            factura.setFolio(vista.txtFacturaFolio.getText());
            factura.setNeto(Integer.valueOf(vista.txtFacturaNeto.getText()));
            factura.setIva(Integer.valueOf(vista.txtFacturaNeto.getText()));
            factura.setTotal(Integer.parseInt(vista.txtFacturaTotal.getText()));
            factura.setFecha(fecha());
            factura.setfCod_metodo(vista.jComboFacturaM.getSelectedItem().toString());
            factura.setfRut(vista.jComboFacturaD.getSelectedItem().toString());
            conFactura.guardar(factura);
            comboBoxs();
        }

        //modificar
        if (e.getSource() == vista.btnFacturaMod) {
            factura = new pFactura();
            factura.setFolio(vista.txtFacturaFolio.getText());
            factura.setNeto(Integer.valueOf(vista.txtFacturaNeto.getText()));
            factura.setIva(Integer.valueOf(vista.txtFacturaNeto.getText()));
            factura.setTotal(Integer.valueOf(vista.txtFacturaTotal.getText()));
            factura.setFecha(fecha());
            factura.setfCod_metodo(vista.jComboFacturaM.getSelectedItem().toString());
            factura.setfRut(vista.jComboFacturaD.getSelectedItem().toString());

            conFactura.modificar(factura);
        }

        //eliminar
        if (e.getSource() == vista.btnFacturaDel) {
            factura = new pFactura();
            factura.setFolio(vista.txtFacturaFolio.getText());

            conFactura.eliminar(factura);
        }

        //buscar
        if (e.getSource() == vista.btnFacturaSearch) {
            factura = new pFactura();
            factura.setFolio(vista.txtFacturaFolio.getText());
            conFactura.buscar(factura);

            vista.txtFacturaNeto.setText(String.valueOf(factura.getNeto()));
            vista.txtFacturaIva.setText(String.valueOf(factura.getIva()));
            vista.txtFacturaTotal.setText(String.valueOf(factura.getTotal()));
            vista.txtFacturaDate.setText(factura.getFecha());
            vista.txtFacturaCod.setText(factura.getfCod_metodo());
            vista.txtFacturaRut.setText(factura.getfRut());
        }
    }

    private String fecha() {
        String fecha = "";
        try {
            Date date = vista.jDateFactura.getDate();
            long d = date.getTime();
            java.sql.Date fechas = new java.sql.Date(d);
            fecha = (fechas.toString());
            return fecha;

        }catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error en  la fecha");
        }
        return fecha;

    }

    private void comboBoxs() {
        vista.jComboFacturaD.removeAllItems();
        ArrayList<String> listaD = new ArrayList<>();
        listaD = conFactura.fillComboDistrib();
        for (String string : listaD) {
            vista.jComboFacturaD.addItem(string);
        }

        vista.jComboFacturaM.removeAllItems();
        ArrayList<String> listaM = new ArrayList<>();
        listaM = conFactura.fillComboMetodo();
        for (String string : listaM) {
            vista.jComboFacturaM.addItem(string);
        }
    }

}
