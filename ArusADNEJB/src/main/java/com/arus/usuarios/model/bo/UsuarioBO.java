package com.arus.usuarios.model.bo;
import java.util.Date;




public class UsuarioBO {

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


	
	
	public UsuarioBO(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			String tipoDeDocumento, String documento, String administradoraSalud, Date fechaAfiliacionASalud,
			String administradoraDePension, Date fechaAfiliacionAPension) {
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.tipoDeDocumento = tipoDeDocumento;
		this.documento = documento;
		this.administradoraSalud = administradoraSalud;
		this.fechaAfiliacionASalud = fechaAfiliacionASalud;
		this.administradoraDePension = administradoraDePension;
		this.fechaAfiliacionAPension = fechaAfiliacionAPension;
	}

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

	public String createRegistrationForm() {
		
		return PANTALLA_OUTPUT;
	}

	@Override
	public String toString() {
		return "UsuarioBO [primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre + ", primerApellido="
				+ primerApellido + ", segundoApellido=" + segundoApellido + ", tipoDeDocumento=" + tipoDeDocumento
				+ ", documento=" + documento + ", administradoraSalud=" + administradoraSalud
				+ ", fechaAfiliacionASalud=" + fechaAfiliacionASalud + ", administradoraDePension="
				+ administradoraDePension + ", fechaAfiliacionAPension=" + fechaAfiliacionAPension + "]";
	}
	
	
}