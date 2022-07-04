/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojos;

/**
 *
 * @author omar
 */
public class pFactura {
    private String folio;
    private int neto;
    private int iva;
    private int total;
    private String fecha;
    private String fCod_metodo;
    private String fRut;

    public pFactura() {
    }

    public pFactura(String folio, int neto, int iva, int total, String fecha, String fCod_metodo, String fRut) {
        this.folio = folio;
        this.neto = neto;
        this.iva = iva;
        this.total = total;
        this.fecha = fecha;
        this.fCod_metodo = fCod_metodo;
        this.fRut = fRut;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio.toUpperCase();
    }

    public int getNeto() {
        return neto;
    }

    public void setNeto(int neto) {
        this.neto = neto;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getfCod_metodo() {
        return fCod_metodo;
    }

    public void setfCod_metodo(String fCod_metodo) {
        this.fCod_metodo = fCod_metodo.toUpperCase();
    }

    public String getfRut() {
        return fRut;
    }

    public void setfRut(String fRut) {
        this.fRut = fRut;
    }
    
}
