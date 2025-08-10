package com.thetestingacademy.ex_02_RA_concepts;

import io.restassured.RestAssured;

public class LAB03_Multiple_TC {
    public static void main(String[] args) {
        System.out.println("------------//TC1-----------------");
        String pincode = "400606";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
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
     //   System.out.println("-----------------------------");

    }
}
