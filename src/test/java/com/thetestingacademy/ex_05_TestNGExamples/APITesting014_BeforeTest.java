package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting014_BeforeTest {
    // PUT Request -
    // 1. getToken
    // 2. getBookingId
    // 3. test_PUT ( which will use the above two methods)
    // 4. closeAllThings

    @BeforeTest
    public void get_token(){
        System.out.println("before class for get token");
    }

    @BeforeTest
    public void get_bookingid(){
        System.out.println("before class for get booking id");
    }

    @Test
    public void test_put(){
        System.out.println("PUT request");
    }

    @AfterTest
    public void close_all_thing(){
        System.out.println("close");
    }
}
