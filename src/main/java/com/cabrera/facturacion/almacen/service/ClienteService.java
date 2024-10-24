package com.cabrera.facturacion.almacen.service;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cabrera.facturacion.almacen.entity.Cliente;

public interface ClienteService {
	public List<Cliente> findAll(Pageable page);
	public List<Cliente> findAll();
	public List<Cliente> finByNombre(String nombre,Pageable page);
	public Cliente findById(int id);
	public Cliente save(Cliente categoria);
	public void delete(int id);
}
