package com.example.primerApi.exceptions;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long id) {
        super("could not find movie with id: "+id);
    }
}
