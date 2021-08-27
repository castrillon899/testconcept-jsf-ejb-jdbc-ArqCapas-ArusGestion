package com.arus.usuarios.bean;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import com.arus.usuario.IUsuarioServicioLocal;
import com.arus.usuarios.model.bo.UsuarioBO;
import com.arus.usuarios.model.bo.ValidadorDeNegocio;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.ValidatorException;


import javax.inject.Inject;

@ManagedBean(name = "registrationBean")
@SessionScoped

public class UsuarioBean {
	
	private static final String PANTALLA_OUTPUT = "output";
	private static final String SOLO_LETRAS = "Solo se permiten letras";
	private static final String SOLO_NUMEROS_Y_MAXIMO_10_CARACTERES = "Solo se permiten numeros y m�ximo 10 caracteres";
	private static final String SOLO_NUMEROS_LETRAS_Y_MAXIMO_14_CARACTERES = "Solo se permiten numeros, letras y maximo 14 caracteres";
	private static final String SOLO_NUMEROS = "Solo se permiten numeros";
	
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
	private boolean registroExitoso=false;

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

	
	
	public void validarNombre(FacesContext context, UIComponent component, Object valor)  
			throws ValidatorException{
		String nombre = (String) valor;
		for (int i = 0; i < nombre.length(); i++) {
			if( !Character.isLetter( nombre.charAt( i ) ) ) {
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,SOLO_LETRAS, null));
			}
		}
	}
		
	public void tipoDocumentoSeleccionadoListener(AjaxBehaviorEvent evento) {
		SelectOneMenu componente = (SelectOneMenu) evento.getComponent();
		this.setTipoDeDocumento ( (String) componente.getValue() );
	}
	

	
	
	public void validarNumeroDocumento(FacesContext context, UIComponent component, Object valor)  
			throws ValidatorException{
		String numeroDocumento = (String) valor;
	   
		if(tipoDeDocumento.equals("RC") || 
				tipoDeDocumento.equals("TI")) {
			
			for (int i = 0; i < numeroDocumento.length(); i++) {
				if( !Character.isDigit( numeroDocumento.charAt( i ) ) ) {
					throw new ValidatorException( 
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									SOLO_NUMEROS, 
									null));
				}
			}
		}
		
	
		
		if(tipoDeDocumento.equals("CE") ){
			if(numeroDocumento.length() > 14) {
				throw new ValidatorException( 
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								SOLO_NUMEROS_LETRAS_Y_MAXIMO_14_CARACTERES, 
								null));
			}
			
			for (int i = 0; i < numeroDocumento.length(); i++) {
				if( !Character.isDigit( numeroDocumento.charAt( i ) ) &&
						!Character.isLetter( numeroDocumento.charAt( i ) )) {
					throw new ValidatorException( 
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									SOLO_NUMEROS_LETRAS_Y_MAXIMO_14_CARACTERES, 
									null));
				}
			}
		}
		
		
		if(tipoDeDocumento.equals("CC") ){
			if(numeroDocumento.length() > 10) {
				 
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
								SOLO_NUMEROS_Y_MAXIMO_10_CARACTERES, 
								null));
			}
			
			for (int i = 0; i < numeroDocumento.length(); i++) {
				if( !Character.isDigit( numeroDocumento.charAt( i ) ) ) {
					throw new ValidatorException( 
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									SOLO_NUMEROS_Y_MAXIMO_10_CARACTERES, 
									null));
				}
			}
				
		}
		
		
		
	}
	
	public void setValidadores(List<String> validadores) {
		this.validadores = validadores;
	}
	

	public boolean isRegistroExitoso() {
		return registroExitoso;
	}

	public void setRegistroExitoso(boolean registroExitoso) {
		this.registroExitoso = registroExitoso;
	}

	public String createRegistrationForm() {

		UsuarioBO usuarioBO = new UsuarioBO(primerNombre, segundoNombre, primerApellido, segundoApellido,
				tipoDeDocumento, documento, administradoraSalud, fechaAfiliacionASalud, administradoraDePension,
				fechaAfiliacionAPension);
		
		ValidadorDeNegocio resultadoValidaciones = usuarioServicio.registrarUsuario(usuarioBO);
		validadores=resultadoValidaciones.getValidaciones();
		
		registroExitoso=true;
		
		return PANTALLA_OUTPUT;
	}
}