package com.crowdar.examples.services;

import com.crowdar.core.PropertyManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiHelperService {
    public static final String baseUrl = "https://api.clockify.me/api/v1";
    public static final String apiKey = PropertyManager.getProperty("clockify.token");

    public static Response sendPostRequest(String endpoint, String body) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .body(body)
                .post(baseUrl+endpoint)
                .then().extract().response();
    }

    public static Response sendPutRequest(String endpoint, String body) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .body(body)
                .put(baseUrl+endpoint);
    }

    public static Response sendGetRequest(String endpoint) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .when()
                .get(baseUrl+endpoint);
    }

    public static Response sendDeleteRequest(String endpoint) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .delete(baseUrl+endpoint);
    }

    public static Response sendGetRequestAndSaveResponse(String endpoint) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .when()
                .get(baseUrl+endpoint)
                .then()
                .extract()
                .response();
    }

}
