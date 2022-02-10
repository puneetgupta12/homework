package com.gupta.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Quit scanner when user enters "quit", rest add to a list
public class QuitScanner {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();

        System.out.print("Enter some stuff: ");
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String s1 = scan.nextLine();

            if (s1.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                System.out.println();
                break;
            }

            System.out.println(s1);
            input.add(s1);
        }

        System.out.print("Added stuff: " + input.toString());
    }
}
