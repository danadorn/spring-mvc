package co.istad.spring_mvc.repository;

import co.istad.spring_mvc.domain.Coffee;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository // CoffeeRepository coffeeRepository = new CoffeeRepository()
public class CoffeeRepository {

    private final List<Coffee> coffees;

    public CoffeeRepository() {
        this.coffees = new ArrayList<>();
        Coffee coffee = new Coffee(1, "Ice Latte", "50%", 5000.9);
        Coffee coffee2 = new Coffee(2, "Hot Latte", "50%", 4.4);
        Coffee coffee3 = new Coffee(3, "Ice Americano", "100%", 3.3);

        coffees.add(coffee);
        coffees.add(coffee2);
        coffees.add(coffee3);
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

}
