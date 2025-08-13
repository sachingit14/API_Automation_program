package com.thetestingacademy.ex_04_RestAssured_HTTP_method.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab006_get_bdd_style {

    @Test
    public void Test_1_get_positive (){
        String pincode = "400606";
        System.out.println("------------//TC1-----------------");
        pincode = "400606";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

    }
}
