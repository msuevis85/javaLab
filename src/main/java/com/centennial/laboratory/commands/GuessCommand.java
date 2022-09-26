package com.centennial.laboratory.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Class that execute a guess in a guessing game where the user has to guess
 * a secret number. After every guess the program tells the user whether their
 * number was too large or too small.
 *
 * @author miguel angel suevis Pacheco
 * @version 0.0.1
 */
public class GuessCommand implements ICommand{

    private int guess ;
    private ArrayList<Integer> numbersGuessed;
    private int numberTries;
    private int numberToGuess;
    private static final int MAX_NUMBER_TRIES = 10;

    public GuessCommand(){
        numberToGuess();
        numbersGuessed = new ArrayList<>();
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getGuess(){
        return this.guess;
    }

    private void guessNumber(){

        if (numberTries == MAX_NUMBER_TRIES) {
            System.out.println(String.format("you take [%s] of tries to guess our number you don't have more tries",numberTries));
            System.out.println(String.format("number used to guess our number",numbersGuessed));
        } else {
            guess();
        }
    }

    private void guess(){

        if(numbersGuessed.contains(guess)){
            System.out.println(String.format("The number %s was guessed in another try please try again with a different number",guess));
        } else if (guess > numberToGuess) {
            numberTries++;
            System.out.println(String.format("your number [%s] was too high",guess));
            numbersGuessed.add(guess);
        } else if (guess < numberToGuess) {
            numberTries++;
            System.out.println(String.format("your number [%s] was too low",guess));
            numbersGuessed.add(guess);
        } else if (guess == numberToGuess) {
            numberTries++;
            numbersGuessed.add(guess);
            System.out.println(String.format("your Win the number [%s] was our secret number",guess));
            System.out.println(String.format("you take [%s] of tries to guess our number",numberTries));
            System.out.println(String.format("numbers used to guess our number were %s", Arrays.toString(numbersGuessed.toArray())));
        }
    }

    private void numberToGuess() {
        int max = 100;
        int min = 1;
        Random random = new Random();
        this.numberToGuess = random.nextInt(50) + 1;
    }

    @Override
    public void execute() {
     guessNumber();
    }

    public static void main(String[] args) {
        GuessCommand command = new GuessCommand();
        Scanner scanner = new Scanner(System.in);
        int opt =1;
        while (opt !=0){
           System.out.println("Digite su intento : ");
           opt = scanner.nextInt();
           command.setGuess(opt);
           command.execute();
        }

    }
}
