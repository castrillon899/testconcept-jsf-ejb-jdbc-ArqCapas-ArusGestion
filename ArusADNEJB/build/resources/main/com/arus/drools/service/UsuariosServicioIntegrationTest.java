package com.arus.drools.service;

import org.junit.Before;
import org.junit.Test;

import com.arus.usuarios.model.bo.UsuarioBO;
import com.arus.usuarios.model.bo.ValidadorDeNegocio;
import com.arus.usuarios.servicio.UsuarioService;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import org.apache.commons.lang.time.DateUtils; 


public class UsuariosServicioIntegrationTest {

  private UsuarioService applicantService;
  private ValidadorDeNegocio validacionesNegocio;

  @Before
  public void setup() {
    applicantService = new UsuarioService();
  }

  @Test
  public void cuandoAFP003YFechaDeAfiliacionInferior20201231GenerarErrorValidacion() throws IOException {
    
	  try {
		
		  //Arrange
		  Date fechaAfiliacion = DateUtils.parseDate("31-12-2020", new String[]{"dd-MM-yyyy"});
		  UsuarioBO applicant = new UsuarioBO("Angel", "Er", "CASTRILLON", "CASTRILLON", "CC", "1035855651", "AFP003",
				  fechaAfiliacion, "AFP003", fechaAfiliacion);
    	  
		  
		  //Action
		  validacionesNegocio = applicantService.suggestARoleForApplicant(applicant);

		  //Assert
		   assertEquals(validacionesNegocio.getValidaciones().get(0).toString(), "Para la administradora de pensión AFP003 solo es posible afiliarse después de  2020/12/31");
	  
	  
	  } catch (ParseException e) {

		}
  }
  
  @Test
  public void cuandoPersonaSeRegistraConRCYAdministradorasDeSaludSonEPS003EPS004GenerarErrorValidacion() throws IOException {
    
	
		  
		  //Arrange
		  UsuarioBO applicant = new UsuarioBO("PEPE", "PEREZ", "CASTRILLON", "CASTRILLON", "RC", "1035855651", "EPS003",
				  new Date(), "AFP003", new Date());
    	  
		  //action
		  validacionesNegocio = applicantService.suggestARoleForApplicant(applicant);
		 
		  //asset
		  assertEquals(validacionesNegocio.getValidaciones().get(0).toString(), "Para una persona con tipo de documento RC Registro civil no es permitido afiliarse a las EPS: EPS003, EPS004");
	  
	  
	
  }
  
  
  @Test
  public void cuandoPersonaSeRegistraConEPS002SuraYAdministradoraDePensionEsDiferenteAFP001ProteccionGenerarErrorValidacion() throws IOException {
    
   	    //Arrange
		  UsuarioBO applicant = new UsuarioBO("PEPE", "PEREZ", "CASTRILLON", "CASTRILLON", "RC", "1035855651", "EPS002",
				  new Date(), "AFP003", new Date());
    	
		  //action
		  validacionesNegocio = applicantService.suggestARoleForApplicant(applicant);
	
		
		  //asset
		  assertEquals(validacionesNegocio.getValidaciones().get(0).toString(), "Las personas que se afilien a la administradora EPS002 Sura EPS solo pueden afiliarse a la administradora de pensión AFP001 Protección");
		  
		
  }

}
