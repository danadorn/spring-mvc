package co.istad.spring_mvc.service;

import co.istad.spring_mvc.domain.Coffee;
import co.istad.spring_mvc.dto.CreateCoffeeRequest;
import co.istad.spring_mvc.dto.CoffeeResponse;
import co.istad.spring_mvc.dto.UpdateCoffeeRequest;

import java.util.List;

public interface CoffeeService {

    List<Coffee> getCoffee();
    List<CoffeeResponse> getCoffeeResponse();
    CoffeeResponse getCoffeeById(Integer id);
    List<CoffeeResponse> searchByName(String name,Double price);
    CoffeeResponse createCoffee(CreateCoffeeRequest createCoffeeRequest);
    CoffeeResponse updateCoffeeById(Integer id, UpdateCoffeeRequest updateCoffeeRequest);
}
