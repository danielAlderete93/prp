package com.tilineando.jugador_roll_player.domain.entities;

import com.tilineando.jugador_roll_player.domain.Color;
import com.tilineando.jugador_roll_player.domain.Dado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DadoTest {
    Color rojo = new Color();
    Color negro = new Color();

    @Test
    public void SeIntercambiaCorrectamenteColorDelDado() {
        Dado dado = new Dado();
        dado.setColor(rojo);
        assertEquals(rojo, dado.getColor());
        assertEquals(negro, dado.cambiateColor(negro).getColor());

    }


    @Test
    public void sumaYRestaValoresDadosCorrectamente() {
        Integer esperadoEnSuma = 4;
        Integer esperadoEnResta = 3;

        Dado dado = new Dado();
        dado.setMinimoValor(1);
        dado.setMaximoValor(6);
        dado.setValor(3);
        assertEquals(esperadoEnSuma, dado.sumateCant(1).getValor());
        assertEquals(esperadoEnResta, dado.restateCant(1).getValor());
        assertEquals(dado.getMinimoValor(), dado.restateCant(1000).getValor());
        assertEquals(dado.getMaximoValor(), dado.sumateCant(1000).getValor());

    }

    @Test
    public void dadosDel1al6Gira180GradosCorrectamente() {
        Dado dado = new Dado();


        Assertions.assertAll(
                "Dados de 6 caras",
                () -> {
                    //Dados de 6 -> Con valores del 1->6
                    dado.setMinimoValor(1);
                    dado.setMaximoValor(6);
                    Integer valorEsperado = 6;
                    Integer valorInicial = 1;
                    dado.setValor(valorInicial);
                    assertEquals(valorEsperado, dado.girate180().getValor());
                    assertEquals(valorInicial, dado.girate180().getValor());
                },
                () -> {
                    Integer valorEsperado = 5;
                    Integer valorInicial = 2;
                    dado.setValor(valorInicial);
                    assertEquals(valorEsperado, dado.girate180().getValor());
                    assertEquals(valorInicial, dado.girate180().getValor());
                },
                () -> {
                    Integer valorEsperado = 4;
                    Integer valorInicial = 3;
                    dado.setValor(valorInicial);
                    assertEquals(valorEsperado, dado.girate180().getValor());
                    assertEquals(valorInicial, dado.girate180().getValor());
                },
                () -> {
                    //Dados de 6-> con valores del 3 -> 8
                    dado.setMinimoValor(3);
                    dado.setMaximoValor(8);
                    Integer valorEsperado = 8;
                    Integer valorInicial = 3;
                    dado.setValor(valorInicial);
                    assertEquals(valorEsperado, dado.girate180().getValor());
                    assertEquals(valorInicial, dado.girate180().getValor());
                },
                () -> {
                    Integer valorEsperado = 7;
                    Integer valorInicial = 4;
                    dado.setValor(valorInicial);
                    assertEquals(valorEsperado, dado.girate180().getValor());
                    assertEquals(valorInicial, dado.girate180().getValor());
                },
                () -> {
                    Integer valorEsperado = 6;
                    Integer valorInicial = 5;
                    dado.setValor(valorInicial);
                    assertEquals(valorEsperado, dado.girate180().getValor());
                    assertEquals(valorInicial, dado.girate180().getValor());
                }
        );


    }
}
