package com.tilineando.jugador_roll_player.domain.entities;

import com.tilineando.jugador_roll_player.domain.PosicionDeColor;
import com.tilineando.jugador_roll_player.domain.Transfondo;
import com.tilineando.jugador_roll_player.domain.bonus_transfondo.BonusTransfondo;
import com.tilineando.jugador_roll_player.domain.bonus_transfondo.BonusTransfondoExacto;
import com.tilineando.jugador_roll_player.domain.bonus_transfondo.BonusTransfondoPorRango;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

class TransfondoTest {
    Transfondo transfondo;


    @BeforeEach
    void setUp() {
        List<BonusTransfondo> bonusTransfondoList = new ArrayList<>();

        bonusTransfondoList.add(new BonusTransfondoPorRango(1, 2, 3));
        bonusTransfondoList.add(new BonusTransfondoPorRango(3, 4, 5));
        bonusTransfondoList.add(new BonusTransfondoExacto(6, 6));


        transfondo = new Transfondo(null, bonusTransfondoList, null, null);
    }

    @Test
    void testTransfondo_SiLaListaPosicionesEstaVacia_DebeDevolver0() {
        List<PosicionDeColor> posiciones = new ArrayList<>();
        transfondo.setPosiciones(posiciones);

        Assertions.assertEquals(0, transfondo.cantidadOcurrencias());
    }


    @Test
    void testTransfondo_cuandoHay6PosicionDeColorCoincidente_deberiaDevolver6() {

        List<PosicionDeColor> posiciones = new ArrayList<>();
        int cantOcurrenciasEsperadas = 6;


        for (int i = 0; i < cantOcurrenciasEsperadas; i++) {
            PosicionDeColor mockPosicion = Mockito.mock(PosicionDeColor.class);
            posiciones.add(mockPosicion);
            transfondo.setPosiciones(posiciones);
            when(mockPosicion.coincideColor()).thenReturn(true);
        }


        Assertions.assertEquals(cantOcurrenciasEsperadas, transfondo.cantidadOcurrencias());
    }

    @Test
    void testTransfondo_cuandoHay6PosicionDeColorQueNoCoinciden_deberiaDevolver0() {
        List<PosicionDeColor> posiciones = new ArrayList<>();
        int cantPosiciones = 6;
        int cantEsperada = 0;


        for (int i = 0; i < cantPosiciones; i++) {
            PosicionDeColor mockPosicion = Mockito.mock(PosicionDeColor.class);
            posiciones.add(mockPosicion);
            transfondo.setPosiciones(posiciones);
            when(mockPosicion.coincideColor()).thenReturn(false);
        }


        Assertions.assertEquals(cantEsperada, transfondo.cantidadOcurrencias());
    }

    @Test
    void testTransfondo_cuandoHayUnaOcurrencia_deberiaDevolverBonus0() {

        List<PosicionDeColor> posiciones = new ArrayList<>();
        int cantOcurrenciasEsperadas = 6;
        int bonusEsperado = 0;


        for (int i = 0; i < cantOcurrenciasEsperadas; i++) {
            PosicionDeColor mockPosicion = Mockito.mock(PosicionDeColor.class);
            posiciones.add(mockPosicion);
            transfondo.setPosiciones(posiciones);

            if (i == 0) {
                when(mockPosicion.coincideColor()).thenReturn(true);
            } else {
                when(mockPosicion.coincideColor()).thenReturn(false);
            }
        }


        Assertions.assertEquals(bonusEsperado, transfondo.obteneBonus());
    }

    @Test
    void testTransfondo_cuandoHayUnaOcurrenciaEntre2Y3_deberiaDevolverBonus1() {

        List<PosicionDeColor> posiciones = new ArrayList<>();
        int cantOcurrenciasEsperadas = 6;
        int bonusEsperado = 1;


        for (int i = 0; i < cantOcurrenciasEsperadas; i++) {
            PosicionDeColor mockPosicion = Mockito.mock(PosicionDeColor.class);
            posiciones.add(mockPosicion);
            transfondo.setPosiciones(posiciones);

            if (i < 2) {
                when(mockPosicion.coincideColor()).thenReturn(true);
            } else {
                when(mockPosicion.coincideColor()).thenReturn(false);
            }
        }


        Assertions.assertEquals(bonusEsperado, transfondo.obteneBonus());
    }

    @Test
    void testTransfondo_cuandoHayUnaOcurrenciaEntre4Y5_deberiaDevolverBonus3() {

        List<PosicionDeColor> posiciones = new ArrayList<>();
        int cantOcurrenciasEsperadas = 6;
        int bonusEsperado = 3;


        for (int i = 0; i < cantOcurrenciasEsperadas; i++) {
            PosicionDeColor mockPosicion = Mockito.mock(PosicionDeColor.class);
            posiciones.add(mockPosicion);
            transfondo.setPosiciones(posiciones);

            if (i < 5) {
                when(mockPosicion.coincideColor()).thenReturn(true);
            } else {
                when(mockPosicion.coincideColor()).thenReturn(false);
            }
        }


        Assertions.assertEquals(bonusEsperado, transfondo.obteneBonus());
    }

    @Test
    void testTransfondo_cuandoHayUnaOcurrenciaDeExactamente6_deberiaDevolverBonus6() {

        List<PosicionDeColor> posiciones = new ArrayList<>();
        int cantOcurrenciasEsperadas = 6;
        int bonusEsperado = 6;


        for (int i = 0; i < cantOcurrenciasEsperadas; i++) {
            PosicionDeColor mockPosicion = Mockito.mock(PosicionDeColor.class);
            posiciones.add(mockPosicion);
            transfondo.setPosiciones(posiciones);
            when(mockPosicion.coincideColor()).thenReturn(true);
        }


        Assertions.assertEquals(bonusEsperado, transfondo.obteneBonus());
    }


}
