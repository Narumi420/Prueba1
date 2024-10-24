package com.cabrera.facturacion.almacen.validator;

import com.cabrera.facturacion.almacen.entity.Categoria;
import com.cabrera.facturacion.almacen.exception.ValidateException;

public class CategoriaValidator {
    public static void validate(Categoria registro) {
        if (registro.getNombre() == null || registro.getNombre().trim().isEmpty()) {
            throw new ValidateException("El nombre de la categoria es requerido");
        }
        if (registro.getNombre().length()>70) {
            throw new ValidateException("El nombre de la categoria no debe de tener mas de 70 caracteres");
            
        }
    }
}
