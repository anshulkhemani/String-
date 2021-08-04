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
}