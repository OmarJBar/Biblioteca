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
public class pAutor {
    private String codAutor;
    private String nombre;
    private String apellido;

    public pAutor() {
    }

    public pAutor(String codAutor) {
        this.codAutor = codAutor;
    }
    
    

    public pAutor(String codAutor, String nombre, String apellido) {
        this.codAutor = codAutor;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getCodAutor() {
        return codAutor;
    }

    public void setCodAutor(String codAutor) {
        this.codAutor = codAutor.toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
}
