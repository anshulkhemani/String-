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
        int sum = 0,currentNumber;
        String negatives = "";
        for(String number : numbers){
            currentNumber = convertToInt(number);
            if(currentNumber < 0){  //Checking for negative values
                if(negatives.equals(""))
                {
                    negatives = number;
                }
                else {
                    negatives += ("," + number);
                }
            }
            else if(currentNumber<=1000) { //Ignoring numbers greater than 1000
                sum += currentNumber; //Converting each number in string and adding in sum
            }
        }
        if(!negatives.equals("")){
            throw new IllegalArgumentException("Negatives not allowed : " + negatives);
        }

        return sum;
    }

    public static int add(String numbers) {
        if(numbers.equals("")){
            return 0;
        }
        else{
            String separator = ","; //Default separator
            if(numbers.matches("//(.*)\n(.*)")) //Example pattern "//;\n1;2"
            {
                separator = Character.toString(numbers.charAt(2)); //Fetching the separator from string
                numbers = numbers.substring(4); //Remove first 4 characters from string
            }
            String[] numbersList = numbers.split(separator+"|\n"); //List of numbers input in the string separated by separator
            return total(numbersList);
        }
    }
}
