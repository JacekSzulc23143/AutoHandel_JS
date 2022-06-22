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

    // Case "2". Umożliwia odejmowanie gotówki po zakupie, naprawie i umyciu samochodu.
    public void subtractCash(Double cash) {
        this.cash -= cash;
    }

    // Case "5". Umożliwia pokazanie ilości pieniędzy klienta.
    public Double getCash() {
        return cash;
    }

    // Case "5". Umożliwia pokazanie imienia i nazwiska klienta.
    @Override
    public String toString() {
        return name;
    }
}
