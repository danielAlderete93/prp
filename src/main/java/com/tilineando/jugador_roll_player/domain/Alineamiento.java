package com.tilineando.jugador_roll_player.domain;

import com.tilineando.jugador_roll_player.domain.exceptions.DomainAlineamientoException;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class Alineamiento {
    private int[][] posiciones = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    private PosicionAlineamiento posicionActual;
    private String nombre;
    private List<BonusAlineamiento> bonusPosicion;

    public Alineamiento(PosicionAlineamiento posicionActual, String nombre, List<BonusAlineamiento> bonusPosicion) {
        this.posicionActual = posicionActual;
        this.nombre = nombre;
        this.bonusPosicion = bonusPosicion;
    }

    public Alineamiento moveteDerecha() {
        if (posicionActual.getPosicionX() + 1 > 2) {
            throw new DomainAlineamientoException("No puede mover alineamiento a derecha, alcanzo el limite.");
        }
        posicionActual.moverDerecha();
        return this;
    }

    public Alineamiento moveteIzquierda() {
        if (posicionActual.getPosicionX() - 1 < 0) {
            throw new DomainAlineamientoException("No puede mover alineamiento a izquierda, alcanzo el limite.");
        }
        posicionActual.moverIzquierda();
        return this;
    }

    public Alineamiento moveteAbajo() {
        if (posicionActual.getPosicionY() + 1 > 2) {
            throw new DomainAlineamientoException("No puede mover alineamiento hacia abajo, alcanzo el limite.");
        }
        posicionActual.moverAbajo();
        return this;
    }

    public Alineamiento moveteArriba() {
        if (posicionActual.getPosicionY() - 1 < 0) {
            throw new DomainAlineamientoException("No puede mover alineamiento  hacia arriba, alcanzo el limite.");
        }
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
