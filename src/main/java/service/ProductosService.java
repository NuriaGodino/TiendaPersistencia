package service;

import java.util.List;

import model.Producto;

public interface ProductosService {

	
	List<Producto> productosSeccion(String seccion);

	void altaProducto(Producto producto);
	
	void eliminarProducto(String nombre);

	void modificarPrecioProducto(String nombre, double nuevoPrecio);
	
	Producto buscarProducto(int idProducto);
}