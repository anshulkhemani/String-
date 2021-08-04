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
            int position = 2;
            String character="";
            if(numbers.matches("//(.*)\n(.*)")) { //Example pattern "//;\n1;2"
                separator = Character.toString(numbers.charAt(position)); //Fetching the separator from string
                numbers = numbers.substring(4); //Remove the delimiter characters from string
            }
            else if(numbers.matches("//(.*)")) //Example pattern "//[*][%]\n1*2%3"
            {
                separator="";
                position = 2;
                while(numbers.charAt(position)=='[') { //while there are delimiters
                    position++;
                    while (numbers.charAt(position) != ']') { //until each delimiter length
                        character = Character.toString(numbers.charAt(position)); //Fetching the delimiter from string and appending
                        if (character.equals("*") || character.equals("^") || character.equals("+")) { //java regex exceptions
                            separator += "\\" + character;
                        } else {
                            separator += character;
                        }
                        position++; //next character in string
                    }
                    position++;
                    if(numbers.charAt(position)=='[') { //check if there is next delimiter
                        separator += "|";
                    }
                }
                numbers = numbers.substring(position+2); //Remove the delimiter characters from string
            }
            String[] numbersList = numbers.split(separator+"|\n"); //List of numbers input in the string separated by separator
            return total(numbersList);
        }
    }
}
