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
          .when()
          .queryParam("order", "desc")
          .header("authorization", "XYZ")
          .get("/hello")
          .then()
             .statusCode(200)
             .body(is("URI: http://localhost:8081/hello - Order desc - Authorization: XYZ"));
    }

    @Test
    public void testHelloLockEndpoint() {
        given()
          .when()
          .request("LOCK", "/hello/1")
          .then()
             .statusCode(200)
             .body(is("1 locked"));
    }
}