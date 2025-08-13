package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting018_TestNG_Parameter {

    @Parameters("browser")
    @Test
    public void cross_browser (String value) {

        System.out.println("Param running");

        if (value.equalsIgnoreCase("chrome")){
            System.out.println("Chrome is starting");
        }
        if (value.equalsIgnoreCase("firefox")){
            System.out.println("Firefox is starting");
        }

    }
}
