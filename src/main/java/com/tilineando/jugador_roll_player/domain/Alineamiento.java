package com.tilineando.jugador_roll_player.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class Alineamiento {
    private PosicionAlineamiento posicionActual;
    private String nombre;
    private List<BonusAlineamiento> bonusPosicion;

    public Alineamiento(PosicionAlineamiento posicionActual, String nombre, List<BonusAlineamiento> bonusPosicion) {
        this.posicionActual = posicionActual;
        this.nombre = nombre;
        this.bonusPosicion = bonusPosicion;
    }

    public Alineamiento moveteDerecha() {
        posicionActual.moverDerecha();
        return this;
    }

    public Alineamiento moveteIzquierda() {
        posicionActual.moverIzquierda();
        return this;
    }

    public Alineamiento moveteAbajo() {
        posicionActual.moverAbajo();
        return this;
    }

    public Alineamiento moveteArriba() {
        posicionActual.moverArriba();
        return this;
    }

    public Integer tieneBonus() {
        if (null == bonusPosicion || bonusPosicion.isEmpty()) {
            return 0;
        }
        return this.bonusPosicion.stream()
                .filter(bonusAlineamiento -> bonusAlineamiento.getPosicionAlineamiento().tienenMismaPosicion(posicionActual))
                .map(BonusAlineamiento::getBonus)
                .findFirst()
                .orElse(0);
    }


}
