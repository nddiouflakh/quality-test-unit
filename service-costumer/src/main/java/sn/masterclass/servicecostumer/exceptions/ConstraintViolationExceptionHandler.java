package sn.masterclass.servicecostumer.exceptions;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class ConstraintViolationExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map <String, List<String>>>HandleValidationErrors(ConstraintViolationException ex){
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        Map <String, List<String>> listMap = new HashMap<>();
        constraintViolations.forEach(constraintViolation -> {
            List <String> fieldErrors = listMap.get(constraintViolation.getPropertyPath().toString());
            if (fieldErrors == null) {
                listMap.put(constraintViolation.getPropertyPath().toString(), new ArrayList<>());
            }
            listMap.get(constraintViolation.getPropertyPath().toString())
                    .add(constraintViolation.getMessage());
        });

        return ResponseEntity.badRequest().body(listMap);
    }


}
