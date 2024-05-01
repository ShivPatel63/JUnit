package com.demo.model;

public class Calculator {

    public int evaluate(String expression) {

        int sum = 0;
        for(String summand : expression.split("\\+")) {
            sum += Integer.valueOf(summand);
        }
        return sum;

    }

    public Calculator() {}

    public static int add(int i, int j) {
        return i +j;

    }

    public static int subtract(int i, int j) {
        return i  - j;

    }

    public static int mutliply(int i, int j) {
        return i  * j;

    }
    public static int divide(int i, int j) {
        return i/j;

    }
}