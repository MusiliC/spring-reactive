package com.flux.reactive.exceptions;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(ActorNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,Object> handleActorNotFoundException(ActorNotFoundException exception){
        Map<String,Object> map = new HashMap<>();
        map.put("message", exception.getMessage());
        map.put("success", false);
        return map;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handleException(Exception exception){
        Map<String,Object> map = new HashMap<>();
        map.put("message", exception.getMessage());
        map.put("success", false);
        return map;
    }
}
