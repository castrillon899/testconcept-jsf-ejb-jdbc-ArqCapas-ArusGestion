package com.arus.usuario.servicio;

import javax.ejb.Stateless;


import com.arus.usuario.clientes.UsuarioApi;
import com.arus.usuarios.drools.UsuarioDrools;
import com.arus.usuarios.model.bo.UsuarioBO;
import com.arus.usuarios.model.bo.ValidadorDeNegocio;

@Stateless
public class UsuarioServicio implements IUsuarioServicioLocal {

	
	ValidadorDeNegocio validadorDeNegocio;

	@Override
	public String hello() {
		return "Hello EJB World.";
	}

	@Override
	public ValidadorDeNegocio registrarUsuario(UsuarioBO usuarioBO) {

		ValidadorDeNegocio validacionesNegocio = new UsuarioDrools().validacionesUsuario(usuarioBO);
		if (!validacionesNegocio.getValidaciones().isEmpty()) {
			return validacionesNegocio;
		}
		try {
			new UsuarioApi().crearUsuario(usuarioBO);
		} catch (Exception e) {
			validacionesNegocio
					.agregarErrorNegocio(e.getMessage());
		}
		return validacionesNegocio;
	}



}
