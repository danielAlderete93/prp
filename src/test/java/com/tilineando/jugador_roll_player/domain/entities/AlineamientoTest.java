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

class AlineamientoTest {
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
    void testAlineamientoPosicionMoverseADerecha_PosicionXActualSeIncrementaEn1() {
        int valorInicial = posicionActual.getPosicionX();
        alineamiento.moveteDerecha();
        Assertions.assertEquals(valorInicial+1, posicionActual.getPosicionX());

    }

    @Test
    void testAlineamientoPosicionMoverseAIzquierda_PosicionXActualSeDecrementaEn1() {
        int valorInicial = posicionActual.getPosicionX();
        alineamiento.moveteIzquierda();
        Assertions.assertEquals(valorInicial-1, posicionActual.getPosicionX());

    }

    @Test
    void testAlineamientoPosicionMoverseAArriba_PosicionYActualSeDecrementaEn1() {
        int valorInicial = posicionActual.getPosicionY();
        alineamiento.moveteArriba();
        Assertions.assertEquals(valorInicial-1, posicionActual.getPosicionY());
    }

    @Test
    void testAlineamientoPosicionMoverseAAbajo_PosicionYActualSeIncrementaEn1() {
        int valorInicial = posicionActual.getPosicionY();
        alineamiento.moveteAbajo();
        Assertions.assertEquals(valorInicial+1, posicionActual.getPosicionY());
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
