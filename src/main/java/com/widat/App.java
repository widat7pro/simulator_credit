package com.widat;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Menu:");
        System.out.println("1. Satu");
        System.out.println("2. Dua");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {


            try {
                choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.println("satu");
                } else if (choice == 2) {
                    System.out.println("dua");
                } else {
                    System.out.println("not found");
                }
            } catch (InputMismatchException e){
                scanner.next();
            }
        } while (choice != 3);
        scanner.close();

    }
}
