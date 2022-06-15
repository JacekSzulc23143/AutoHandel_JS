package project.autohandel;

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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String basicCarInfo(){
        return producer + " " + model;
    }

    public void washCar(){
        System.out.println("Umyłeś samochód, zapłaciłeś: 40 zł.");
        washCosts += 40.0;
        owner.subtractCash(40.0);
    }
}
