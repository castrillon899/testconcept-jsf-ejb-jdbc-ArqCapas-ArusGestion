package com.arus.usuarios.servicio;

import com.arus.drools.config.MotorDeReglasDrools;
import com.arus.usuarios.model.bo.UsuarioBO;
import com.arus.usuarios.model.bo.ValidadorDeNegocio;
import org.kie.api.runtime.KieSession;

import java.io.IOException;

public class UsuarioService {

    KieSession kieSession=new MotorDeReglasDrools().cargarModuloConocimientoValidacionUsuarios();
    ValidadorDeNegocio validadorDeNegocio;
    
    public ValidadorDeNegocio suggestARoleForApplicant(UsuarioBO applicant) throws IOException {
    	validadorDeNegocio=new ValidadorDeNegocio();
    	kieSession.insert(applicant);
        kieSession.setGlobal("validaciones",validadorDeNegocio);
        kieSession.fireAllRules();
        return  validadorDeNegocio;

    }
}
