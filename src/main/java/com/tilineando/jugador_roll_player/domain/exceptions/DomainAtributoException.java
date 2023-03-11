package com.tilineando.jugador_roll_player.domain.exceptions;

public class DomainAtributoException extends RuntimeException{
    public DomainAtributoException() {
    }

    public DomainAtributoException(String message) {
        super(message);
    }
}
