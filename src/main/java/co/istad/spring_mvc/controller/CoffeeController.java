package co.istad.spring_mvc.controller;

import co.istad.spring_mvc.domain.Coffee;
import co.istad.spring_mvc.dto.CoffeeResponse;
import co.istad.spring_mvc.dto.CreateCoffeeRequest;
import co.istad.spring_mvc.service.CoffeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
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

    @GetMapping("/{id}")
    public CoffeeResponse getCoffeeById(@PathVariable Integer id) {
        log.info("GET id: {}", id);
//        return coffeeService.getCoffeeById(id);
        return coffeeService.getCoffeeById(id);
    }

    @GetMapping("/search")
    public List<CoffeeResponse> searchCoffeeByName(
            @RequestParam (required = false, defaultValue = "") String name,
            @RequestParam (required = false, defaultValue = "") Double price
    ) {
        log.info("Get name: {}", name);
        log.info("Get name: {}", price);

        return coffeeService.searchByName(name,price);
    }

    @PostMapping
    public CoffeeResponse createCoffee(@Valid @RequestBody CreateCoffeeRequest createCoffeeRequest) {

        return coffeeService.createCoffee(createCoffeeRequest);
    }


}
