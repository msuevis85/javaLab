package com.centennial.laboratory.commands;

/**
 * Class that sum only the integers between 1,100 (inclusive)
 * that are multiple of 3.
 *
 * @author miguel angel suevis Pacheco
 * @version 0.0.1
 */
public class SumCommand implements ICommand{

    public static final String MESSAGE_SUM_MULTIPLES = "Result of sum integer between %s and %s is %s";
    //By default use 3 to calculate the sum
   private int numberToCalculateSum = 3;
    private int limit = 100;

   public SumCommand(int numberToCalculateSum, int limit){
       this.numberToCalculateSum = numberToCalculateSum;
       this.limit = limit;
   }


   private void calculate() {

       int multiple = limit / numberToCalculateSum;
       int result = numberToCalculateSum * multiple * (multiple + 1) / 2;

       System.out.println(String.format(MESSAGE_SUM_MULTIPLES,
               numberToCalculateSum,
               limit,result
               ));
   }

    @Override
    public void execute() {
       calculate();
    }

}
