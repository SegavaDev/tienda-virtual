package com.segavaDev.tiendaVirtual.components.escuchaApp;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStart implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        String port = event.getApplicationContext().getEnvironment().getProperty("server.port");
        String path = event.getApplicationContext().getEnvironment().getProperty("server.servlet.context-path", "");
        String url = "http://localhost:" + port + path;
        System.out.println("Swagger corriendo en: http://localhost:3001/swagger-ui/swagger-ui/index.html");
        System.out.println("Servidor corriendo en: " + url);
    }
    
}
