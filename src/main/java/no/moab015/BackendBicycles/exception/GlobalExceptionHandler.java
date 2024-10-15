package no.moab015.BackendBicycles.exception;

import no.moab015.BackendBicycles.module.ResponseMassage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BicycleNotFound.class)
    public ResponseEntity<?> handleBicycleNotFound(BicycleNotFound ex){
        return new ResponseEntity<>(new ResponseMassage(ex.getMessage()), ex.httpStatus);
    }
}
