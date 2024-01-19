package com.ceica;

import com.ceica.Controladores.Almacencontrol;
import com.ceica.Controladores.Logincontroller;
import com.ceica.Modelos.Color;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String usr,pass;
        Almacencontrol almacen = new Almacencontrol();
        Scanner leer=new Scanner(System.in);
        System.out.println("Bienvenido a AppAlmacen");
        System.out.println("Pulse enter para empezar");
        leer.nextLine();
        do {
            System.out.println("Login");
            System.out.println("introduce usuario: ");
            usr= leer.nextLine();
            System.out.println("introduce la password");
            pass= leer.nextLine();
            if(Logincontroller.login(usr,pass)){
                System.out.println("estoy en AppAlmacen");
                menuPrincipalAlmacen(leer,almacen);
            }else{
                System.out.println("usuario o contraseña incorrecta");
            }
        }while (true);
    }

    private static void menuPrincipalAlmacen(Scanner leer, Almacencontrol almacen) {
       String op = "";
        String menuPrincipal= """
                1.Proveedores.
                2.Piezas.
                3.Pedidos.
                4.Salir.
                """;
        do {
            System.out.println(menuPrincipal);
            op= leer.nextLine();
            switch (op){
                case "1":
                    subMenuProveedores(leer,almacen);
                    break;
                case "2":
                    submenuPiezas(leer,almacen);
                    break;
                case "3":
                    break;
                case "4":
                    System.out.println("saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }while(!"4".equals(op));
    }

    private static void submenuPiezas(Scanner leer, Almacencontrol almacen) {
        String op,nombre,color;
        int id,categoria;
        Double precio;
        String menuPiezas= """
                1.Dar de alta pieza.
                2.Cambiar precio
                3.Eliminar pieza.
                4.Salir
                """;
        do {
            System.out.println(menuPiezas);
            op=leer.nextLine();
            switch (op) {
                case "1":
                    almacen.nuevaPieza();

                    System.out.println("Nombre");
                    nombre = leer.nextLine();
                    System.out.println("color");
                    color = leer.nextLine();
                    System.out.println("precio");
                    precio = Double.valueOf(leer.nextLine());
                    break;
                case "2":
                    System.out.println("ID");
                    id = leer.nextInt();
                    System.out.println("introduce el nuevo precio");
                    precio = leer.nextDouble();
                    almacen.cambiarPrecio(id, precio);
                    break;
                case "3":

                    break;
                case "4":
                    System.out.println("saliendo");
                default:
                    System.out.println("Opcion no valida");
            }

        } while (!"4".equals(op));
    }

    private static void subMenuProveedores(Scanner leer, Almacencontrol almacen) {
        String op, cif, nombre, direccion, localidad, provincia;
        String menuProveedores = """
                                
                1.Nuevo proveedor
                2.Editar proveedor
                3.Ver proveedores
                4.Eliminar proveedor
                5.Volve a menú principal""";
        do {
            System.out.println(menuProveedores);
            op = leer.nextLine();
            switch (op) {
                case "1":
                    System.out.println("CIF");
                    cif=leer.nextLine();
                    System.out.println("Nombre");
                    nombre=leer.nextLine();
                    System.out.println("Direccion");
                    direccion= leer.nextLine();
                    System.out.println("Localidad");
                    localidad= leer.nextLine();
                    System.out.println("Provincia");
                    provincia= leer.nextLine();
                    almacen.nuevoProveedor(cif,nombre,direccion,localidad,provincia);
                    break;
                case "2":
                  System.out.println("Introduce el cif");
                    cif= leer.nextLine();
                    if (almacen.buscarProveedorCIF(cif)){
                        editarProveedor(leer,almacen,cif);
                    }else{
                        System.out.println("Proveedor no existe");
                    }
                    break;
                case "3":
                    System.out.println(almacen.verProveedores());
                    break;
                case "4":
                    System.out.println("introduce el CIF");
                    cif= leer.nextLine();
                    if (almacen.buscarProveedorCIF(cif)){
                      almacen.borrarProveedor(cif);
                    }else {
                        System.out.println("No existe proveedor con ese cif");
                    }
                    break;
                case "5":
                    System.out.println("volver a menu principal");
                default:
                    System.out.println("Opcion no valida");
            }
        }while(!"5".equals(op));
            }

    private static void editarProveedor(Scanner leer, Almacencontrol almacen, String cif) {
        String op,dato;
        String editarProveedor= """
                1.Editar nombre
                2.Editar direccion
                3.Editar localidad
                4.Editar provincia
                5.Salir
                """;
        do {
            System.out.println(editarProveedor);
            op=leer.nextLine();
            switch (op) {
                case "1":
                    System.out.println("dime el nuevo nombre");
                    dato = leer.nextLine();
                    almacen.modificarNombreProveedorByCIF(cif, dato);
                    break;

                case "2":
                    System.out.println("dime la nueva direccion");
                    dato = leer.nextLine();
                    almacen.modificarDireccionProveedorByCIF(cif, dato);
                    break;
                case "3":
                    System.out.println("dime la nueva localidad");
                    dato = leer.nextLine();
                    almacen.modificarlocalidadProveedorByCIF(cif, dato);

                    break;
                case "4":
                    System.out.println("dime la nueva provincia");
                    dato = leer.nextLine();
                    almacen.modificarProvinciaProveedorByCIF(cif, dato);
                    break;
                case "5":
                    System.out.println("salir");
                default:
                    System.out.println("Opcion no valida");
            }
        }while (! "5".equals(op));
    }
}