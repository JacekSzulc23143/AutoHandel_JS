package project.autohandel;

public class Transaction {

    Human buyer;
    Automobile car;
    Double cash;

    public Transaction(Human buyer, Automobile car, Double cash) {
        this.buyer = buyer;
        this.car = car;
        this.cash = cash;
    }
}
