package AgroTrackpesagem.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> handleResourceNotFound(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<Void> handleBusinessRule(){
        return ResponseEntity.badRequest().build();
    }
}
