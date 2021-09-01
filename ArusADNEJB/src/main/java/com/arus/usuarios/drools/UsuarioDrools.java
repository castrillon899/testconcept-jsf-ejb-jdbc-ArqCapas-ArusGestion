package com.arus.usuarios.drools;

import com.arus.drools.config.MotorDeReglasDrools;
import com.arus.usuarios.model.bo.UsuarioBO;
import com.arus.usuarios.model.bo.ValidadorDeNegocio;
import org.kie.api.runtime.KieSession;


public class UsuarioDrools {

	KieSession kieSession = new MotorDeReglasDrools().cargarModuloConocimientoValidacionUsuarios();
    ValidadorDeNegocio validadorDeNegocio;
    
    public ValidadorDeNegocio validacionesUsuario(UsuarioBO applicant) {
    	validadorDeNegocio=new ValidadorDeNegocio();
    	kieSession.insert(applicant);
        kieSession.setGlobal("validaciones",validadorDeNegocio);
        kieSession.fireAllRules();
        return  validadorDeNegocio;

    }
}
