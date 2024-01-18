package com.ceica;

import com.ceica.Controladores.Almacencontrol;
import com.ceica.Modelos.Color;

public class Main {
    public static void main(String[] args) {
        Almacencontrol almacen=new Almacencontrol();
        almacen.nuevoProveedor("a","nombre","dir","loc","pro");
        almacen.nuevaPieza("piezaA", Color.AZUL,45.5,1);
        almacen.nuevaPieza("piezaB",Color.AMARILLO,30.00,2);
        System.out.println(almacen.toString());
        almacen.cambiarPrecio(1,29.99);
        System.out.println(almacen.nuevoPedido("a",1,50));
        System.out.println(almacen.getPedidosByPieza(1));
        System.out.println(almacen.getPedidosByProveedor("a"));
        System.out.println(almacen.toString());


    }

}