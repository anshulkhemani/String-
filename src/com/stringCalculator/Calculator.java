/*
* Author : Anshul Khemani
* Date : 04/08/2021
* */

package com.stringCalculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in); // Scanner to read values
        System.out.print("Enter a string of numbers - ");
        String additionString= sc.nextLine();
        System.out.println("Output is - "+add(additionString)); // Call the addition function
    }

    private static int convertToInt(String number)
    {
        return Integer.parseInt(number);
    }

    private static int total(String[] numbers){
        int sum = 0;
        for(String number : numbers){
            sum += convertToInt(number); //Converting each number in string and adding in sum
        }
        return sum;
    }

    public static int add(String numbers) {
        if(numbers.equals("")){
            return 0;
        }
        else{
            String[] numbersList = numbers.split(","); //List of numbers input in the string
            return total(numbersList);
        }
    }
}
