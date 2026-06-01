package co.istad.spring_mvc.repository;

import co.istad.spring_mvc.domain.Coffee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CoffeeRepository {

    @Bean
    public List<Coffee> beanCoffee() {
        List<Coffee> coffees = new ArrayList<>();

        Coffee coffee1 = new Coffee(1, "Americano", "50%",1.7);
        Coffee coffee2 = new Coffee(2, "Ice Latte", "No ice",1.5);
        Coffee coffee3 = new Coffee(3, "Milk Tea", "No ice",1.4);

        coffees.add(coffee1);
        coffees.add(coffee2);
        coffees.add(coffee3);

        return coffees;
    }
}
