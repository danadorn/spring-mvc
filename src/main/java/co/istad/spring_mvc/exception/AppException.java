package co.istad.spring_mvc.exception;


import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RestControllerAdvice
public class AppException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
        log.error("Validation Exception");
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Input a positive valid number mate!");

        List<FieldError> fieldErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fe -> new FieldError(
                        fe.getField(),
                        fe.getDefaultMessage() != null ? fe.getDefaultMessage() : "Invalid value",
                        fe.getRejectedValue() == null ? "null" : fe.getRejectedValue().toString()
                ))
                .toList();

        response.put("errors", fieldErrors);
        return ResponseEntity.badRequest().body(response);
    }
}
