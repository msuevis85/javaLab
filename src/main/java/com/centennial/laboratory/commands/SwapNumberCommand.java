package com.centennial.laboratory.commands;

/**
 *  Class that swap two number and print
 *  the result.
 *
 * @author miguel angel suevis Pacheco
 * @version 0.0.1
 */
public class SwapNumberCommand implements ICommand{

    private int number1;
    private int number2;

    public  SwapNumberCommand(int number1, int number2){
        this.number1 = number1;
        this.number2 = number2;
    }

    public void printSwapNumbers(){
       System.out.println("The value of number 1 before swap is : "+ this.number1+" and number 2 before swap is "+this.number2);
       swap();
       System.out.println("The value of number 1 after swap is : "+ this.number1+" and number 2 after swap is "+this.number2);
    }

    private void swap(){
        int temp = this.number1;
        this.number1 = this.number2;
        this.number2 = temp;
    }

    @Override
    public void execute() {
       this.printSwapNumbers();
    }

}
