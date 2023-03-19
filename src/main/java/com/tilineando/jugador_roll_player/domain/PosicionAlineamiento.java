package com.tilineando.jugador_roll_player.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PosicionAlineamiento {
    private int posicionX;
    private int posicionY;

    public void moverDerecha() {
        posicionX++;
    }

    public void moverIzquierda() {
        posicionX--;
    }

    public void moverAbajo() {
        posicionY++;
    }

    public void moverArriba() {
        posicionY--;
    }

    public boolean tienenMismaPosicion(PosicionAlineamiento posicionAlineamiento) {
        return posicionAlineamiento.getPosicionX() == posicionX && posicionAlineamiento.getPosicionY() == posicionY;
    }

}
