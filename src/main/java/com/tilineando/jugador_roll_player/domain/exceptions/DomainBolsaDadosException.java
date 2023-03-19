package com.tilineando.jugador_roll_player.domain.exceptions;

public class DomainBolsaDadosException extends RuntimeException{
    public DomainBolsaDadosException() {
    }

    public DomainBolsaDadosException(String message) {
        super(message);
    }
}
