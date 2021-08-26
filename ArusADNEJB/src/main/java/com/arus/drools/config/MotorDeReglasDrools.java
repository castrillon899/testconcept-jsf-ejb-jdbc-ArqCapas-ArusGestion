package com.arus.drools.config;

import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

public class MotorDeReglasDrools {

    private KieServices kieServicio=KieServices.Factory.get();


    private void cargarKieRepositorio() {
        final KieRepository kieRepository = kieServicio.getRepository();
        kieRepository.addKieModule(new KieModule() {
                        public ReleaseId getReleaseId() {
                return kieRepository.getDefaultReleaseId();
            }
        });
    }
   
    
    public KieSession cargarModuloConocimientoValidacionUsuarios(){
        cargarKieRepositorio();
        KieFileSystem kieArchivoDeSistema = kieServicio.newKieFileSystem();

        kieArchivoDeSistema.write(ResourceFactory.newClassPathResource("com/arus/drools/rules/ValidadorUsuario.drl"));
        
        KieBuilder kb = kieServicio.newKieBuilder(kieArchivoDeSistema);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();

        KieContainer kcontenedor= kieServicio.newKieContainer(kieModule.getReleaseId());

        return kcontenedor.newKieSession();

    }
    
    
    
}
