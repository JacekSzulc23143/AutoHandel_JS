package project.autohandel;

import java.util.ArrayList;
import java.util.List;

public class Automobile {

    Double value;
    String producer;
    String model;
    int mileage;
    String color;
    String segment;
    int yearOfProduction;
    Owner owner;
    Double washCosts = 0.0;
    boolean breaks, suspension, engine, body, transmission; // true oznacza uszkodzenie
    List<String> repairHistory = new ArrayList<>();
    Double repairCosts = 0.0;

    public Automobile(Double value, String producer, String model, int mileage, String color, String segment, int yearOfProduction, int damagedPart) {
        this.value = value;
        this.producer = producer;
        this.model = model;
        this.mileage = mileage;
        this.color = color;
        this.segment = segment;
        this.yearOfProduction = yearOfProduction;
        // case"4". Cyfra (1-5) odpowiada za uszkodzenie danej części samochodu.
        switch (damagedPart){
            case 1:
                breaks = true;
                break;
            case 2:
                suspension = true;
                break;
            case 3:
                engine = true;
                break;
            case 4:
                body = true;
                break;
            case 5:
                transmission = true;
                break;
        }
    }

    // Case "1", "2" i "4".
    @Override
    public String toString() {
        return "Samochód {" +
                "Wartość: " + value +
                ", Producent: '" + producer + '\'' +
                ", Model: '" + model + '\'' +
                ", Przebieg: " + mileage +
                ", Kolor: '" + color + '\'' +
                ", Segment: '" + segment + '\'' +
                ", Rok produkcji: " + yearOfProduction +
                ", Hamulce: " + breaks +
                ", Zawieszenie: " + suspension +
                ", Silnik: " + engine +
                ", Karoseria: " + body +
                ", Skrzynia biegów: " + transmission +
                '}';
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    // Case "2". Umożliwia wyświetlenie podstawowych danych samochodu.
    public String basicCarInfo() {
        return producer + " " + model;
    }

    // Case "2". Umożliwia umycie samochodu za opłatą.
    public void washCar() {
        System.out.println("Umyłeś samochód, zapłaciłeś: 40 zł.");
        washCosts += 40.0;
        owner.subtractCash(40.0);
    }

    // Case "4". Umożliwia dodanie zdarzenia naprawy samochodu do listy.
    public void addRepairEvent(String part) {
        repairHistory.add(part);
    }

    // Case "4". Podnosi wartość samochodu po naprawie w procentach.
    public void increaseValue(Double percent) {
        value = ((value * percent) / 100) + value;
    }

    // Case "4". Umożliwia naprawianie części samochodów.
    public void repairPart(String part, String mechanic) {
        switch (part) {
            case "Hamulce":
                breaks = repair(mechanic);
                System.out.println("Naprawiono hamulce.");
                increaseValue(10.0);
                System.out.println("Wartość twojego samochodu została zwiększona o 10%.");
                break;
            case "Zawieszenie":
                suspension = repair(mechanic);
                System.out.println("Naprawiono zawieszenie.");
                increaseValue(20.0);
                System.out.println("Wartość twojego samochodu została zwiększona o 20%.");
                break;
            case "Silnik":
                engine = repair(mechanic);
                System.out.println("Naprawiono silnik.");
                increaseValue(100.0);
                System.out.println("Wartość twojego samochodu została zwiększona o 100%.");
                break;
            case "Karoseria":
                body = repair(mechanic);
                System.out.println("Naprawiono karoserie.");
                increaseValue(50.0);
                System.out.println("Wartość twojego samochodu została zwiększona o 50%.");
                break;
            case "Skrzynia biegów":
                transmission = repair(mechanic);
                System.out.println("Naprawiono skrzynie biegów.");
                increaseValue(50.0);
                System.out.println("Wartość twojego samochodu została zwiększona o 50%.");
                break;
        }
        addRepairEvent(part);
    }

    // Case "4". Umożliwia wybór mechanika samochodowego.
    private boolean repair(String mechanic) {
        boolean isSuccess = false;
        int probability;
        switch (mechanic) {
            case "Janusz":
                System.out.println("Janusz - ma najdroższe ceny ale 100% gwarancję.");
                isSuccess = true;
                owner.subtractCash(3500.0);
                repairCosts += 3500.0;
                break;
            case "Marian":
                System.out.println("Marian - bierze zdecydowanie mniej niż Janusz, ale masz 10% szans, że nie uda mu się naprawić samochodu i konieczna będzie interwencja Janusza.");
                probability = (int) (Math.random() * (10));
                if (probability == 1) {
                    System.out.println("Marian nie stanął na wysokości zadania, zleć naprawę innemu mechanikowi.");
                    System.out.println("Marian pobiera połowę swojej stawki.");
                    owner.subtractCash(1250.0);
                    repairCosts += 1250.0;
                    isSuccess = false;
                } else {
                    System.out.println("Marian naprawił samochód.");
                    owner.subtractCash(2500.0);
                    repairCosts += 2500.0;
                    isSuccess = true;
                }
                break;
            case "Adrian":
                System.out.println("Adrian - jest najtańszy, ale masz 20% szans, że nie uda mu się naprawić i 2% szans, że zepsuje coś innego podczas naprawy.");
                probability = (int) (Math.random() * (5));
                if (probability == 1) {
                    System.out.println("Ardian nie stanął na wysokości zadania, zleć naprawę innemu mechanikowi.");
                    System.out.println("Ardian pobiera połowę swojej stawki.");
                    owner.subtractCash(750.0);
                    repairCosts += 750.0;
                    isSuccess = false;
                } else {
                    System.out.println("Ardian naprawił samochód.");
                    owner.subtractCash(1500.0);
                    repairCosts += 1500.0;
                    isSuccess = true;
                }
                break;
            default:
                System.out.println("Zły wybór! Ponów.");
                break;
        }
        return !isSuccess;
    }
}
