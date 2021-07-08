package com.formacionbdi.springboot.app.productos.models.services;

import java.util.List;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;

public interface IProductoServices {

	public List<Producto> findAll();
	public Producto findById(Long id);
}
