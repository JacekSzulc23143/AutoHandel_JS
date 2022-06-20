package project.autohandel;

import java.util.ArrayList;
import java.util.List;

public class Owner extends Human {

    List<Automobile> cars = new ArrayList<>();
    List<Transaction> transactions = new ArrayList<>();

    public Owner(String name, Double cash) {
        super(name, cash);
    }

    // Case "2". Po zakupie dodaje samochód do własnej bazy samochodów.
    void addCar(Automobile car) {
        cars.add(car);
        System.out.println("Dostarczyłeś do komisu samochód marki: " + car.basicCarInfo() + ".");
    }

    // Case "2". Umożliwia zakup samochodu.
    public void buyCar(Automobile car) {
        if (cash >= car.value) {
            subtractCash(car.value);
            addCar(car);
            System.out.println("Gratulacje, zakupiłeś samochód.");
            car.setOwner(this);
            transactions.add(new Transaction(this, car, car.value));
            car.washCar();
        } else {
            System.out.println("Brak pieniędzy, nie możesz kupić tego samochodu.");
        }
    }

    // Case "3" i "4". Umożliwia wyświetlenie wykazu posiadanych samochodów.
    public void showCars() {
        System.out.println("Wykaz Twoich samochodów:");
        int i = 0;
        for (Automobile car : cars) {
            if (car != null) {
                System.out.println("(" + i + ") " + car.toString());
            }
            i++;
        }
//        System.out.println();
    }

    // Case "4". Umożliwia wybranie samochodu do naprawy po numerze porządkowym.
    public Automobile getCar(int carIndicator) {
        return cars.get(carIndicator);
    }
}
