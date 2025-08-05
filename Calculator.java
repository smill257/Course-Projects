/*
Class: CSE 1321L
Section: J04
Term: Fall 2022
Instructor: Aarthi Poovalingam
Name: Sam Miller
Assignment#: Assignment4B
*/

import java.util.Scanner;
public class Assignment4B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number;
        int menu;

        System.out.println("Welcome!");
        do {
            System.out.print("Please input a number: ");
        number = scan.nextInt();

            System.out.println("What would you like to do to this number: ");
            System.out.println("-1- Re-enter the number");
            System.out.println("0- Get the additive inverse of the number");
            if (number != 0) { //nested if loop for if not equal to 0 then don't show #1
                System.out.println("1- Get the reciprocal of the number");
            }
            System.out.println("2- Square the number");
            System.out.println("3- Cube the number");
            System.out.println("4- Exit the program");

            menu = scan.nextInt();

            while ((menu < -1) || (menu > 4)) { //while statement setting boundaries for valid number input
                System.out.println("Please enter a valid number between -1 and 4: ");
                menu = scan.nextInt();
            }

            switch (menu) {
                case -1:
                    break;
                case 0:
                    System.out.println("The additive inverse of " + number + " is -" + number);
                   // System.out.println("Please input a number: ");
                    break;
                case 1:
                    System.out.println("The reciprocal of " + number + " is " + (1f / number));
                    break;
                case 2:
                    System.out.println("The square of " + number + " is " + (number * number));
                    break;
                case 3:
                    System.out.println("The cube of " + number + " is " + (number * number * number));
                    break;
                case 4:
                    System.out.println("Thank you, goodbye!");

                    break;
            }
            System.out.println(); //white space

        }
        while (menu != 4); //if the menu isn't equal to 4 then keep running the program

    }

}
