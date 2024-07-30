package spring.blankpages.api.config.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> tratarValidacaoException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
