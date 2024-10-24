package com.cabrera.facturacion.almacen.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cabrera.facturacion.almacen.entity.Rol;
import com.cabrera.facturacion.almacen.repository.RolRepository;
import com.cabrera.facturacion.almacen.service.RolService;

@Service
public class RolServiceImpl implements RolService{
	@Autowired
	private RolRepository repository;

	@Override
	public List<Rol> findAll(org.springframework.data.domain.Pageable page) {
		   try {
	            List<Rol> registros = repository.findAll(page).toList();
	           
	            return registros;
	      
		   } catch (Exception e) {
	            
	    	   throw e;
	       }
	  
	}
	
	@Override
	public List<Rol> finByNombre(String nombre, Pageable page) {
		try {
            List<Rol> registros = repository.findByNombreContaining(nombre, page);
           
            return registros;
      
	   } catch (Exception e) {
            
    	   throw e;
       }
		
	}
	

	@Override
	public Rol findById(int id) {
		
		try {
          Rol registro = repository.findById(id).orElseThrow();
           
            return registro;
      
	   } catch (Exception e) {
            
    	   throw e;
       }
	}
	

	@Override
	public Rol save(Rol rol) {

		try {
         
			if( rol.getId()==0) {
            Rol nuevo=repository.save(rol);
            return nuevo;
			}
		
			Rol registro=repository.findById(rol.getId()).orElseThrow();
			registro.setNombre(rol.getNombre());
			repository.save(registro);
			return registro;
          
	   } catch (Exception e) {
            
    	   throw e;
       }
	}
	

	@Override
	public void delete(int id) {
		try {
			Rol registro=repository.findById(id).orElseThrow();
			repository.delete(registro);
			
		}catch (Exception e) {
			 throw e;
	       }
	}
	
}

