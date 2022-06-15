package project.autohandel;

public class carDatabase {

    Automobile[] cars;
    String[][] producersModels = {
            {"Mercedes", "Sprinter", "Klasa B", "Klasa C", "Klasa S"},
            {"BMW", "X1", "X3", "X4", "X5"},
            {"Audi", "e-tron", "A4", "A6", "Q8"},
            {"Mazda", "2", "3", "6", "CX-3"},
            {"Toyota", "Proace", "Corolla", "Camry", "Hilux"},
            {"VW", "Crafter", "Golf", "Bora", "Corrado"},
            {"Opel", "Corsa", "Astra", "Movano", "Mokka"},
    };
    String[] colors = {"Niebieski", "Czerwony", "Zielony", "Czarny", "Srebrny", "Biały", "Żółty", "Szary"};

    // zakres
    public carDatabase(int extent) {
        cars = new Automobile[extent];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = carGenerator();
        }
    }

    Automobile carGenerator() {
        int randomProducer = (int) (Math.random() * (7)); // generowanie producenta auta
        int randomModel = (int) ((Math.random() * (4)) + 1); // generowanie modelu pojazdu
        String producer = producersModels[randomProducer][0];
        String model = producersModels[randomProducer][randomModel];
        int randomYearOfProduction = (int) (Math.random() * (20) + 2001); // losowany rok z zakresu 2001-2020
        int randomMileage = (int) (Math.random() * (200000)); // losowany przebieg
        int randomColor = (int) (Math.random() * (8)); // losowany kolor
        String segment = "";
        Double value = 0.0;

        // przeliczanie wartości
        if (producer == "Mercedes" || producer == "BMW" || producer == "Audi") {
            segment = "premium";
            value = 250000.0 - (Double.valueOf((2022 - randomYearOfProduction) * 5) * 1000);
        } else if (producer == "Mazda" || producer == "Toyota") {
            segment = "standard";
            value = 140000.0 - (Double.valueOf((2022 - randomYearOfProduction) * 5) * 1000);
        } else if (producer == "VW" || producer == "Opel") {
            segment = "budget";
            value = 65000.0 - (Double.valueOf((2022 - randomYearOfProduction) * 5) * 1000);
        }

        return new Automobile(value, producer, model, randomMileage, colors[randomColor], segment, randomYearOfProduction);
    }

    public void presentationCarsDatabase() {
//        System.out.println("Wykaz dostępnych samochodów do kupienia:");
        int i = 0;
        for (Automobile car : cars) {
            if (car != null) {
                System.out.println("(" + i + ") " + car.toString());
            }
            i++;
        }
        System.out.println("--------------");
    }

    // Umożliwia wybranie samochodu do zakupu po numerze porządkowym.
    public Automobile getCar(int indicator) {
        return cars[indicator];
    }
}