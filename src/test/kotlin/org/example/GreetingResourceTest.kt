package org.example

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class GreetingResourceTest {

    @Test
    fun testPhoneValidation() {
        given()
            .contentType("application/json")
            .body("""{"mobilePhone": "123", "workPhone": "123"}""")
        .`when`()
            .post("/hello/validate")
        .then()
            .statusCode(400)
            .body("title", `is`("Constraint Violation"))
            .body("violations.size()", `is`(2))
    }

}