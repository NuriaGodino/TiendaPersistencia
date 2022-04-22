package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Producto;


@Service
public class ProductosServiceImpl implements ProductosService {

	@PersistenceContext 
	EntityManager entityManager;
	
	
	@Override
	public List<Producto> productosSeccion(String seccion) {
		String jpql = "select p from Producto p where p.seccion=:seccion";
		TypedQuery<Producto> query = entityManager.createQuery(jpql, Producto.class);
		query.setParameter("seccion", seccion);
		return query.getResultList();
	}
	
	
	@Transactional 
	@Override
	public void altaProducto(Producto producto) {
		entityManager.persist(producto); 
	}
	
	@Transactional
	@Override
	public void eliminarProducto(String nombre) {
		String jpql = "delete from Producto p where p.nombre=:nombre";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("nombre", nombre);
		query.executeUpdate();
	}
	
	@Transactional
	@Override
	public void modificarPrecioProducto(String nombre, double nuevoPrecio) {
		String jpql = "update Producto p set p.precio=:precio where p.nombre=:nombre";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("precio", nuevoPrecio);
		query.setParameter("nombre", nombre);
		query.executeUpdate();
		
	}

	@Override
	public Producto buscarProducto(int idProducto) {
		return entityManager.find(Producto.class, idProducto);
	}	
}
