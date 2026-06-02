package co.istad.spring_mvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record UpdateCoffeeRequest(
        @NotBlank(message = "Name is required!")
        @Size(min=2, max=255)
        String name,
        @Size(min= 5, max = 99999)
        String description,
        @NotNull(message = "Price is required!")
        @Positive(message = "Price must be positive!")
        Double price
) {
}
