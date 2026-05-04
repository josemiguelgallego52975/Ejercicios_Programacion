package org.example.almacen.Controladores.Modelo;

import javafx.scene.control.ComboBox;
import org.example.almacen.Modelo.Producto;
import org.example.almacen.Modelo.Proveedor;

import java.util.List;

public class AlmacenController {
    // "Jefe" de todos los controllers.

    private static Producto producto;
    private static List<Proveedor> listaProveedores;

    public static void buscarProducto(String nombre) throws Exception
    {
        producto = ProductoController.buscarProducto(nombre);
        producto.setListaProveedores(listaProveedores);
    }

    public static void buscarPorProducto(int codigo) throws Exception
    {
        // buscar proveedores de un producto.
        listaProveedores = ProductoProveedorController.buscarPorProducto(codigo);
    }

    public static Proveedor crearObjetoProveedor(int codigoProveedor) throws Exception
    {
        return ProveedorController.crearObjetoProveedor(codigoProveedor);
    }

    public static void llenarCombo(ComboBox<String> cbProveedores) throws Exception
    {
        for (Proveedor p: listaProveedores) {
            cbProveedores.getItems().add(p.getNombre());
        }
    }
}
