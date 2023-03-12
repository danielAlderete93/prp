package com.tilineando.jugador_roll_player.domain.entities;

import com.tilineando.jugador_roll_player.domain.entorno.BolsaDados;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BolsaDadoTest {
    BolsaDados bolsaDados;

    @Test
    public void SePuedeSacarDadoDeBolsaDeDados() {
        bolsaDados = new BolsaDados();
        Assertions.assertAll(
                () -> Assertions.assertNotNull(bolsaDados.sacaDado()),
                () -> {
                    int cantidadInicial = bolsaDados.getDadosDisponibles().size();
                    bolsaDados.sacaDado();
                    Assertions.assertEquals(cantidadInicial - 1, bolsaDados.getDadosDisponibles().size());
                }
        );
    }
}
