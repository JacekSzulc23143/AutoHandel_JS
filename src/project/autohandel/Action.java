package project.autohandel;

import java.util.Scanner;

public class Action {

    Scanner scanner = new Scanner(System.in);
    String actionChoice;
    String actionChoice2;
    String actionChoice3;
    int numberOfBuyers;

    Owner trader = new Owner("Zenek Szulc", 400000.0);
    carDatabase carDatabase = new carDatabase(5);
    ClientDatabase clientDatabase = new ClientDatabase(5);


    public void showAction() {
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
                action_1();
                break;
            case "2":
                action_2();
                break;
            case "3":
                action_3();
                break;
            case "4":
                action_4();
                break;
            case "5":
                action_5();
                break;
            case "6":
                action_6();
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

    void action_0() {
        System.out.println("--------------");
        System.out.println("Instrukcja gry:");
        System.out.println("Używając klawiatury numerycznej wprowadź liczbę zgodnie z legendą [0 - 12].");
        System.out.println("Wybór liczby zatwierdź przyciskiem \"Enter\".");
        System.out.println("--------------");
        System.out.println("Cel gry:");
        System.out.println("Podwoić stan konta w jak najmniejszej liczbie ruchów. Jeden ruch to zakup " +
                "auta/sprzedaż auta/naprawienie jednego elementu/dodanie jednej reklamy. " +
                "Przeglądanie stanu konta, historii transakcji, baz klientów, posiadanych pojazdów i pojazdów " +
                "dostępnych do kupienia nie oznacza wykorzystania ruchu.");
        System.out.println("--------------");
    }

    void action_1() {
        System.out.println("--------------");
        System.out.println("Baza samochodów do kupienia:");
        carDatabase.presentationCarsDatabase();
        System.out.println("--------------");
    }

    void action_2() {
        System.out.println("--------------");
        System.out.println("Wykaz dostępnych samochodów do kupienia:");
        carDatabase.presentationCarsDatabase();
        System.out.println("--------------");
        System.out.println("Wprowadź numer porządkowy samochodu w celu zakupu:");
        actionChoice = scanner.nextLine();
        System.out.println("--------------");
        trader.buyCar(carDatabase.getCar(Integer.parseInt(actionChoice)));
        carDatabase = new carDatabase(5);
        System.out.println("--------------");
    }

    void action_3() {
        System.out.println("--------------");
        trader.showCars();
        System.out.println("--------------");
    }

    void action_4() {
        trader.showCars();
        System.out.println("Podaj numer porządkowy samochodu który chcesz naprawić:");
        actionChoice = scanner.nextLine();
        System.out.println("Wpisz część którą chcesz naprawić (true oznacza uszkodzenie) [Hamulce, Zawieszenie, " +
                "Silnik, Karoseria, Skrzynia biegów]:");
        actionChoice2 = scanner.nextLine();
        System.out.println("Mechanicy do wyboru:");
        System.out.println("Janusz - ma najdroższe ceny ale 100% gwarancję.");
        System.out.println("Marian - bierze zdecydowanie mniej niż Janusz, ale masz 10% szans, że nie uda mu się naprawić samochodu i konieczna będzie interwencja Janusza.");
        System.out.println("Adrian - jest najtańszy, ale masz 20% szans, że nie uda mu się naprawić i 2% szans, że zepsuje coś innego podczas naprawy.");
        System.out.println("Wpisz imię mechanika którego wybierasz [Janusz, Marian, Adrian]:");
        actionChoice3 = scanner.nextLine();
        trader.getCar(Integer.parseInt(actionChoice)).repairPart(actionChoice2, actionChoice3);
    }

    void action_5() {
        System.out.println("--------------");
        System.out.println("Baza potencjalnych klientów:");
        clientDatabase.presentationClientsDatabase();
        System.out.println("--------------");
    }

    void action_6() {
        trader.showCars();
        System.out.println("Podaj numer porządkowy samochodu który chcesz sprzedać:");
        actionChoice = scanner.nextLine();
        System.out.println("Lista klientów zainteresowanych kupnem samochodu:");
        clientDatabase.presentationClientsDatabase();
        System.out.println("Podaj numer porządkowy kupującego:");
        actionChoice2 = scanner.nextLine();
        System.out.println("Wpisz kwotę sprzedaży samochodu:");
        actionChoice3 = scanner.nextLine();
        trader.sellCar(trader.getCar(Integer.parseInt(actionChoice)), clientDatabase.getClient(Integer.parseInt(actionChoice2)), Double.parseDouble(actionChoice3));
    }
}
