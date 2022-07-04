/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.CtrlAutor;
import control.CtrlCategoria;
import control.CtrlDistribuidor;

import control.CtrlEditorial;
import control.CtrlFactura;
import control.CtrlIdioma;
import control.CtrlLibro;
import control.CtrlMetodos;
import modelo.consultas.consultasAutor;
import modelo.consultas.consultasCategoria;
import modelo.consultas.consultasDistribuidor;
import modelo.consultas.consultasEditorial;
import modelo.consultas.consultasFactura;
import modelo.consultas.consultasIdioma;
import modelo.consultas.consultasLibro;
import modelo.consultas.consultasMetodos;
import modelo.pojos.pAutor;
import modelo.pojos.pDistribuidor;
import modelo.pojos.pEditorial;
import modelo.pojos.pFactura;
import modelo.pojos.pIdioma;
import modelo.pojos.pLibro;
import modelo.pojos.pMetodos;

/**
 *
 * @author omar
 */
public class Main {

    public static void main(String[] args) {
        
        //llamadas a las consultas       
        consultasEditorial consultasEditorial = new consultasEditorial();
        consultasLibro consultasLibro = new consultasLibro();
        consultasAutor consultasAutor=new consultasAutor();
        consultasIdioma consultasIdioma=new consultasIdioma();
        consultasCategoria consultasCategoria=new consultasCategoria();
        consultasDistribuidor consultasDistribuidor=new consultasDistribuidor();
        consultasMetodos consultasMetodos=new consultasMetodos();
        consultasFactura consultasFactura=new consultasFactura();
        //llamadas a las consultas
        
        //llamadas a los pojos
        pLibro libro = new pLibro();
        pEditorial editorial = new pEditorial();
        pAutor autor=new pAutor();
        pIdioma idioma=new pIdioma();
        pDistribuidor distribuidor=new pDistribuidor();
        pMetodos metodo=new pMetodos();
        pFactura factura=new pFactura();
        //llamadas a los pojos
        
        Menu vista = new Menu();
        
        //llamadas a los controles
        CtrlLibro CtrlLibro = new CtrlLibro(libro, consultasLibro, vista);
        CtrlEditorial CtrlEditorial = new CtrlEditorial(editorial, consultasEditorial, vista);        
        CtrlAutor CtrlAutor=new CtrlAutor(autor, consultasAutor, vista);
        CtrlIdioma CtrlIdioma=new CtrlIdioma(idioma, consultasIdioma, vista);
        CtrlCategoria CtrlCategoria=new CtrlCategoria(consultasCategoria, vista);    
        CtrlDistribuidor CtrlDistribuidor=new CtrlDistribuidor(distribuidor, consultasDistribuidor, vista);
        CtrlMetodos CtrlMetodos=new CtrlMetodos(metodo, consultasMetodos, vista);
        CtrlFactura CtrlFactura=new CtrlFactura(factura, consultasFactura, vista);
        //llamadas a los controles  
        
        vista.setVisible(true);
        
    }
}
