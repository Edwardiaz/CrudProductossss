package net.catalogo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import net.catalogo.entity.Categoria;
import net.catalogo.util.HibernateUtil;

public class CategoriaDao {

	public void insertarCategoria(Categoria categoria) {
		Transaction transaccion = null;
		try (Session sesion = HibernateUtil.getSessionFactory().openSession()){
			transaccion = sesion.beginTransaction();
			sesion.save(categoria);
			transaccion.commit();
			
		} catch (Exception e) {
			if(transaccion != null) {
				transaccion.rollback();
			}
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	/*metodo Consultar Todo*/
	public List<Categoria> consultarCategoria(){
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()){
			return sesion.createQuery("from Categoria", Categoria.class).list();
		}
	}
}
