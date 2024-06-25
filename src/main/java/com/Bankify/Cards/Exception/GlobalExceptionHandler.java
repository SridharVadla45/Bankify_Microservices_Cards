package com.Bankify.Cards.Exception;

import com.Bankify.Cards.DTO.ErrorResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();
        objectErrors.forEach(objectError -> {
            String fieldName = ((FieldError) objectError).getField();
            String fieldValue = objectError.getDefaultMessage();
            validationErrors.put(fieldName, fieldValue);
        });

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(validationErrors);
    }


    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDTO(HttpStatus.NOT_FOUND, LocalDate.now(), resourceNotFoundException.getMessage(), webRequest.getDescription(false)));
    }

    @ExceptionHandler(value = CardAlreadyExistException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(CardAlreadyExistException cardAlreadyExistException, WebRequest webRequest) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDTO(HttpStatus.BAD_REQUEST, LocalDate.now(), cardAlreadyExistException.getMessage(), webRequest.getDescription(false)));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(Exception exception, WebRequest webRequest) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, LocalDate.now(), exception.getMessage(), webRequest.getDescription(false)));
    }


}
