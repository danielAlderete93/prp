package com.tilineando.jugador_roll_player.domain.entities;

import com.tilineando.jugador_roll_player.domain.BolsaDados;
import com.tilineando.jugador_roll_player.domain.exceptions.DomainBolsaDadosException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BolsaDadoTest {
    BolsaDados bolsaDados;

    @Test
    void SePuedeSacarDadoDeBolsaDeDados() {
        bolsaDados = new BolsaDados();
        int cantidadInicial = bolsaDados.getDadosDisponibles().size();
        Assertions.assertNotNull(bolsaDados.sacateDado());
        Assertions.assertEquals(cantidadInicial - 1, bolsaDados.getDadosDisponibles().size());
        Assertions.assertTrue(bolsaDados.sacateDado().realizaRoll().getValor() > 0);

    }

    @Test
    void SiSeSacaTodosLosDadosNoPuedeSacarseMasDados() {
        bolsaDados = new BolsaDados();
        int cantidadInicial = bolsaDados.getDadosDisponibles().size();
        for (int i = 0; i < cantidadInicial; i++) {
            bolsaDados.sacateDado();
        }
        Assertions.assertThrows(DomainBolsaDadosException.class, () -> bolsaDados.sacateDado());
    }

    @Test
    void NoSePuedeInicializarBolsaDeDadosSiListaDadosEsNula() {

        Assertions.assertThrows(DomainBolsaDadosException.class, () -> {
            bolsaDados = new BolsaDados(null);
        });
    }

}
