package com.example;

import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RoutingExchange;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class ApplicationRoutes {

    //    curl http://localhost:8081/ok
    public void routes(@Observes Router router) {
        router.get("/ok").handler(routingContext -> routingContext.response().end("OK from routes"));
    }

    //    curl "http://localhost:8081/ok_1"
    @Route(path = "ok_1", methods = Route.HttpMethod.GET)
    public void hello(RoutingContext routingContext) {
        routingContext.response().end("hello");
    }

    //    curl "http://localhost:8081/ok_2?name=world"
    @Route(path = "/ok_2", methods = Route.HttpMethod.GET)
    public void greetings(RoutingExchange routingExchange) {
        String name = routingExchange.getParam("name").orElse("world");

        routingExchange.ok("OK with annotation " + name);
    }

    //    curl "http://localhost:8081/ok_3?name=world"
    @Route(path = "/ok_3", methods = Route.HttpMethod.GET)
    void greetings_3(RoutingExchange ex) {
        ex.ok("hello " + ex.getParam("name").orElse("world"));
    }
}
