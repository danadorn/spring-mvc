package co.istad.spring_mvc.service.impl;

import co.istad.spring_mvc.domain.Coffee;
import co.istad.spring_mvc.dto.CoffeeResponse;
import co.istad.spring_mvc.dto.CreateCoffeeRequest;
import co.istad.spring_mvc.repository.CoffeeRepository;
import co.istad.spring_mvc.service.CoffeeService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Service 
public class CoffeeServiceImpl implements CoffeeService {
    private final CoffeeRepository coffeeRepository;
    private final List<Coffee> coffeeBean;

    public CoffeeServiceImpl(CoffeeRepository coffeeRepository, List<Coffee> coffeeBean) {
        this.coffeeRepository = coffeeRepository;
        this.coffeeBean = coffeeBean;
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


//    public CoffeeResponse getCoffeeById(Integer id) {
//        CoffeeResponse res = coffeeRepository.beanCoffee().stream().filter(d->d.getId().equals(id)).
//                map(d->new CoffeeResponse(d.getName(),d.getDescription(),d.getPrice()))
//                .findFirst().orElseThrow(()->new RuntimeException("Id not found!"));
//        return res;
//    }


    //inline variable
    public CoffeeResponse getCoffeeById(Integer id) {
        return coffeeBean
                .stream()
                .filter(d->d.getId().equals(id))
                .map(d->new CoffeeResponse(d.getName(),d.getDescription(),d.getPrice()))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Id not found!"));
    }

    @Override
    public List<CoffeeResponse> searchByName(String name, Double price) {
        List<CoffeeResponse> names = coffeeRepository.beanCoffee().stream()
                .filter(d->d.getName().toLowerCase().contains(name.toLowerCase()) || d.getPrice().equals(price))
                .map(d->new CoffeeResponse(d.getName(),d.getDescription(),d.getPrice()))
                .toList();
        return names;
    }

    @Override
    public CoffeeResponse createCoffee(CreateCoffeeRequest createCoffeeRequest) {

        Coffee coffee = new Coffee();
        coffee.setId(new Random().nextInt(4));
        coffee.setName(createCoffeeRequest.name());
        coffee.setDescription(createCoffeeRequest.description());
        coffee.setPrice(createCoffeeRequest.price());

        coffeeBean.add(coffee);


        return new CoffeeResponse(coffee.getName(), coffee.getDescription(), coffee.getPrice());
    }
}
