package com.tilineando.jugador_roll_player.domain.exceptions;

public class DomainAccionException extends RuntimeException{
    public DomainAccionException() {
    }

    public DomainAccionException(String message) {
        super(message);
    }
}
