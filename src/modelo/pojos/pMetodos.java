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
public class pMetodos {
    private String cod_metodo;
    private String nom_metodo;

    public pMetodos() {
    }

    public pMetodos(String cod_metodo) {
        this.cod_metodo = cod_metodo;
    }

    public pMetodos(String cod_metodo, String nom_metodo) {
        this.cod_metodo = cod_metodo;
        this.nom_metodo = nom_metodo;
    }

    public String getCod_metodo() {
        return cod_metodo;
    }

    public void setCod_metodo(String cod_metodo) {
        this.cod_metodo = cod_metodo;
    }

    public String getNom_metodo() {
        return nom_metodo;
    }

    public void setNom_metodo(String nom_metodo) {
        this.nom_metodo = nom_metodo.toUpperCase();
    }
    
    
}
