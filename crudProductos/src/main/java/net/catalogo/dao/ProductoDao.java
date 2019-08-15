package net.catalogo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import net.catalogo.entity.Productos;
import net.catalogo.util.HibernateUtil;

//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import net.evaluado.entity.Producto;

public class ProductoDao {

	JdbcTemplate template;
	
	/*metodo insertar*/
	public void insertarProducto(Productos pro) {
		Transaction transaccion = null;
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()) {
			transaccion = sesion.beginTransaction();
			sesion.save(pro);
			transaccion.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(transaccion != null) {
				transaccion.rollback();
			}
			e.printStackTrace();
		}
	}
	/*Termina metodo insertar*/
	
	/*metodo consultarAll*/
	public List<Productos> consultarProductos(){
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()){
			return sesion.createQuery("from Productos", Productos.class).list();	
		}
	}
	/*Teminar metodo consultarAll*/
	
	/*Metodo Eliminar*/
	public void eliminarProducto(int id) {
		Transaction transaccion = null;
//		Session sesion = this.sessionFactory.getCurrentSession();
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Productos pro = (Productos) sesion.load(Productos.class, new Integer(id));
		transaccion = sesion.beginTransaction();
		if (null != pro) {
			sesion.delete(pro);
			transaccion.commit();
		}
	}
	/*Termina metodo eliminar*/
	
	/*Metodo actualizar*/
	public void updateProducto(int id) {
		Transaction transaccion = null;
//		Session sesion = this.sessionFactory.getCurrentSession();
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Productos pro = (Productos) sesion.load(Productos.class, new Integer(id));
		transaccion = sesion.beginTransaction();
		if (null != pro) {
			sesion.update(pro);
			transaccion.commit();
		}
	}
	/*Terminar metodo Actulizar*/
	
	public void findByIdProducto(int id) {
		Transaction transaccion = null;
//		Session sesion = this.sessionFactory.getCurrentSession();
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Productos pro = (Productos) sesion.load(Productos.class, new Integer(id));
		transaccion = sesion.beginTransaction();
		if (null != pro) {
			sesion.find(Productos.class, "idProducto");
			transaccion.commit();
		}
	}
	
//	public void consultarById(int id) {
//	Transaction transaccion = null;
//	Session sesion = HibernateUtil.getSessionFactory().openSession();
//	Productos pro = (Productos) sesion.load(Productos.class, new Integer(id));
//	transaccion = sesion.beginTransaction();
//	if (null != pro) {
//		sesion.update(pro);
//		transaccion.commit();
//	}
//}

//public Productos productoById(int idPro){    
//    String sql="select * from productos where idProducto=?";    
//    return template.queryForObject(sql, new Object[]{idPro},new BeanPropertyRowMapper<Productos>(Productos.class));    
//} 
	
	
	
	
	
	/*retazo de codigos...*/
	
//	/*public String
//	String sql = "SELECT * FROM productos WHERE idProducto = :idProducto";
//	SQLQuery query = sesion.createSQLQuery(sql);
//	query.addEntity(Employee.class);
//	query.setParameter("employee_id", 10);
//	List results = query.list();
//	*/
//	
//	public int actualizarPro(Productos pro){    
//	    String sql="update productos set producto='"+pro.getProducto()+"', precio="+pro.getPrecio()+", idCategoria="+pro.getIdCategoria()+", cantidad = "+pro.getPrecio()+" where idProducto="+pro.getIdProducto()+";";    
//	    return template.update(sql);    
//	}    
//	public int eliminarPro(int id){    
//	    String sql="delete from productos where idProducto="+id+";";    
//	    return template.update(sql);    
//	}    
}
