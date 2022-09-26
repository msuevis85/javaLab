package com.centennial.model;

import com.centennial.laboratory.commands.*;
import com.centennial.laboratory.commands.enums.ConversionType;

import java.util.Scanner;

/**
 *  Class show menu and sub menu
 *
 * @author miguel angel suevis Pacheco
 * @version 0.0.1
 */
public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private ICommand command ;

    public void showPrincipalMenu(){
        System.out.println("*************************************************************************************");
        System.out.println("**      1. print out if a given integer is a prime number                          **");
        System.out.println("**      2. swap the content of two variables of type integer                       **");
        System.out.println("**      3. converts a temperature from Centigrade to Fahrenheit                    **");
        System.out.println("**      4. sum only the integers between 1,100 (inclusive) that are multiple of 3  **");
        System.out.println("**      5. guessing game where the user has to guess a secret number               **");
        System.out.println("**      0. Exit                                                                    **");
        System.out.println("*************************************************************************************");
    }

    public void showOptionMenu(int option) throws InterruptedException {

        switch (option) {
            case 1 :
                showOptionOne();
            break;
            case 2 :
                showOptionTwo();
            break;
            case 3 :
                showOptionThree();
            break;

            case 4 :
                showOptionFour();
            break;

            case 5 :
                showOptionFive();
                break;

            case 0 :
                System.out.println("It was a pleasure, thank you and see you next time");
                System.exit(0);
                break;
        }

        System.out.println("");
        Thread.sleep(2000);
    }

    private void showOptionOne(){

        System.out.println("Please enter a number :  ");
        int number = scanner.nextInt();

        command = new PrintPrimeCommand(number);
        command.execute();
    }

    private void showOptionTwo() {

        int variableA;
        int variableB;
        System.out.println("please enter value of the variable A : ");
        variableA = scanner.nextInt();
        System.out.println("please enter value of the variable B : ");
        variableB = scanner.nextInt();

        command = new SwapNumberCommand(variableA,variableB);
        command.execute();
    }

    private void showOptionThree() {

        ConversionType type;
        int temperature;
        System.out.println("*************************************************************************************");
        System.out.println("**         1. to convert from Celsius to Fahrenheit                                 **");
        System.out.println("**         2. to convert from Fahrenheit to Celsius                                 **");
        System.out.println("*************************************************************************************");
        type = scanner.nextInt() == 1 ? ConversionType.CELSIUS_TO_FAHRENHEIT : ConversionType.FAHRENHEIT_TO_CELSIUS;

        System.out.println("Enter the temperature to convert");
        temperature = scanner.nextInt();

        command = new ConvertTemperatureCommand(type,temperature);
        command.execute();
    }


    private void showOptionFour(){
        System.out.println("Please enter a number to set the limit between 1 and the number :");
        int limit = scanner.nextInt();
        System.out.println("please enter the multiple to calculate the sum :");
        int multiple = scanner.nextInt();
        command = new SumCommand(multiple,limit);
        command.execute();
    }


    private void showOptionFive(){

        GuessCommand command = new GuessCommand();
        int guessNumber;
        do {
            System.out.println("Please enter a number and try to guess my secret number or press 0 to exit :");
            guessNumber = scanner.nextInt();
            if(guessNumber!=0){
                command.setGuess(guessNumber);
                command.execute();
            }

        }while (guessNumber!=0);


    }
}
