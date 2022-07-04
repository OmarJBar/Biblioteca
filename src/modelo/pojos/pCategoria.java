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
public class pCategoria {
    private String cod_categoria;
    private String nombre;

    public pCategoria() {
    }

    public pCategoria(String cod_categoria, String nombre) {
        this.cod_categoria = cod_categoria;
        this.nombre = nombre;
    }

    public String getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(String cod_categoria) {
        this.cod_categoria = cod_categoria.toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
