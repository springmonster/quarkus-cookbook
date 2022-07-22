package org.acme.quickstart;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello World"));
    }

    @Test
    public void testHelloOptionalEndpoint() {
        given()
          .when().get("/hello/optional")
          .then()
             .statusCode(200)
             .body(is("HELLO WORLD"));
    }

    @Test
    public void testHelloListEndpoint() {
        given()
          .when().get("/hello/list")
          .then()
             .statusCode(200)
             .body(is("Hello World How are you?"));
    }

    @Test
    public void testHelloConfigEndpoint() {
        given()
          .when().get("/hello/config")
          .then()
             .statusCode(200)
             .body(is("Hello World"));
    }

}