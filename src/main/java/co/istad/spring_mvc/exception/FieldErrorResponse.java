package co.istad.spring_mvc.exception;


import lombok.Builder;

@Builder
public record FieldErrorResponse(
        String field,
        String message
) {
}
