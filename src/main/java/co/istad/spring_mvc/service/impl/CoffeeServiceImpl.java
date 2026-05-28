package co.istad.spring_mvc.service.impl;

import co.istad.spring_mvc.domain.Coffee;
import co.istad.spring_mvc.dto.CoffeeResponse;
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

    @Override
    public List<CoffeeResponse> getCoffeeResponse() {
        return List.of();
    }

    public CoffeeResponse getCoffeeById(Integer id) {
       CoffeeResponse res = coffeeRepository.beanCoffee().stream().filter(d->d.getId().equals(id)).
               map(d->new CoffeeResponse(d.getName(),d.getDescription(),d.getPrice()))
               .findFirst().orElseThrow(()->new RuntimeException("Id not found!"));
       return res;
    }

    @Override
    public List<CoffeeResponse> searchByName(String name, Double price) {
        List<CoffeeResponse> names = coffeeRepository.beanCoffee().stream()
                .filter(d->d.getName().toLowerCase().contains(name.toLowerCase()) && d.getPrice().equals(price))
                .map(d->new CoffeeResponse(d.getName(),d.getDescription(),d.getPrice()))
                .toList();
        return names;
    }



}
