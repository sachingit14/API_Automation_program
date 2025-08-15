package com.thetestingacademy.ex_07_Payload_management.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting028_RestAssured_Payload_Map {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void test_POST() {


        //        String payload_POST = "{\n" +
//                "    \"firstname\" : \"Pramod\",\n" +
//                "    \"lastname\" : \"Dutta\",\n" +
//                "    \"totalprice\" : 111,\n" +
//                "    \"depositpaid\" : false,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2024-01-01\",\n" +
//                "        \"checkout\" : \"2024-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Lunch\"\n" +
//                "}";

        // Hashmap -> key and value pair
        // Parent Hashmap ->  key and value , Child Hashmap

        Map<String,Object> jsonbodyusingmap = new LinkedHashMap<>();
        jsonbodyusingmap.put("firstname","Sachin");
        jsonbodyusingmap.put("lastname", "Dutta");
        jsonbodyusingmap.put("totalprice", 123);
        jsonbodyusingmap.put("depositpaid", false);

        Map<String,Object> bookingdatemap = new LinkedHashMap<>();
        bookingdatemap.put("checkin","2018-01-01");
        bookingdatemap.put("checkout","2019-01-01");

        jsonbodyusingmap.put("bookingdates",bookingdatemap);

        jsonbodyusingmap.put("additionalneeds", "Breakfast");

        System.out.println(jsonbodyusingmap);

        // Hashmap -> JSON? or ClaSS TO json
        // 1. Gson
        // 2. Jackson API


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonbodyusingmap).log().all();

        Response response = requestSpecification.when().post();
        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


    }

}