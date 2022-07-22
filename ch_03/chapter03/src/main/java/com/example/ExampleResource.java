package com.example;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/hello")
public class ExampleResource {

    enum Order {
        asc, desc
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    //    curl -X POST -H "Content-Type:text/plain" --data "world" http://localhost:8081/hello
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public void create(String message) {
        System.out.println("create");
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(String message) {
        System.out.println("update");
        return message;
    }

    @DELETE
    public void delete() {
        System.out.println("delete");
    }

    //    curl -X GET -H "accept: text/plain" -H "authorization: xyz" "http://localhost:8081/hello/params?order=desc"
    @GET
    @Path("/params")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWithParams(@Context UriInfo uriInfo, @QueryParam("order") Order order, @NotBlank @HeaderParam("authorization") String authorization) {
        return String.format("URI %s = Order %s - Authorization %s", uriInfo.getAbsolutePath(), order, authorization);
    }

    //    curl -X REFRESH http://localhost:8081/hello/1
    @REFRESH
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public String lockResource(@PathParam("id") long id) {
        return id + " refreshed";
    }
}
