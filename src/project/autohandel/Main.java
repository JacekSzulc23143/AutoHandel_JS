package project.autohandel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner welcome = new Scanner(System.in);
        String greeting;

        System.out.println();
        System.out.println("Witaj w grze!");
        System.out.println("Wpisz swoje imię:");
        greeting = welcome.nextLine();
        System.out.println("Miłej zabawy " + greeting + ". Powodzenia.");
        System.out.println("--------------");
        System.out.println();
        System.out.println("Naciśnij enter.");
        welcome.nextLine();

        Action action = new Action();
        while (true) {
            action.showAction();
        }
    }
}
