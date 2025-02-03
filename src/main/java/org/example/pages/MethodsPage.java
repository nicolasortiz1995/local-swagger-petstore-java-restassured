package org.example.pages;

import io.restassured.response.Response;
import utils.EnvironmentConfiguration;

import static io.restassured.RestAssured.given;

/**
 *  This class provides methods to make HTTP requests using Rest Assured.
 *  It encapsulates the logic for common HTTP methods (POST, PUT, DELETE, GET)
 *  and handles setting common headers and extracting responses.
 */
public class MethodsPage {

    /**
     * The base URL for the API, loaded from environment configuration.
     */
    private final String baseUrl = EnvironmentConfiguration.getEnvironmentVariable("BASE_URL");

    /**
     * Makes a POST request to the specified endpoint with the given payload.
     *
     * @param endpoint The endpoint to send the POST request to.
     * @param payload The request body payload as a String, typically in JSON format.
     * @return The Response object from the POST request.
     */
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

    /**
     * Makes a PUT request to the specified endpoint with the given payload.
     *
     * @param endpoint The endpoint to send the PUT request to.
     * @param payload The request body payload as a String, typically in JSON format.
     * @return The Response object from the PUT request.
     */
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

    /**
     * Makes a DELETE request to the specified endpoint.
     *
     * @param endpoint The endpoint to send the DELETE request to.
     * @return The Response object from the DELETE request.
     */
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

    /**
     * Makes a GET request to the specified endpoint.
     *
     * @param endpoint The endpoint to send the GET request to.
     * @return The Response object from the GET request.
     */
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