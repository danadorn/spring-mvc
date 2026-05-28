package co.istad.spring_mvc.dto;


import lombok.Getter;
import lombok.Setter;


public record CoffeeResponse (
        String name,
        String description,
        Double price
){

}
