package no.moab015.BackendBicycles.exception;

import org.springframework.http.HttpStatus;

public class BicycleNotFound extends RuntimeException{
    HttpStatus httpStatus;
    public BicycleNotFound(String massage, HttpStatus httpStatus ){
        super(massage);
        this.httpStatus = httpStatus;
    }
}
