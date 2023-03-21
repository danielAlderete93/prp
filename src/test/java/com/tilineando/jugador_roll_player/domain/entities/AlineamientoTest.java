package com.tilineando.jugador_roll_player.domain.entities;

import com.tilineando.jugador_roll_player.domain.Alineamiento;
import com.tilineando.jugador_roll_player.domain.BonusAlineamiento;
import com.tilineando.jugador_roll_player.domain.PosicionAlineamiento;
import com.tilineando.jugador_roll_player.domain.exceptions.DomainAlineamientoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AlineamientoTest {
    Alineamiento alineamiento;
    BonusAlineamiento bonus;
    PosicionAlineamiento posicionActual;

    @BeforeEach
    void setUp() {
        List<BonusAlineamiento> bonusAlineamientoList = new ArrayList<>();
        posicionActual = new PosicionAlineamiento(1, 1);
        bonus = new BonusAlineamiento(new PosicionAlineamiento(2, 2), 3);
        bonusAlineamientoList.add(bonus);
        alineamiento = new Alineamiento(posicionActual, "", bonusAlineamientoList);
    }

    @Test
    void testAlineamientoPosicionActualPuedeRecorrerPorLasCuatroDirecciones() {
        alineamiento.moveteDerecha()
                .moveteIzquierda()
                .moveteArriba()
                .moveteAbajo();
        Assertions.assertEquals(1, posicionActual.getPosicionX());
        Assertions.assertEquals(1, posicionActual.getPosicionY());
    }

    @Test
    void testAlineamientoPosicionRecorreDiagonalPrincipal() {
        alineamiento.moveteDerecha()
                .moveteAbajo();
        Assertions.assertEquals(2, posicionActual.getPosicionX());
        Assertions.assertEquals(2, posicionActual.getPosicionY());
        alineamiento.moveteIzquierda()
                .moveteArriba();
        Assertions.assertEquals(1, posicionActual.getPosicionX());
        Assertions.assertEquals(1, posicionActual.getPosicionY());
        alineamiento.moveteIzquierda()
                .moveteArriba();
        Assertions.assertEquals(0, posicionActual.getPosicionX());
        Assertions.assertEquals(0, posicionActual.getPosicionY());
    }

    @Test
    void testAlineamientoMoverseMasPosicionesXQueLaPermitidaFalla() {
        posicionActual.setPosicionX(1);

        Assertions.assertThrowsExactly(DomainAlineamientoException.class,
                () -> alineamiento.moveteDerecha().moveteDerecha());

        Assertions.assertThrowsExactly(DomainAlineamientoException.class,
                () -> alineamiento.moveteIzquierda().moveteIzquierda().moveteIzquierda());


    }

    @Test
    void testAlineamientoSeLeeCorrectamenteElBonusDePosicion() {
        posicionActual.setPosicionX(1);

        Assertions.assertThrowsExactly(DomainAlineamientoException.class,
                () -> alineamiento.moveteDerecha().moveteDerecha());

        Assertions.assertThrowsExactly(DomainAlineamientoException.class,
                () -> alineamiento.moveteIzquierda().moveteIzquierda().moveteIzquierda());


    }

    @Test
    void testAlineamientoLaPosicionActualTieneBonus() {
        posicionActual.setPosicionY(1);
        posicionActual.setPosicionX(1);

        alineamiento.moveteDerecha().moveteAbajo();

        Assertions.assertEquals(bonus.getBonus(),alineamiento.tieneBonus());

    }
    @Test
    void testAlineamientoLaPosicionActualNoTieneBonus() {
        posicionActual.setPosicionY(1);
        posicionActual.setPosicionX(1);


        Assertions.assertEquals(0,alineamiento.tieneBonus());

    }


}
