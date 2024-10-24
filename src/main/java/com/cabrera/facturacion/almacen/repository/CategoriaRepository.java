package com.cabrera.facturacion.almacen.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabrera.facturacion.almacen.entity.Categoria;

import java.util.List;

@Repository

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	List<Categoria>findByNombreContaining(String nombre,Pageable page);
	

}
