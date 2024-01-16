package Controladores;

import Modelos.Pedido;
import Modelos.Piezas;
import Modelos.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class Almacencontrol {

    private List<Proveedor> proveedorList;
    private List<Piezas> piezasList;
    private List<Pedido> pedidoList;

    public Almacencontrol() {
        proveedorList = new ArrayList<>();
        piezasList = new ArrayList<>();
        pedidoList = new ArrayList<>();

    }

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
    /*
    public boolean modificarProveedor(String cif, String nombre, String direccion, String localidad, String provincia) {
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
    }

     */
public boolean modificarProveedor(String cif, String nombre, String direccion, String localidad, String provincia) {
    proveedorList.stream()
            .filter(p->cif.equals(p.getCif()))
            .findFirst()
            .ifPresent(p->{
                p.setNombre(nombre);
            });
    return true;
}
}


