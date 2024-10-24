package com.cabrera.facturacion.almacen.validator;

import com.cabrera.facturacion.almacen.entity.Cliente;
import com.cabrera.facturacion.almacen.exception.ValidateException;

public class ClienteValidator {
    public static void validate(Cliente registro) {
        if (registro.getNombre() == null || registro.getNombre().trim().isEmpty()) {
            throw new ValidateException("El nombre del cliente es requerido");
        }
        if (registro.getNombre().length()>70) {
            throw new ValidateException("El nombre del cliente no debe de tener mas de 70 caracteres");
            
        }
    }
}
