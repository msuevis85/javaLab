package com.centennial;

import com.centennial.model.Menu;

import java.util.Scanner;

/**
 * Main class to execute the laboratory assignment,
 * and works as an entry point to execute the logic.
 *
 * @author miguel angel suevis Pacheco
 * @version 0.0.1
 */
public class AssignmentOne {

    public AssignmentOne(){

    }

    public static void main(String[] args) throws InterruptedException {
        int option = 10;
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        do {
            menu.showPrincipalMenu();
            option = scanner.nextInt();
            menu.showOptionMenu(option);

        }while (option != 0);
    }
}
