package com.crowdar.examples.services;

import com.crowdar.core.PropertyManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

public class APIManagement {
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

    public static Response sendDeleteRequest(String endpoint,String param,List<String> paramValues) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .queryParam(param,paramValues)
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

    public static String checkForWorkspace() {
        Response workspacesList = sendGetRequestAndSaveResponse("/workspaces");
        String responseBody = workspacesList.getBody().asString();

        JsonPath workspaceResponse = new JsonPath(responseBody);
        boolean workspaceExists = workspaceResponse.getBoolean("find { it.name == 'tpFinal_mobile' } != null");
        String workspaceID;

        if (workspaceExists) {
            workspaceID = workspaceResponse.getString("find { it.name == 'tpFinal_mobile' }.id");
        } else {
            System.out.println("Workspace 'tpFinal_AAT' doesn't exist. Creating workspace.");
            String body = "{\"name\":\"tpFinal_AAT\"}";
            Response createWorkspaceResponse = sendPostRequest("/workspaces", body);
            JsonPath jsonResponse = createWorkspaceResponse.jsonPath();
            workspaceID = jsonResponse.getString("id");
            System.out.println("Created Workspace ID: " + workspaceID);
        }
        return workspaceID;
    }

    public static void cleanUpEntriesAfterTest() {
        String endpoint = "/workspaces/"+checkForWorkspace()+"/user/65383a07205d0441c5269f46/time-entries";
        Response entriesList = sendGetRequestAndSaveResponse(endpoint);
        String responseBody = entriesList.getBody().asString();
        JsonPath entryResponse = new JsonPath(responseBody);
        boolean entriesExists = entryResponse.getBoolean("find { it.description.endsWith('_CleanAfterTest') } != null");

        if (entriesExists) {
            List<String> timeEntryIds = entryResponse.getList("findAll { it.description.contains('_CleanAfterTest') }.id");
            System.out.println(timeEntryIds);
            sendDeleteRequest(endpoint,"time-entry-ids",timeEntryIds);
            System.out.println("Successfully deleted the following entries: "+ GenericService.parseListToString(timeEntryIds)+".");
        } else{
            System.out.println("No entries found on workspace"+checkForWorkspace()+".");
        }
    }

    public static void cleanUpSpecificEntry() {
        String endpoint = "/workspaces/"+checkForWorkspace()+"/user/65383a07205d0441c5269f46/time-entries";
        Response entriesList = sendGetRequestAndSaveResponse(endpoint);
        String responseBody = entriesList.getBody().asString();
        JsonPath entryResponse = new JsonPath(responseBody);
        boolean entriesExists = entryResponse.getBoolean("find { it.description == 'taskTPFINAL' } != null");

        if (entriesExists) {
            List<String> timeEntryIds = entryResponse.getList("findAll { it.description == 'taskTPFINAL' }.id");
            System.out.println(timeEntryIds);
            sendDeleteRequest(endpoint,"time-entry-ids",timeEntryIds);
            System.out.println("Successfully deleted time entry.");
        } else{
            System.out.println("No entries found on workspace: "+checkForWorkspace()+" with specified id.");
        }
    }

}
