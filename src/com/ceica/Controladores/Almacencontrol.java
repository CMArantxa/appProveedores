package com.ceica.Controladores;

import com.ceica.Modelos.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Es el cuerpo de métodos a utilizar en main.
 * Accede a todos los listados.
 */
public class Almacencontrol {

    private List<Proveedor> proveedorList;
    private List<Piezas> piezasList;
    private List<Pedido> pedidoList;
    private List<Categoria> categorias;
    public Almacencontrol() {
        proveedorList = new ArrayList<>();
        piezasList = new ArrayList<>();
        pedidoList = new ArrayList<>();
        categorias=new ArrayList<>();
        categorias.add(new Categoria(1,"pequeño"));
        categorias.add(new Categoria(2,"mediano"));
        categorias.add(new Categoria(3,"grande"));
    }

    /**
     * @param cif
     * @param nombre
     * @param direccion
     * @param localidad
     * @param provincia
     * @return
     * Metodo para dar de alta nuevos proveedores.
     */
    public boolean nuevoProveedor(String cif, String nombre, String direccion, String localidad, String provincia) {
        Proveedor proveedor = new Proveedor(cif, nombre);
        proveedor.setDireccion(direccion);
        proveedor.setLocalidad(localidad);
        proveedor.setProvincia(provincia);
        return proveedorList.add(proveedor);
    }

    @Override
    public String toString() {
        return "Almacencontrol{" + "\n" +
                "proveedorList=" + proveedorList + "\n" +
                ", piezasList=" + piezasList + "\n" +
                ", pedidoList=" + pedidoList + "\n" +
                '}' + "\n";
    }

    /**
     * @param cif
     * @return
     * Metodo que busca el proveedor por cif y permite borrarlo.
     */
    /*
        public void borrarProveedor(String cif) {
            int ProvedorList = 0;
            for (int i = 0; i < proveedorList.size(); i++) {
             if (cif.equals(proveedorList.get(i).getCif())){
                 proveedorList.remove(i);
                 System.out.println("Proveedor eliminado.");
             }
            }
        }

     */
    public boolean borrarProveedor(String cif) {
        return proveedorList.removeIf(proveedor -> cif.equals(proveedor.getCif()));
    }
/*
    public boolean modificarProveedor(String cif, String nombre, String direccion, String localidad, String provincia) {
        for (int i = 0; i < proveedorList.size(); i++) {
            if (cif.equals(proveedorList.get(i).getCif())) {
                proveedorList.get(i).setCif(cif);
                proveedorList.get(i).setNombre(nombre);
                proveedorList.get(i).setDireccion(direccion);
                proveedorList.get(i).setLocalidad(localidad);
                proveedorList.get(i).setProvincia(provincia);
            }
            return true;
        }return false
    }

 */

    /**
     * @param cif
     * @param nombre
     * @param direccion
     * @param localidad
     * @param provincia
     * @return
     * Metodo que busca un proveedor por cif y permite modificar los datos guardados en los parametros.
     */
    public boolean modificarNombreProveedorByCIF(String cif, String nombre) {
     /*
        for (Proveedor p : proveedorList) {
            if (cif.equals(p.getCif())) {
                p.setCif(cif);
                p.setNombre(nombre);
                p.setDireccion(direccion);
                p.setLocalidad(localidad);
                p.setProvincia(provincia);
                return true;
            }

        }
        return false;

      */
        return proveedorList.stream()
                .filter(p -> cif.equals(p.getCif()))
                .findFirst()
                .map(p ->
                {
                    p.setNombre(nombre);
                    return true;
                })
                .orElse(false);

    }
    public boolean modificarDireccionProveedorByCIF(String cif, String direccion) {
        return proveedorList.stream()
                .filter(p -> cif.equals(p.getCif()))
                .findFirst()
                .map(p ->
                {
                    p.setDireccion(direccion);
                    return true;
                })
                .orElse(false);
    }
    public boolean modificarlocalidadProveedorByCIF(String cif, String localidad) {
        return proveedorList.stream()
                .filter(p -> cif.equals(p.getCif()))
                .findFirst()
                .map(p ->
                {
                    p.setLocalidad(localidad);
                    return true;
                })
                .orElse(false);
    }
    public boolean modificarProvinciaProveedorByCIF(String cif, String provincia) {
        return proveedorList.stream()
                .filter(p -> cif.equals(p.getCif()))
                .findFirst()
                .map(p ->
                {
                    p.setProvincia(provincia);
                    return true;
                })
                .orElse(false);
    }
    /**
     * @param nombre
     * @param color
     * @param precio
     * @param idcategoria
     * @return
     * Metodo que da de alta una pieza.
     */
public boolean nuevaPieza (String nombre,Color color,Double precio,int idcategoria){
        Piezas pieza=new Piezas(nombre,color.toString() ,precio);
        pieza.setCategoria(getCategoriaById(idcategoria));
        piezasList.add(pieza);
        return true;
}

