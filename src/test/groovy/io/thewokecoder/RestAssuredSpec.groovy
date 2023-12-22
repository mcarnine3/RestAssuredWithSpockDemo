package io.thewokecoder

import io.restassured.builder.RequestSpecBuilder
import spock.lang.Shared
import spock.lang.Specification

import static io.restassured.RestAssured.*
import static io.restassured.matcher.RestAssuredMatchers.*
import static org.hamcrest.Matchers.*


class RestAssuredSpec extends Specification {
    @Shared
    def requestSpec =
            new RequestSpecBuilder()
                    .setBaseUri("https://jsonplaceholder.typicode.com")
                    .build()

    def "validate json response"() {
        given: "set up request"
        def request = given(requestSpec)

        when: "get todos"
        def response = request.get("/users/1")

        then: "should 200 okay, response matching expected"
        response.then()
                .statusCode(200)
                .body("id", is(1))
                .body("name", is("Leanne Graham"))
                .body("company.name", is("Romaguera-Crona"))
    }
}
