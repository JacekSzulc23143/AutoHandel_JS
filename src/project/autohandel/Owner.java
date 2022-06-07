package project.autohandel;

import java.util.ArrayList;
import java.util.List;

public class Owner extends Human {

    List<Automobile> cars = new ArrayList<>();

    public Owner(String name, Double cash) {
        super(name, cash);
    }

}
