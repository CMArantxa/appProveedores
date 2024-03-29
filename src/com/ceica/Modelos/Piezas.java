package com.ceica.Modelos;

public class Piezas {
    private static int idPieza;
    private int id;
    private String nombre;
    private String color;
    private Double precio;
    private Categoria categoria;

    public Piezas(String nombre, String color, Double precio) {
        this.id=idPieza++;
        this.nombre = nombre;
        this.color = color;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Piezas{" +"\n"+
                "id=" + id +"\n"+
                ", nombre='" + nombre + '\n' +
                ", color='" + color + '\n' +
                ", precio=" + precio + "\n"+
                ", categoria=" + categoria +"\n"+
                '}'+"\n";
    }

}
