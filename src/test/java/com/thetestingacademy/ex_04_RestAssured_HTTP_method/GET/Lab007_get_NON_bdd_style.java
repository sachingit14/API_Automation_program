package com.thetestingacademy.ex_04_RestAssured_HTTP_method.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab007_get_NON_bdd_style {

    RequestSpecification r;
    Response response ;
    ValidatableResponse vr ;
    String pincode ;

    @Test
    public void TC_1_Get_NONBDD(){
        pincode = "400606";
        //part1
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/"+pincode);

        //part2
        response = r.when().log().all().get();
        System.out.println(response.asString());

        //part3
        vr = response.then().log().all();
        vr.statusCode(200);
    }
    @Test
    public void TC_1_Get_NONBDD_2(){
        pincode = "@#!#";
        //part1
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/"+pincode);

        //part2
        response = r.when().log().all().get();
        System.out.println(response.asString());

        //part3
        vr = response.then().log().all();
        vr.statusCode(200);
    }
}
