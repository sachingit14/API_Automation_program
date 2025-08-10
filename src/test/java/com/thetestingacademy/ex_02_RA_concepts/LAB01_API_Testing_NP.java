package com.thetestingacademy.ex_02_RA_concepts;

public class LAB01_API_Testing_NP {
    public void  step1(){
        System.out.println("Step1");
    }
    public void  step2(){
        System.out.println("Step2");
    }
    public void  step3(String name){
        System.out.println("Step3");
    }

    public static void main(String[] args) {
        LAB01_API_Testing_NP np = new LAB01_API_Testing_NP();
        np.step1();
        np.step2();
        np.step3("sachin");
    }
}
