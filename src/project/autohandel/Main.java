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

        System.out.println("**************************************");
        System.out.println("*     Autohandel u Złotego Zenka     *");
        System.out.println("*           Gra tekstowa             *");
        System.out.println("*            WSB 2022 r.             *");
        System.out.println("*             ver. 1.0               *");
        System.out.println("**************************************");

        Action action = new Action();
        while (true) {
            action.showAction();
        }
    }
}
