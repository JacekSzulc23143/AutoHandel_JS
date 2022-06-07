package projectAutohandel;

public class Automobile {

    Double value;
    String producer;
    String model;
    int mileage;
    String color;
    String segment;
    int yearOfProduction;
//    breaks, suspension, engine, body, transmission;

    public Automobile(Double value, String producer, String model, int mileage, String color, String segment, int yearOfProduction) {
        this.value = value;
        this.producer = producer;
        this.model = model;
        this.mileage = mileage;
        this.color = color;
        this.segment = segment;
        this.yearOfProduction = yearOfProduction;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "value=" + value +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                ", segment='" + segment + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}
