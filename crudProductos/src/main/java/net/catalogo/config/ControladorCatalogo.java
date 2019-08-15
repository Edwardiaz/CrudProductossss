package net.catalogo.config;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.catalogo.dao.CategoriaDao;
import net.catalogo.dao.ProductoDao;
import net.catalogo.entity.Categoria;
import net.catalogo.entity.Productos;

@Controller
public class ControladorCatalogo {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String handler(Model m) {

		return "index";
	}

	@RequestMapping(value = "/producto", method = RequestMethod.POST)
	public String insertarProductos(
			@RequestParam(value = "producto") String producto,
			@RequestParam(value = "precio") double precio, 
			@RequestParam(value = "categoria") int idCategoria,
			@RequestParam(value = "cantidad") int cantidad) {
		ProductoDao proDao = new ProductoDao();
		Productos prod = new Productos();

		prod.setProducto(producto);
		prod.setPrecio(precio);
		prod.setIdCategoria(idCategoria);
		prod.setCantidad(cantidad);
		proDao.insertarProducto(prod);

		return "index";
	}

	@RequestMapping("/listaC")
	public String consultarCategoria(Model m) {
		CategoriaDao catDao = new CategoriaDao();
		// Categoria categoria = new Categoria();
		List<Categoria> listaCate = catDao.consultarCategoria();
		m.addAttribute("listaCat", listaCate);
		return "mostrarCat";
	}

	@RequestMapping("/listaP")
	public String consultarProducto(Model m) {
		ProductoDao proDao = new ProductoDao();

		List<Productos> listaPro = proDao.consultarProductos();
		m.addAttribute("listaPro", listaPro);
		return "mostrarPro";
	}
	
	@RequestMapping(value = "/eliminarpro/{idProducto}", method = RequestMethod.GET)
	public String eliminarProducto(@PathVariable("idProducto") int id, Model m) {
		ProductoDao proDao = new ProductoDao();
		proDao.eliminarProducto(id);
		List<Productos> listaPro = proDao.consultarProductos();
		m.addAttribute("listaPro", listaPro);
		return "mostrarPro";
	}

	
	/* actualiza productos */
//	@RequestMapping(value = "/updatePro", method = RequestMethod.POST)
//	public String actualizarProd(@ModelAttribute("ver") Productos pro) {
//		ProductoDao proDao = new ProductoDao();
//		proDao.actualizarPro(pro);
//		return "localhost:8090/crudProductos/";
//	}
//	
//	 /* muestra los datos del objeto dentro del form por cada Id   
//     * el @PathVariable pone la URL en la variable.*/  
//	
//    @RequestMapping(value="/updatePro/{idProducto}")    
//    public String edit(@PathVariable int idProducto, Model m){
//    	ProductoDao proDao = new ProductoDao();
//        Productos productos = proDao.productoById(idProducto);    
//        m.addAttribute("command",productos);  
//        return "http://localhost:8090/crudProductos/listaP";
//    }
 


}
