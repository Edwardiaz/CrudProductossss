package net.catalogo.config;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.catalogo.dao.CategoriaDao;
import net.catalogo.dao.ProductoDao;
import net.catalogo.entity.Categoria;
import net.catalogo.entity.Productos;

//@RestController
//@RequestMapping(value = "/api", produces = { MediaType.APPLICATION_JSON_VALUE})
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.stereotype.Controller;

@Controller
public class ControladorCatalogo {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String handler(Model m) {

		return "index";
	}

	@RequestMapping(value = "/producto",method = RequestMethod.POST)
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

//	@RequestMapping(value="/listaP", produces = "application/json")
//	public String consultarProducto(Model m) {
//		ProductoDao proDao = new ProductoDao();
//
//		List<Productos> listaPro = proDao.consultarProductos();
//		System.out.println("LA LISTA ES::::::-> "+listaPro);
//		m.addAttribute("listaPro", listaPro);
//		return "mostrarPro";
//	}
	
	/* este metodo funciona */
//	@RequestMapping("/listaP")
//	public ModelAndView home() {
////	    List<Customer> listCustomer = customerService.listAll();
//		ProductoDao proDao = new ProductoDao();
//		List<Productos> listaPro = proDao.consultarProductos();
//	    ModelAndView mav = new ModelAndView("mostrarPro");
//	    mav.addObject("listaPro", listaPro);
//	    System.out.println("la lista es::::::: "+listaPro);
//	    return mav;
//	}
	
	@GetMapping(value="/listaP", produces = "application/json")
	public @ResponseBody List<Productos> consultarProducto() {
		ProductoDao proDao = new ProductoDao();

		List<Productos> listaPro = proDao.consultarProductos();
//		m.addAttribute("listaPro", listaPro);
		return listaPro;
	}
	
	@RequestMapping(value = "/eliminarpro/{idProducto}", method = RequestMethod.GET)
	public String eliminarProducto(@PathVariable("idProducto") int id, Model m) {
		ProductoDao proDao = new ProductoDao();
		proDao.eliminarProducto(id);
		List<Productos> listaPro = proDao.consultarProductos();
		m.addAttribute("listaPro", listaPro);
		return "mostrarPro";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String updateProducto(@PathVariable("idProducto") int id, Model m){
		ProductoDao proDao = new ProductoDao();
		proDao.updateProducto(id);
		List<Productos> listaPro = proDao.consultarProductos();
		m.addAttribute("listaPro", listaPro);
		return "mostrarPro";
	}
	
	@RequestMapping(value="/updatePro/{idProducto}", method = RequestMethod.GET)
	public String findByIdProducto(@PathVariable("idProducto") int id, Model m){
		ProductoDao proDao = new ProductoDao();
		proDao.findByIdProducto(id);
		return "updateProducto";
	}
	
	@RequestMapping("/listaC")
	public String consultarCategoria(Model m) {
		CategoriaDao catDao = new CategoriaDao();
		
		List<Categoria> listaCate = catDao.consultarCategoria();
		m.addAttribute("listaCat", listaCate);
		return "mostrarCat";
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
