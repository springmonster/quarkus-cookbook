package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped // <1>
public class ApplicationLifecyle {

    void onStart(@Observes StartupEvent event) { // <2>
        System.out.println("Startup Event");
    }

    void onStop(@Observes ShutdownEvent event) { // <3>
        System.out.println("Shutdown Event ");
    }
    
}