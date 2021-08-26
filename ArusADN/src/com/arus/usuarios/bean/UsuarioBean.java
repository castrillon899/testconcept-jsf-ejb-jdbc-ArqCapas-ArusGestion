package com.arus.usuarios.bean;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.arus.usuario.IUsuarioServicioLocal;
import com.arus.usuarios.model.bo.UsuarioBO;
import com.arus.usuarios.model.bo.ValidadorDeNegocio;

import javax.inject.Inject;

@ManagedBean(name = "registrationBean")
@SessionScoped

public class UsuarioBean {

	private static final String PANTALLA_OUTPUT = "output";
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String tipoDeDocumento;
	private String documento;
	private String administradoraSalud;
	private Date fechaAfiliacionASalud;
	private String administradoraDePension;
	private Date fechaAfiliacionAPension;
	private List<String> validadores;

	@EJB
	@Inject
	private IUsuarioServicioLocal usuarioServicio;

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipoDeDocumento() {
		return tipoDeDocumento;
	}

	public void setTipoDeDocumento(String tipoDeDocumento) {
		this.tipoDeDocumento = tipoDeDocumento;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getAdministradoraSalud() {
		return administradoraSalud;
	}

	public void setAdministradoraSalud(String administradoraSalud) {
		this.administradoraSalud = administradoraSalud;
	}

	public Date getFechaAfiliacionASalud() {
		return fechaAfiliacionASalud;
	}

	public void setFechaAfiliacionASalud(Date fechaAfiliacionASalud) {
		this.fechaAfiliacionASalud = fechaAfiliacionASalud;
	}

	public String getAdministradoraDePension() {
		return administradoraDePension;
	}

	public void setAdministradoraDePension(String administradoraDePension) {
		this.administradoraDePension = administradoraDePension;
	}

	public Date getFechaAfiliacionAPension() {
		return fechaAfiliacionAPension;
	}

	public void setFechaAfiliacionAPension(Date fechaAfiliacionAPension) {
		this.fechaAfiliacionAPension = fechaAfiliacionAPension;
	}
	
	
	public List<String> getValidadores() {
		return validadores;
	}

	public void setValidadores(List<String> validadores) {
		this.validadores = validadores;
	}

	public String createRegistrationForm() {

		UsuarioBO usuarioBO = new UsuarioBO(primerNombre, segundoNombre, primerApellido, segundoApellido,
				tipoDeDocumento, documento, administradoraSalud, fechaAfiliacionASalud, administradoraDePension,
				fechaAfiliacionAPension);
		
		System.out.print(usuarioBO);
		
		ValidadorDeNegocio resultadoValidaciones = usuarioServicio.registrarUsuario(usuarioBO);
		validadores=resultadoValidaciones.getValidaciones();
		
		System.out.print(validadores);
		return PANTALLA_OUTPUT;
	}
}