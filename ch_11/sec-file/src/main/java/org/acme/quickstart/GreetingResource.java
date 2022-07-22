package org.acme.quickstart;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {
    // tag::method[]
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("Tester")
    public String hello() {
        return "hello";
    }
    // end::method[]
}