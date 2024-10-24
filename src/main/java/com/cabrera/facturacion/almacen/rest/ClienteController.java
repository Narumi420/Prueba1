package com.cabrera.facturacion.almacen.rest;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cabrera.facturacion.almacen.converter.ClienteConverter;
import com.cabrera.facturacion.almacen.dto.ClienteDto;
import com.cabrera.facturacion.almacen.entity.Cliente;
import com.cabrera.facturacion.almacen.service.ClienteService;
import com.cabrera.facturacion.almacen.util.WrapperResponse;

@RestController
@RequestMapping("/v1/clientes")
//localhost:8090/v1/ versionado en la URI
public class ClienteController {
	@Autowired
	private ClienteService service;
	
	@Autowired
	private ClienteConverter converter;
	
	@GetMapping
	public ResponseEntity<List<ClienteDto>> findAll(
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
			){
		Pageable page = PageRequest.of(pageNumber, pageSize);
				
		List<ClienteDto> clientes = converter.fromEntity(service.findAll());
		return new WrapperResponse("success",true,clientes).createResponse(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDto> create (@RequestBody ClienteDto cliente){
		Cliente categoriaEntity=converter.fromDTO(cliente);
		ClienteDto registro = converter.fromEntity(service.save(categoriaEntity));
		return new WrapperResponse("success",true,cliente).createResponse(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDto> update(@PathVariable("id") int id,@RequestBody ClienteDto cliente){
		Cliente clienteEntity=converter.fromDTO(cliente);
		ClienteDto registro = converter.fromEntity(service.save(clienteEntity));
		return new WrapperResponse("success",true,cliente).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") int id){
		service.delete(id);
		return new WrapperResponse("success",true,null).createResponse(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> findById(@PathVariable("id") int id){
		ClienteDto registro=converter.fromEntity(service.findById(id));
		return new WrapperResponse("success",true,registro).createResponse(HttpStatus.OK);
	}
	
	
	
	
}
