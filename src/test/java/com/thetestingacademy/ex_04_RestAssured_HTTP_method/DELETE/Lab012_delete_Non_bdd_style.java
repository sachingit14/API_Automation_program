package com.thetestingacademy.ex_04_RestAssured_HTTP_method.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab012_delete_Non_bdd_style {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void tc_non_bdd_put (){

        String bookingid = "4592";
        String token = "f327bce34754cb7";
        //body not require

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
//        r.auth();
//        r.header("api-key","abc");
//        r.header("bearer","xyz");

        response = r.when().log().all().delete();

        vr = response.then().log().all();
        vr.statusCode(201);

    }
}

