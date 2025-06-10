/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WARConfig;

import java.util.Set;

/**
 *
 * @author d4cd13ger
 */
@jakarta.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends jakarta.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
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
        resources.add(WAREndpoint.DomainWAR.class);
        resources.add(WAREndpoint.FieldWAR.class);
        resources.add(WAREndpoint.OperationWAR.class);
        resources.add(WAREndpoint.ProductWAR.class);
        resources.add(WAREndpoint.UsersWAR.class);
        resources.add(WARSecurity.AuthFilter.class);
        resources.add(WARSecurity.AuthWAR.class);
        resources.add(WARSecurity.CorsFilter.class);
    }
    
}
