package Springboot.Institute.ManageMent.System.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

// Global exception handler to handle exceptions across all controllers
@ControllerAdvice
public class GlobalExceptionHandler {

    // Exception handler for InstituteNotFoundException
    @ExceptionHandler(InstituteNotFoundException.class)
    public ResponseEntity<String> handleInstituteNotFoundException(InstituteNotFoundException ex, WebRequest request) {
        // Return HTTP 404 status code and the exception message as the response body
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // Exception handler for other types of exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex, WebRequest request) {
        // Return HTTP 500 status code and a generic error message for internal server errors
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
    }
}
