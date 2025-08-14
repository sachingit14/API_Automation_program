package com.thetestingacademy.ex_06_TestAssetions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting025_TestNG_Assertions {

    @Test(enabled = true)
    public void Test_hard_assertion_eg (){
        System.out.println("Start of the program");
        Assert.assertEquals("sachin","Sachin");
        System.out.println("End");
    }

    @Test
    public void Test_Soft_assertion_eg (){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("sachin","Sachin");
        System.out.println("End");
        softAssert.assertAll();
    }
}
