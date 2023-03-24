package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Alineamiento;
import com.tilineando.jugador_roll_player.domain.Personaje;
import com.tilineando.jugador_roll_player.domain.PosicionAlineamiento;
import com.tilineando.jugador_roll_player.domain.exceptions.DomainAccionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccionMoveAlineamientoTest {
    Alineamiento alineamiento;
    Personaje personaje;
    PosicionAlineamiento posicionInicial;

    int posXInicial = 1;
    int posYInicial = 1;

    AccionMoveAlineamiento moveAlineamiento;

    @BeforeEach
    void setUp() {

        posicionInicial = new PosicionAlineamiento(posXInicial, posYInicial);

        alineamiento = new Alineamiento(posicionInicial, null, null);

        personaje = new Personaje(null, null, alineamiento, null);

    }

    private void moveAlineamientoMuchasVeces() {
        moveAlineamiento.realizaAccion(personaje);
        moveAlineamiento.realizaAccion(personaje);
        moveAlineamiento.realizaAccion(personaje);
        moveAlineamiento.realizaAccion(personaje);
    }

    @Test
    void AccionMoveAlineamientoDerecha_SeMueve1VezExitosamente() {
        moveAlineamiento = new AccionMoveAlineamientoDerecha();
        moveAlineamiento.realizaAccion(personaje);

        Assertions.assertEquals(posXInicial + 1, posicionInicial.getPosicionX());

    }

    @Test
    void AccionMoveAlineamientoDerecha_SiSeDesbordaDelTablero_DebeFallar() {
        moveAlineamiento = new AccionMoveAlineamientoDerecha();

        Assertions.assertThrows(DomainAccionException.class, this::moveAlineamientoMuchasVeces);

    }

    @Test
    void AccionMoveAlineamientoIzquierda_SeMueve1VezExitosamente() {
        moveAlineamiento = new AccionMoveAlineamientoIzquierda();
        moveAlineamiento.realizaAccion(personaje);

        Assertions.assertEquals(posXInicial - 1, posicionInicial.getPosicionX());

    }

    @Test
    void AccionMoveAlineamientoIzquierda_SiSeDesbordaDelTablero_DebeFallar() {
        moveAlineamiento = new AccionMoveAlineamientoIzquierda();

        Assertions.assertThrows(DomainAccionException.class, this::moveAlineamientoMuchasVeces);

    }


    @Test
    void AccionMoveAlineamientoAbajo_SeMueve1VezExitosamente() {
        moveAlineamiento = new AccionMoveAlineamientoAbajo();
        moveAlineamiento.realizaAccion(personaje);

        Assertions.assertEquals(posYInicial + 1, posicionInicial.getPosicionY());

    }

    @Test
    void AccionMoveAlineamientoAbajo_SiSeDesbordaDelTablero_DebeFallar() {
        moveAlineamiento = new AccionMoveAlineamientoAbajo();

        Assertions.assertThrows(DomainAccionException.class, this::moveAlineamientoMuchasVeces);

    }

    @Test
    void AccionMoveAlineamientoArriba_SeMueve1VezExitosamente() {
        moveAlineamiento = new AccionMoveAlineamientoArriba();
        moveAlineamiento.accion(personaje);

        Assertions.assertEquals(posYInicial - 1, posicionInicial.getPosicionY());

    }

    @Test
    void AccionMoveAlineamientoArriba_SiSeDesbordaDelTablero_DebeFallar() {
        moveAlineamiento = new AccionMoveAlineamientoArriba();

        Assertions.assertThrows(DomainAccionException.class, this::moveAlineamientoMuchasVeces);

    }
}
