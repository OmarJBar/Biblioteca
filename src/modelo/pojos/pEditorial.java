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
public class pEditorial {
    private String cod_editorial;
    private String nombre;

    public pEditorial() {
    }

    public pEditorial(String cod_editorial) {
        this.cod_editorial = cod_editorial;
    }

    
    public pEditorial(String cod_editorial, String nombre) {
        this.cod_editorial = cod_editorial;
        this.nombre = nombre;
    }

    public String getCod_editorial() {
        return cod_editorial;
    }

    public void setCod_editorial(String cod_editorial) {
        this.cod_editorial = cod_editorial.toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
