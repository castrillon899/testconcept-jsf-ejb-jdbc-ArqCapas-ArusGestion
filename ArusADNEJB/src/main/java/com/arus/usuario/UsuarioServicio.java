package com.arus.usuario;


import javax.ejb.Stateless;

import org.kie.api.runtime.KieSession;

import com.arus.drools.config.MotorDeReglasDrools;
import com.arus.usuarios.model.bo.UsuarioBO;
import com.arus.usuarios.model.bo.ValidadorDeNegocio;

@Stateless
public class UsuarioServicio implements IUsuarioServicioLocal {

	KieSession kieSession = new MotorDeReglasDrools().cargarModuloConocimientoValidacionUsuarios();
	ValidadorDeNegocio validadorDeNegocio;

	@Override
	public String hello() {
		return "Hello EJB World.";
	}

	@Override
	public ValidadorDeNegocio registrarUsuario(UsuarioBO usuarioBO)
	{
		return validacionesUsuario(usuarioBO);
	}
	
	
	private ValidadorDeNegocio validacionesUsuario(UsuarioBO applicant) {
		validadorDeNegocio = new ValidadorDeNegocio();
		kieSession.insert(applicant);
		kieSession.setGlobal("validaciones", validadorDeNegocio);
		kieSession.fireAllRules();
		System.out.println(validadorDeNegocio.getValidaciones().toString());
		return validadorDeNegocio;

	}

}
