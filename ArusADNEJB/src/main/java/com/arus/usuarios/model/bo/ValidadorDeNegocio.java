package com.arus.usuarios.model.bo;

import java.util.ArrayList;
import java.util.List;

public class ValidadorDeNegocio {
	
	List<String> validaciones;
	
	public ValidadorDeNegocio(){
		validaciones=new ArrayList<String>();
	}

	public List<String> getValidaciones() {
		return validaciones;
	}

	public void agregarErrorNegocio(String error) {
		validaciones.add(error)	;
	}

	@Override
	public String toString() {
		return "ValidadorDeNegocio [validaciones=" + validaciones + "]";
	}

	

}
