package project.autohandel;

import java.util.ArrayList;
import java.util.List;

public class Owner extends Human {

    List<Automobile> cars = new ArrayList<>();
    List<Transaction> transactions = new ArrayList<>();

    public Owner(String name, Double cash) {
        super(name, cash);
    }

    void addCar(Automobile car){
        System.out.println("--------------");
        cars.add(car);
        System.out.println("Dostarczyłeś do komisu samochód marki: " + car.basicCarInfo() + ".");
    }

    public void buyCar(Automobile car){
        if(cash >= car.value) {
            subtractCash(car.value);
            addCar(car);
            System.out.println("Gratulacje, zakupiłeś samochód.");
            car.setOwner(this);
            transactions.add(new Transaction(this, car, car.value));
            car.washCar();
        }else{
            System.out.println("Brak pieniędzy, nie możesz kupić tego samochodu.");
        }
    }

}
