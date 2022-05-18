package com.gupta.java.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PowerOf2InnerClass {
    public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());
            Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private
            PowerOf2InnerClass.Inner inner = new PowerOf2InnerClass.Inner();
            o = inner.new Private();

            System.out.println(num + " is " + ((PowerOf2InnerClass.Inner.Private) o).powerof2(num));
            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
    }//end of main

    static class Inner{
        private class Private{
            private String powerof2(int num){
                return ((num&num-1)==0) ? "power of 2" : "not a power of 2";
            }
        }
    }//end of Inner
}
