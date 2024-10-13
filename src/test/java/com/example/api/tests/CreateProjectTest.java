package com.example.api.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateProjectTest {

    @Test
    public void testCreateProject() {
        // Pastikan menggunakan base URI yang valid
        RestAssured.baseURI = "https://en.todoist.com";  // Ganti dengan base URL yang benar

        // Payload untuk membuat project baru
        String requestBody = "{\n" +
                "  \"name\": \"Test Project\",\n" +
                "  \"description\": \"Project created for testing API\",\n" +
                "  \"status\": \"active\"\n" +
                "}";

        // Lakukan request POST untuk membuat project
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/projects")  // Pastikan endpoint benar
                .then()
                .statusCode(201)  // Cek apakah project berhasil dibuat dengan status code 201
                .extract().response();

        // Verifikasi response
        String projectId = response.jsonPath().getString("id");
        System.out.println("Project ID created: " + projectId);
    }
}
