package project.autohandel;

import java.util.Scanner;

public class Action {

    Scanner scanner = new Scanner(System.in);
    String actionChoice;


    CarDatabase base = new CarDatabase(5);

    public void showAction() {
        System.out.println("**************************************");
        System.out.println("*     Autohandel u Złotego Zenka     *");
        System.out.println("*           Gra tekstowa             *");
        System.out.println("*            WSB 2022 r.             *");
        System.out.println("*             ver. 1.0               *");
        System.out.println("**************************************");
        System.out.println();
        System.out.println("*------------[ MENU GRY ]------------*\n");
        System.out.println("[0] Instrukcja i cel gry.");
        System.out.println("[1] Przeglądaj bazę samochodów do kupienia.");
        System.out.println("[2] Kup samochód.");
        System.out.println("[3] Przeglądaj bazę posiadanych samochodów.");
        System.out.println("[4] Napraw samochód.");
        System.out.println("[5] Przejrzyj potencjalnych klientów.");
        System.out.println("[6] Sprzedaj samochód za określoną cenę potencjalnemu klientowi.");
        System.out.println("[7] Kup reklamę.");
        System.out.println("[8] Sprawdź stan konta.");
        System.out.println("[9] Sprawdź historię transakcji.");
        System.out.println("[10] Sprawdź historię napraw każdego pojazdu.");
        System.out.println("[11] Sprawdź sumę kosztów napraw i mycia dla każdego z posiadanych pojazdów.");
        System.out.println("[12] Zakończ.");
        System.out.println("*------------------------------------*");
        System.out.println("Wybierz liczbę z Menu Gry i zatwierdź przyciskiem (Enter).");

        actionChoice = scanner.nextLine();

        switch (actionChoice) {
            case "0":
                action_0();
                break;
            case "1":
                System.out.println("--------------");
                base.presentationCarsDatabase();
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            case "7":
                break;
            case "8":
                break;
            case "9":
                break;
            case "10":
                break;
            case "11":
                break;
            case "12":
                System.out.println("--------------");
                System.out.println("Zakończenie zabawy.");
                System.exit(0);
                break;
        }
        System.out.println("Naciśnij enter.");
        scanner.nextLine();
    }
    void action_0(){
        System.out.println("--------------");
        System.out.println("Instrukcja gry:");
        System.out.println("Używając klawiatury numerycznej wprowadź liczbę zgodnie z legendą [0 - 12].");
        System.out.println("Wybór liczby zatwierdź przyciskiem (Enter).");
        System.out.println("--------------");
        System.out.println("Cel gry:");
        System.out.println("Podwoić stan konta w jak najmniejszej liczbie ruchów. Jeden ruch to zakup " +
                "auta/sprzedaż auta/naprawienie jednego elementu/dodanie jednej reklamy. " +
                "Przeglądanie stanu konta, historii transakcji, baz klientów, posiadanych pojazdów i pojazdów " +
                "dostępnych do kupienia nie oznacza wykorzystania ruchu.");
        System.out.println("--------------");
    }
}
