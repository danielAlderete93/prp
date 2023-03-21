package com.tilineando.jugador_roll_player.domain.entorno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DadosDisponiblesTest {


    @Test
    void SeLeeCorrectamenteElArchivoDados() {

        Assertions.assertAll(
                () -> Assertions.assertTrue(DadosDisponibles.obtener().size() > 0),
                () -> Assertions.assertNotNull(DadosDisponibles.obtener().get(0))
        );
    }
}
