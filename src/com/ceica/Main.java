package com.ceica;

import Controladores.Almacencontrol;

public class Main {
    public static void main(String[] args) {
        Almacencontrol almacen=new Almacencontrol();
        almacen.nuevoProveedor("a","nombre","dir","loc","pro");
        System.out.println(almacen.toString());
    }
}