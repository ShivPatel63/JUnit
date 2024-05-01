package com.demo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CalculatorTest {

    @Test
    @DisplayName("Evaluating the expression ")
    void evaluateExpression() {
        Calculator calculator = new Calculator();
        int sum = calculator.evaluate("5+2+3");
        assertEquals(10,sum);
    }

    @Test
    @DisplayName("Checking Add")
    void add() {
        assertEquals(6,Calculator.add(3,3));
    }

    @Test
    void subtract() {
        assertEquals(4,Calculator.subtract(5,1));
    }

    @Test
    void mutliply() {
        assertEquals(10,Calculator.mutliply(5,2));
    }

    @Test
    void divide() {
        assertEquals(2,Calculator.divide(10,5));
    }
}