    /**
     * @param id
     * @return
     * Metodo para buscar la categoria de una pieza a traves del id de la pieza.
     */
    private Categoria getCategoriaById(int id){
        return categorias.stream().filter(c->c.getId()==id).findFirst().get();
    }

    /**
     * @param idpieza
     * @param precio
     * @return
     * Metodo para modificar el parametro precio buscando por id de pieza.
     */
    public boolean cambiarPrecio(int idpieza,Double precio){
        return piezasList.stream()
                .filter(p -> idpieza==(p.getId()))
                .findFirst()
                .map(p ->
                {
                    p.setPrecio(precio);
                    return true;
                })
                .orElse(false);
    }

    /**
     * @param cif
     * @param idpieza
     * @param cantidad
     * @return
     * Metodo para grabar nuevos pedidos en una lista.
     * Accede buscando el cif del proveedor.
     */
    public String nuevoPedido(String cif,int idpieza,int cantidad){

        Proveedor proveedor=getProveedorByCIF(cif);
        if (proveedor!=null){
            Piezas pieza=getPiezasByID(idpieza);
            if (pieza!=null){

                Pedido pedido1=new Pedido(pieza,proveedor);
                pedido1.setCantidad(cantidad);
                pedido1.setFecha(LocalDate.now());
                pedidoList.add(pedido1);
                return "pedido creado";
            }else{
                return "Error, pieza no existe.";
            }
        }else{
            ;
        }
        return "Error,proveedor no existe";
    }

    /**
     * @param cif
     * @return
     * Metodo de busqueda de proveedor por cif.
     */
    private Proveedor getProveedorByCIF(String cif){
        for (Proveedor p:proveedorList) {
            if (cif.equals(p.getCif())){
                return p;
            }
        }
        return null;
    }

    /**
     * @param id
     * @return
     * Metodo de busqueda de pieza por id.
     */
    public Piezas getPiezasByID(int id) {
        for (int i = 0; i < piezasList.size(); i++) {
            if (piezasList.get(i).getId() == id) {
                return piezasList.get(i);
            }
        }
        return null;
    }

    /**
     * @param idpieza
     * @return
     * Metodo que muestra el listado de pedidos de una pieza concreta.
     */
    public String getPedidosByPieza(int idpieza) {
        List<Pedido> pedidosByPieza = new ArrayList<>();
        for (Pedido pedido : pedidoList) {
            if(pedido.getPiezas().getId()==idpieza) {
                pedidosByPieza.add(pedido);
            }
        }
        if(pedidosByPieza.size()>0){
            return pedidosByPieza.toString();
        }else {
            return "No hay pedidos de esa pieza";
        }
    }

    /**
     * @param cif
     * @return
     * Metodo que muestra el listado de pedidos de un proveedor.
     */
    public String getPedidosByProveedor(String cif) {
        List<Pedido> pedidosByCIF = new ArrayList<>();
        for (Pedido pedido : pedidoList) {
            if(pedido.getProveedor().getCif().equals(cif)) {
                pedidosByCIF.add(pedido);
            }
        }
        if(pedidosByCIF.size()>0){
            return pedidosByCIF.toString();
        }else {
            return "No hay pedidos de ese proveedor";
        }
    }

    public String verProveedores() {
        return proveedorList.toString();
    }
    public boolean buscarProveedorCIF(String cif){
        for (Proveedor p:proveedorList) {
            if (cif.equals(p.getCif())){
                return true;
            }
        }
        return false;
    }
}




