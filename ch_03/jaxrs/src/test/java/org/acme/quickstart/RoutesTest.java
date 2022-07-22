package org.acme.quickstart;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class RoutesTest {

    @Test
    public void testOkEndpoint() {
        given()
          .when()
          .get("/ok")
          .then()
             .statusCode(200)
             .body(is("OK from Route"));
    }
    
    @Test
    public void testDeclarativeEndpoint() {
        given()
          .when()
          .get("/declarativeok")
          .then()
             .statusCode(200)
             .body(is("OK world you are right"));
    }

    @Test
    public void testFilters() {
        given()
          .when()
          .get("/ok")
          .then()
             .statusCode(200)
             .header("V-Header", "Header added by VertX Filter")
             .body(is("OK from Route"));
    }

}