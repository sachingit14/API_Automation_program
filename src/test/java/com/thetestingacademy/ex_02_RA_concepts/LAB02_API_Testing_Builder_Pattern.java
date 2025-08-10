package com.thetestingacademy.ex_02_RA_concepts;

public class LAB02_API_Testing_Builder_Pattern {
    public LAB02_API_Testing_Builder_Pattern  step1(){
        System.out.println("Step1");
        return this;
    }

    public LAB02_API_Testing_Builder_Pattern  step2(){
        System.out.println("Step2");
        return this;
    }
    public LAB02_API_Testing_Builder_Pattern  step3(String name){
        System.out.println("Step3");
        return this;
    }

    public static void main(String[] args) {
        LAB02_API_Testing_Builder_Pattern bp = new LAB02_API_Testing_Builder_Pattern();
        bp.step1().step2().step3("sachin");
    }


}
