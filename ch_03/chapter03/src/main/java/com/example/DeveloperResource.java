package com.example;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/developer")
public class DeveloperResource {

    //    curl -H "Content-Type: application/json" -d '{"name":"ada"}' -X POST http://localhost:8081/developer
    // cors
    // curl -H "Content-Type: application/json" -d '{"name":"ada"}' -X POST http://localhost:8081/developer -H "Origin: http://example.com" --verbose
    // check
    // < access-control-allow-origin: http://example.com
    //< access-control-allow-credentials: true
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDeveloper(Developer developer) {
        developer.persist();
        return Response.created( // <1>
                        UriBuilder
                                .fromResource(DeveloperResource.class) // <2>
                                .path(Long.toString(developer.getId())) // <3>
                                .build()
                )
                .entity(developer) // <4>
                .build(); // <5>
    }

    public static class Developer {

        static long counter = 1;

        private long id;
        private String name;

        public long getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void persist() {
            this.id = counter++;
        }
    }
}
