package com.tilineando.jugador_roll_player.domain.exceptions;

public class DomainAlineamientoException extends RuntimeException{
    public DomainAlineamientoException() {
    }

    public DomainAlineamientoException(String message) {
        super(message);
    }
}
