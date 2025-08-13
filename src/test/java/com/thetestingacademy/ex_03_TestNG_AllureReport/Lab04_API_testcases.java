package com.thetestingacademy.ex_03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab04_API_testcases {
    String pincode = "450564";

    @Test
    public void TC1_get_positive(){

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

    @Test
    public void TC2_get_negative(){
        System.out.println("------------//TC2-----------------");
        pincode = "sachin";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }

    @Test
    public void TC3_get_negative(){
        System.out.println("--------------//TC3---------------");
        pincode = "!@#";
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
