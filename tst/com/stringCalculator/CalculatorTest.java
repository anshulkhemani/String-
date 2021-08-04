/*
 * Author : Anshul Khemani
 * Date : 04/08/2021
 * */

package com.stringCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void shouldReturnZeroOnEmpty()
    {
        assertEquals(0,Calculator.add(""));
    }
    @Test
    public void shouldReturnNumOnSingleValue()
    {
        assertEquals(1,Calculator.add("1"));
    }
    @Test
    public void shouldReturnSumOnTwoValues()
    {
        assertEquals(3,Calculator.add("2,1"));
    }
    @Test
    public void shouldReturnSumOnNValues()
    {
        assertEquals(28,Calculator.add("2,1,4,8,4,2,7"));
    }
    @Test
    public void shouldReturnSumWithNewline()
    {
        assertEquals(28,Calculator.add("2,1,4\n8,4\n2,7"));
    }
    @Test
    public void shouldReturnSumWithCustomSeparator(){
        assertEquals(10, Calculator.add("//;\n1;2;3;4"));
    }
    @Test
    public void checkForNegativeNumbers(){
        try {
            Calculator.add("-2,8");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed : -2");
        }

        try {
            Calculator.add("1,-2,-5,9,-10,0");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed : -2,-5,-10");
        }
    }
    @Test
    public void ignoreNumbersGT1000(){
        assertEquals(2, Calculator.add("2,1001"));
    }
}