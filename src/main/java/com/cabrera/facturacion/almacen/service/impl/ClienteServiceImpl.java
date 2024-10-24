package com.cabrera.facturacion.almacen.service.impl;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.facturacion.almacen.entity.Cliente;
import com.cabrera.facturacion.almacen.exception.GeneralException;
import com.cabrera.facturacion.almacen.exception.NoDataFoundException;
import com.cabrera.facturacion.almacen.exception.ValidateException;
import com.cabrera.facturacion.almacen.repository.ClienteRepository;
import com.cabrera.facturacion.almacen.service.ClienteService;
import com.cabrera.facturacion.almacen.validator.ClienteValidator;


@Service
public class ClienteServiceImpl implements ClienteService{
	@Autowired
	private ClienteRepository repository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll(Pageable page) {
		try {
			List<Cliente> registros=repository.findAll(page).toList();
			return registros;
		}  catch (ValidateException | NoDataFoundException e) {
			throw e;
		}
		catch (GeneralException e) {
			throw new GeneralException("Error en el servidor");
		}
			
	}

	
	@Transactional(readOnly = true)
	public List<Cliente> finByNombre(String nombre, Pageable page) {
		try {
			List<Cliente> registros=repository.findByNombreContaining(nombre,page);
			return registros;
		} catch (ValidateException | NoDataFoundException e) {
			throw e;
		}
		catch (GeneralException e) {
			throw new GeneralException("Error en el servidor");
		}
	}

	@Transactional
	@Override
	public Cliente findById(int id) {
		try {
			Cliente registro=repository.findById(id)
					.orElseThrow(()-> new NoDataFoundException("No se encontro el registro con ese ID"));
			return registro;
		} catch (ValidateException | NoDataFoundException e) {
			throw e;
		}
		catch (GeneralException e) {
			throw new GeneralException("Error en el servidor");
		}
	
	}

	@Transactional
	@Override
	public Cliente save(Cliente cliente) {
		try {
			//Nuevo registro
			ClienteValidator.validate(cliente);
			if (cliente.getId()==0) {
				Cliente nuevo=repository.save(cliente);
				return nuevo;
			}
			//editar registro
			Cliente registro=repository.findById(cliente.getId()).orElseThrow(()-> new NoDataFoundException("No se encontro el registro"));;
			registro.setNombre(cliente.getNombre());
			registro.setTelefono(cliente.getTelefono());
            registro.setTipoDocumento(cliente.getTipoDocumento());
            registro.setNumeroDocumento(cliente.getNumeroDocumento());
            registro.setEmail(cliente.getEmail());
			repository.save(registro);
			return registro;
		}  catch (ValidateException | NoDataFoundException e) {
			throw e;
		}
		catch (GeneralException e) {
			throw new GeneralException("Error en el servidor");
		}
	
	}

	@Override
	public void delete(int id) {
		try {
			Cliente registro=repository.findById(id).orElseThrow(()-> new NoDataFoundException("No se encontro el registro con ese ID"));;
			repository.delete(registro);
		}  catch (ValidateException | NoDataFoundException e) {
			throw e;
		}
		catch (GeneralException e) {
			throw new GeneralException("Error en el servidor");
		}
	
	}


	@Override
	public List<Cliente> findAll() {
		try {
			List<Cliente> registros=repository.findAll();
			return registros;
		}  catch (ValidateException | NoDataFoundException e) {
			throw e;
		}
		catch (GeneralException e) {
			throw new GeneralException("Error en el servidor");
		}
	}

}
