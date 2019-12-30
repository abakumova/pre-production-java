package com.viktoriia_abakumova.lesson4.task4.tests;

import com.viktoriia_abakumova.lesson4.task4.calculators.Calculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void testSum() {
        Assert.assertEquals("Method sum is failed!", calculator.sum(5, 7), 12, 0);
    }

    @Test
    public void testDiv() {
        Assert.assertEquals("Method Div is failed!", calculator.division(12, 3), 4.0, 0);
    }

    @Test
    public void testSub() {
        Assert.assertEquals("Method Sub is failed!", calculator.subtraction(10, 6), 4, 0);
    }

    @Test
    public void testMultiplication() {
        Assert.assertEquals("Method multiplication is failed!", calculator.multiplication(3, 6), 18, 1);
    }

    @Test(expected = ArithmeticException.class)
    public void testNullDiv() {
        Assert.assertNotNull("Divider is 0!", calculator.division(9, 0));
    }
}