package org.acme.quickstart;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class DeveloperResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .contentType("application/json")
          .body("{\"name\":\"Alexandra\",\"age\":39, \"favoriteLanguage\":\"java\"}")
          .when()
            .post("/developer")
            .then()
              .assertThat()
              .header("Location", "http://localhost:8081/developer/1")
              .statusCode(201);
    }


}
