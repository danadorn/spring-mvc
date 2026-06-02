package co.istad.spring_mvc.exception;


import lombok.Builder;

@Builder
public record ErrorResponse<T>(
        Boolean status,
        Integer code,
        String message,
        T errors
) {
}
