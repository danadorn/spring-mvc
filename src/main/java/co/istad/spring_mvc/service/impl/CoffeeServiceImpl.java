package co.istad.spring_mvc.service.impl;

import co.istad.spring_mvc.domain.Coffee;
import co.istad.spring_mvc.repository.CoffeeRepository;
import co.istad.spring_mvc.service.CoffeeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {
    private final CoffeeRepository coffeeRepository;

    public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

//    @GetMapping
//    public List<Coffee> getCoffees() {
//        List<Coffee> coffees = coffeeRepository.beanCoffee();
//        return coffees.stream()
//                .filter(coffee -> coffee.getId() > 1
//                ).toList();
//    }

    @Override
    public List<Coffee> getCoffee() {
        return coffeeRepository.beanCoffee();
    }
}
