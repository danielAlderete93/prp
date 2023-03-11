package com.tilineando.jugador_roll_player.domain.entities;

import com.tilineando.jugador_roll_player.domain.Atributo;
import com.tilineando.jugador_roll_player.domain.Dado;
import com.tilineando.jugador_roll_player.domain.exceptions.DomainAtributoException;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AtributoTest {

    Atributo atributo = new Atributo();
    Integer limiteDados = 3;
    Integer valorDados = 3;

    @BeforeEach
    void setUp() {
        atributo.setLimiteDados(limiteDados);
        for (int i = 0; i < limiteDados; i++) {
            Dado dado = new Dado();
            dado.setMaximoValor(6);
            dado.setMinimoValor(1);
            dado.setValor(valorDados);
            atributo.agregateDado(dado);
        }
    }


    @Test
    public void SeLogroAgregaDadosCorrectamente() {

        Assertions.assertEquals(limiteDados, this.atributo.getDados().size());

    }

    @Test
    public void debeDarErrorAlAgregarMasDadosDeLosEsperados() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(limiteDados, this.atributo.getDados().size()),
                () -> {
                    Assertions.assertThrows(DomainAtributoException.class, () -> {
                        this.atributo.agregateDado(new Dado());
                    });
                }
        );

    }

    @Test
    public void SeSumaCorrectamenteLosValoresDeDados() {
        Assertions.assertTrue(atributo.sumatoriaValorDados() > 0);
        Assertions.assertEquals(valorDados * limiteDados, atributo.sumatoriaValorDados());
    }
}
