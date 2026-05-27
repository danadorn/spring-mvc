package co.istad.spring_mvc.controller;

import co.istad.spring_mvc.domain.Coffee;
import co.istad.spring_mvc.service.CoffeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/coffees")
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }


    @GetMapping
    public List<Coffee> getCoffee() {
        return coffeeService.getCoffee();
    }
}
