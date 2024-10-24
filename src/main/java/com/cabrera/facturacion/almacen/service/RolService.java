package com.cabrera.facturacion.almacen.service;

import java.util.List;
import org.springframework.data.domain.Pageable;

import com.cabrera.facturacion.almacen.entity.Rol;

public interface RolService {
	public List<Rol>findAll(Pageable  page);
	public List<Rol>finByNombre(String nombre, Pageable page);
	public Rol findById(int id);
	public Rol save(Rol rol);
	public void delete (int id);

}

