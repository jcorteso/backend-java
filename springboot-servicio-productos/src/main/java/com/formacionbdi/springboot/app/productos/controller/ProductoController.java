package com.formacionbdi.springboot.app.productos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.services.IProductoServices;

@RestController
@CrossOrigin(origins = "http://localhost:4200" )
public class ProductoController {
	
	/**
	 * Consul Discovery
	 
	@Autowired
	private Disco */
	@Autowired
	private IProductoServices productoServices;
	
	@Autowired
	private Environment env;
	
	@Value("${server.port}")	
	private Integer port;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		
		return productoServices.findAll().stream().map(producto ->{
			/**producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));**/
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
		
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto=productoServices.findById(id);
		/**producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));**/
		producto.setPort(port);
		/**try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}**/
		return producto;
	}

}
