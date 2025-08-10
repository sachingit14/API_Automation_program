package com.thetestingacademy.ex_01_RA_concepts;

import io.restassured.RestAssured;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Rest_Assured_hello_world {
    private static final Log log = LogFactory.getLog(Rest_Assured_hello_world.class);

    public static void main(String[] args) {

        RestAssured.given()
                .baseUri("https://api.postalpincode.in")
                .basePath("pincode/400606")

                .when()
                .get()

                .then()
                .log().all().statusCode(200);

        System.out.println("ok");
    }
}
