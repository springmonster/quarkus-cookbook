package org.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "greeting.message")
    String message;

    //    curl localhost:10001/hello
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return message;
    }

    @ConfigProperty(name = "greeting.upper-case", defaultValue = "true")
    boolean upperCase;

    //    curl localhost:10001/hello/optional
    @GET
    @Path("/optional")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloOptional() {
        return upperCase ? message.toUpperCase() : message;
    }

    @ConfigProperty(name = "greeting.suffix")
    List<String> suffixes;

    //    curl localhost:10001/hello/list
    @GET
    @Path("/list")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloList() {
        return message + suffixes.get(0);
    }
}
