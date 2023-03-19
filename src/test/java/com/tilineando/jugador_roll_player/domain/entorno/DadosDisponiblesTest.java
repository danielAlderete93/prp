package com.tilineando.jugador_roll_player.domain.entorno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DadosDisponiblesTest {


    @Test
    public void SeLeeCorrectamenteElArchivoDados() {

        Assertions.assertAll(
                () -> Assertions.assertTrue(DadosDisponibles.obtener().size() > 0),
                () -> Assertions.assertNotNull(DadosDisponibles.obtener().get(0))
        );
    }
}
