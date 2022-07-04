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
public class pIdioma {
    private String codIdioma;
    private String lengua;

    public pIdioma() {
    }

    public pIdioma(String codIdioma, String lengua) {
        this.codIdioma = codIdioma;
        this.lengua = lengua;
    }

    public pIdioma(String codIdioma) {
        this.codIdioma = codIdioma;
    }

    
    public String getCodIdioma() {
        return codIdioma;
    }

    public void setCodIdioma(String codIdioma) {
        this.codIdioma = codIdioma.toUpperCase();
    }

    public String getLengua() {
        return lengua;
    }

    public void setLengua(String lengua) {
        this.lengua = lengua;
    }
    
    
}
