package com.thetestingacademy.ex_06_TestAssetions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class APITesting026_RestAssured_TestNG_AssertJ_Assertions {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String token;
    Integer bookingid;

    @Test
    public void test_create_booking_post() {

        String payload = "{\n" +
                "    \"firstname\" : \"Sachin\",\n" +
                "    \"lastname\" : \"Yadav\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        response = r.when().post();

        vr = response.then().log().all();
        vr.statusCode(200);  // TC1

        // FIRSTNAME = jim       //Lastname = brown    // bookingid not null

        //mathers
        vr.body("bookingid", Matchers.notNullValue());
        vr.body("booking.firstname", Matchers.equalTo("Sachin"));
        vr.body("booking.lastname", Matchers.equalTo("Yadav"));
        vr.body("booking.depositpaid", Matchers.equalTo(true));

        //extract
        // TestNG - Extract the details of the firstname, bookingId, lastname from Response.
        bookingid = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        // TestNG Assertions - 75%
        // SoftAssert vs
        // HardAssert -
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed
        Assert.assertEquals(firstname, "Sachin");
        Assert.assertEquals(lastname,"Yadav");
        Assert.assertNotNull(bookingid);

        // AssertJ( 3rd- Lib to Assertions) - 20%
        assertThat(bookingid).isNotNull().isPositive().isNotZero();
        assertThat(firstname).isNotEmpty().isNotBlank().isNotNull().isEqualTo("Sachin");

        //        String s = ""; //Empty
        //        String s2 = " "; //Blank
    }

}
