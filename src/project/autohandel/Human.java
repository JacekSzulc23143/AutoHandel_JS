package project.autohandel;

public class Human {

    String name;
    Double cash;
    final Double DEFAULT_CASH = 35000.0;

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, Double cash) {
        this.name = name;
        this.cash = cash;
    }
}
