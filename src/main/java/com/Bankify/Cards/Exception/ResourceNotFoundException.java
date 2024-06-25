package com.Bankify.Cards.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resource,String fieldName, String fieldValue ) {
        super(String.format("%s not found with given %s : %s",resource,fieldName,fieldValue));
    }
}
