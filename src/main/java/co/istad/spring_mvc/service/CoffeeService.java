package co.istad.spring_mvc.service;

import co.istad.spring_mvc.domain.Coffee;
import co.istad.spring_mvc.dto.CoffeeResponse;

import java.util.List;

public interface CoffeeService {
    List<Coffee> getCoffee();
    List<CoffeeResponse> getCoffeeResponse();
    CoffeeResponse getCoffeeById(Integer id);
    List<CoffeeResponse> searchByName(String name,Double price);
}
