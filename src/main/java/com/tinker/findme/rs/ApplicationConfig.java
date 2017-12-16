package com.tinker.findme.rs;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author petervs
 */
@javax.ws.rs.ApplicationPath("/")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.tinker.findme.resource.EmpresasResource.class);
        resources.add(com.tinker.findme.rs.GenericResource.class);
    }
    
}
