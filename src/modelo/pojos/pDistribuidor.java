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
public class pDistribuidor {
    private String rut;
    private String nombre;
    private String pais;
    private String fono;

    public pDistribuidor() {
    }

    public pDistribuidor(String rut) {
        this.rut = rut;
    }

    public pDistribuidor(String rut, String nombre, String pais, String fono) {
        this.rut = rut;
        this.nombre = nombre;
        this.pais = pais;
        this.fono = fono;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais.toUpperCase();
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }
    
}
