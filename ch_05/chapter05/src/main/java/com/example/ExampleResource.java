package com.example;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/hello")
public class ExampleResource {

    private final List<Person> personList = new ArrayList<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    //    curl -X POST -H "Content-Type: application/json" -d '{"name":"bob", "age":30, "favorite_language":"Chinese"}' localhost:8081/hello/person
    @POST
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Person> persons(Person person) {
        personList.add(person);
        return personList;
    }
}
