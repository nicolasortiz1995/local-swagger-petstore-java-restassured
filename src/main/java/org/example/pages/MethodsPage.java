package org.example.pages;

import io.restassured.response.Response;
import utils.EnvironmentConfiguration;

import static io.restassured.RestAssured.given;

public class MethodsPage {
    private final String baseUrl = EnvironmentConfiguration.getEnvironmentVariable("BASE_URL");

    public Response makeRequestPost(String endpoint, String payload) {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/xml")
                .body(payload)
                .when()
                .post(baseUrl + endpoint)
                .then()
                .extract()
                .response();
    }

    public Response makeRequestPut(String endpoint, String payload) {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/xml")
                .body(payload)
                .when()
                .put(baseUrl + endpoint)
                .then()
                .extract()
                .response();
    }

    public Response makeRequestDelete(String endpoint) {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/xml")
                .when()
                .delete(baseUrl + endpoint)
                .then()
                .extract()
                .response();
    }

    public Response makeRequestGet(String endpoint){
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/xml")
                .when()
                .get(baseUrl + endpoint)
                .then()
                .extract()
                .response();
    }
}

