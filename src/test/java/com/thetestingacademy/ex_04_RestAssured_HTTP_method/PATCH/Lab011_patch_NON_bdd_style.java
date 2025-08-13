package com.thetestingacademy.ex_04_RestAssured_HTTP_method.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab011_patch_NON_bdd_style {
    @Test
    public void tc_non_bdd_put (){

        String bookingid = "1194";
        String token = "5f735a4c5417a45";

        String payload ="{\n" +
                "    \"firstname\" : \"sachin\",\n" +
                "    \"lastname\" : \"yadav\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
//        r.auth();
//        r.header("api-key","abc");
//        r.header("bearer","xyz");
        r.body(payload).log().all();

        Response response = r.when().log().all().patch();

        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(200);

    }
}

