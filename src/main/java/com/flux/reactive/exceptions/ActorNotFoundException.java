package com.flux.reactive.exceptions;

public class ActorNotFoundException extends RuntimeException {
    public ActorNotFoundException(String msg) {
        super(msg);
    }
}
