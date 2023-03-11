package com.tilineando.jugador_roll_player.domain.exceptions;

public class DomainDadoException extends RuntimeException {
    public DomainDadoException() {
    }

    public DomainDadoException(String message) {
        super(message);
    }
}
