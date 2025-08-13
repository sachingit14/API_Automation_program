package com.thetestingacademy.ex_04_RestAssured_HTTP_method.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab009_post_NON_bdd_style {
        RequestSpecification r;
        Response response;
        ValidatableResponse vr;

   @Test
   public void Test_1_post_create_token (){
       String payload = "{\n" +
               "    \"username\" : \"admin\",\n" +
               "    \"password\" : \"password123\"\n" +
               "}";

      //part 1
       r = RestAssured.given();
       r.baseUri("https://restful-booker.herokuapp.com");
       r.basePath("/auth");
       r.contentType(ContentType.JSON);
       r.body(payload).log().all();

       //part 2
       response = r.when().log().all().post();

       //part 3
       vr = response.then().log().all();
       vr.statusCode(200);

   }
}
