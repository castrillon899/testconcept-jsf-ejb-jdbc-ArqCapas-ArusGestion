package com.arus.usuario.servicio;

import com.arus.usuarios.model.bo.UsuarioBO;
import com.arus.usuarios.model.bo.ValidadorDeNegocio;

public interface IUsuarioService {
	String hello();

	ValidadorDeNegocio registrarUsuario(UsuarioBO usuario);
	
}
