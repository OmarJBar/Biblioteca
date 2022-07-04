
package modelo.pojos;


public class pLibro {
    private String serie;
    private String isbn;
    private String nomLibro;
    private int precio;
    private String cod;
    private String idiomaLibro;
    
    
    
    public pLibro() {
    }

    public pLibro(String serie, String isbn, String nomLibro, int precio, String cod) {
        this.serie = serie;
        this.isbn = isbn;
        this.nomLibro = nomLibro;
        this.precio = precio;
        this.cod = cod;
    }

    public pLibro(String serie, String isbn, String nomLibro, int precio, String cod, String idiomaLibro) {
        this.serie = serie;
        this.isbn = isbn;
        this.nomLibro = nomLibro;
        this.precio = precio;
        this.cod = cod;
        this.idiomaLibro = idiomaLibro;
    }
    

    public pLibro(String serie) {
        this.serie = serie;
    }

    
    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie.toUpperCase();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn.toUpperCase();
    }

    public String getNomLibro() {
        return nomLibro;
    }

    public void setNomLibro(String nomLibro) {
        this.nomLibro = nomLibro;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getIdiomaLibro() {
        return idiomaLibro;
    }

    public void setIdiomaLibro(String idiomaLibro) {
        this.idiomaLibro = idiomaLibro;
    }
    
    

    
}
