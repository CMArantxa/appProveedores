package com.ceica.Modelos;

import java.time.LocalDate;

public class Pedido {
    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +"\n"+
                ", piezas=" + piezas +"\n"+
                ", proveedor=" + proveedor +"\n"+
                ", fecha=" + fecha +"\n"+
                ", cantidad=" + cantidad +"\n"+
                '}'+"\n";
    }

    private int id;
    private Piezas piezas;
    private Proveedor proveedor;
    private LocalDate fecha;
    private int cantidad;

    public Pedido() {
    }

    public Pedido(Piezas piezas, Proveedor proveedor) {
        this.piezas = piezas;
        this.proveedor = proveedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Piezas getPiezas() {
        return piezas;
    }

    public void setPiezas(Piezas piezas) {
        this.piezas = piezas;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
