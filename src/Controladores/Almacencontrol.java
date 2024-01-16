package Controladores;

import Modelos.Pedido;
import Modelos.Piezas;
import Modelos.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class Almacencontrol {

private List<Proveedor>proveedorList;
private List<Piezas>piezasList;
private List<Pedido>pedidoList;

    public Almacencontrol() {
        proveedorList=new ArrayList<>();
        piezasList=new ArrayList<>();
        pedidoList=new ArrayList<>();

    }
    public boolean nuevoProveedor(String cif,String nombre,String direccion,String localidad,String provincia){
        Proveedor proveedor=new Proveedor(cif,nombre);
        proveedor.setDireccion(direccion);
        proveedor.setLocalidad(localidad);
        proveedor.setProvincia(provincia);
        return proveedorList.add(proveedor);
    }

    @Override
    public String toString() {
        return "Almacencontrol{" +"\n"+
                "proveedorList=" + proveedorList + "\n"+
                ", piezasList=" + piezasList +"\n"+
                ", pedidoList=" + pedidoList +"\n"+
                '}';
    }
}
