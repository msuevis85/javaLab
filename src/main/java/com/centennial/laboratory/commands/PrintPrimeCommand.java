package com.centennial.laboratory.commands;

/**
 * Class that try to find id a number is prime or not
 * and print the result.
 *
 * @author miguel angel suevis Pacheco
 * @version 0.0.1
 */
public class PrintPrimeCommand implements ICommand{

    /* number set by the user*/
    private int numberToValidate;

    public PrintPrimeCommand(int numberToValidate){
        this.numberToValidate = numberToValidate;
    }


    public void printIsPrimeNumber() {
        String resultValidation = checkPrime() ? " is" : " is not";
        System.out.println("The number "+this.numberToValidate+ resultValidation+" prime");
    }

    private boolean checkPrime(){

        boolean isPrimerNumber = true;
        if(this.numberToValidate == 1 || this.numberToValidate == 0) {
            isPrimerNumber = false;
        } else {
            for (int i = 2; i <= this.numberToValidate / 2 ; i++) {
                if(this.numberToValidate % i == 0) {
                    isPrimerNumber = false;
                    break;
                }
            }
        }

       return isPrimerNumber;
    }


    @Override
    public void execute() {
         this.printIsPrimeNumber();
    }

}
