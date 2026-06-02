package co.istad.spring_mvc.dto;


import lombok.Getter;
import lombok.Setter;


public record CoffeeResponse (
        Integer id,
        String name,
        String description
){

}
