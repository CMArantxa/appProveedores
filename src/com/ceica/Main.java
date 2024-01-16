package com.ceica;

import Controladores.Almacencontrol;

public class Main {
    public static void main(String[] args) {
        Almacencontrol almacen=new Almacencontrol();
        almacen.nuevoProveedor("a","nombre","dir","loc","pro");
        almacen.nuevoProveedor("b","bnombre","bdir","bloc","bpro");
        System.out.println(almacen.toString());
        almacen.modificarProveedor("a","nombre","direccion","localidad","provincia");
        /*
        System.out.println(almacen.toString());
        almacen.borrarProveedor("a");
        System.out.println(almacen.toString());
        almacen.borrarProveedor("b");
        System.out.println(almacen.toString());
        almacen.borrarProveedor("c");
        System.out.println(almacen.toString());

         */
    }

}