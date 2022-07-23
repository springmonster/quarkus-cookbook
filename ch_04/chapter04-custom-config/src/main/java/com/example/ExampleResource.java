package com.example;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @ConfigProperty(name = "greeting.color")
    String color;

    @ConfigProperty(name = "greeting.vat")
    Percentage vat;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    //    curl localhost:8081/hello/color
    @GET
    @Path("/color")
    @Produces(MediaType.TEXT_PLAIN)
    public String color() {
        return color;
    }

    @GET
    @Path("/vat")
    @Produces(MediaType.TEXT_PLAIN)
    public String vat() {
        return Double.toString(vat.getPercentage());
    }
}
