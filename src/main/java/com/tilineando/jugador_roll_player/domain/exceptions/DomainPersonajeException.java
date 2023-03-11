package com.tilineando.jugador_roll_player.domain.exceptions;

public class DomainPersonajeException extends RuntimeException{
    public DomainPersonajeException() {
    }

    public DomainPersonajeException(String message) {
        super(message);
    }
}
