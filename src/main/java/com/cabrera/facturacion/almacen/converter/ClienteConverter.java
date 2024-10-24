package com.cabrera.facturacion.almacen.converter;


import org.springframework.stereotype.Component;

import com.cabrera.facturacion.almacen.dto.ClienteDto;
import com.cabrera.facturacion.almacen.entity.Cliente;

@Component
public class ClienteConverter extends AbstractConverter<Cliente, ClienteDto>  {

	@Override
	public ClienteDto fromEntity(Cliente entity) {
		if(entity==null) return null;
		return ClienteDto.builder()
				.id(entity.getId())
				.nombre(entity.getNombre())
                .telefono(entity.getTelefono())
                .tipoDocumento(entity.getTipoDocumento())
                .numeroDocumento(entity.getNumeroDocumento())
                .email(entity.getEmail())
				.build();
	}

	@Override
	public Cliente fromDTO(ClienteDto dto) {
		if(dto==null) return null;
		return Cliente.builder()
				.id(dto.getId())
				.nombre(dto.getNombre())
                .telefono(dto.getTelefono())
                .tipoDocumento(dto.getTipoDocumento())
                .numeroDocumento(dto.getNumeroDocumento())
                .email(dto.getEmail())
				.build();
				
	}

}
