package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Atributo;
import com.tilineando.jugador_roll_player.domain.Color;
import com.tilineando.jugador_roll_player.domain.Dado;
import com.tilineando.jugador_roll_player.domain.Personaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AccionesAtributoTest {
    Accion accion;
    Atributo atributoInicial;
    Atributo atributoFinal;

    Dado dado1;
    Dado dado2;
    Personaje personaje;

    PosicionDeDado posicionDeDadoInicial;
    PosicionDeDado posicionDeDadoFinal;

    @BeforeEach
    void setUp() {
        List<Atributo> atributos = new ArrayList<>();

        atributoInicial = new Atributo("", new ArrayList<>(), 3, null, true);
        atributoFinal = new Atributo("", new ArrayList<>(), 3, null, true);

        atributos.add(atributoInicial);
        atributos.add(atributoFinal);

        dado1 = new Dado(new Color("Rojo"), 4, 1, 6);
        dado2 = new Dado(new Color("Verde"), 5, 1, 6);

        personaje = new Personaje(atributos);
        atributoInicial.agregateDado(dado1);
        atributoFinal.agregateDado(dado2);

        posicionDeDadoInicial = new PosicionDeDado(atributoInicial, atributoInicial.getDados().indexOf(dado1));
        posicionDeDadoFinal = new PosicionDeDado(atributoFinal, atributoFinal.getDados().indexOf(dado2));
    }


    @Test
    void testAccionAumentarValorDado() {
        Integer valorInicial = posicionDeDadoInicial.obteneDado().getValor();
        accion = new AccionAumentarValorDado(posicionDeDadoInicial, 1);
        accion.realizaAccion(personaje);

        Assertions.assertEquals(valorInicial + 1, posicionDeDadoInicial.obteneDado().getValor());
    }

    @Test
    void testAccionDisminuirValorDado() {
        Integer valorInicial = posicionDeDadoInicial.obteneDado().getValor();
        accion = new AccionDisminuirValorDado(posicionDeDadoInicial, 1);
        accion.realizaAccion(personaje);

        Assertions.assertEquals(valorInicial - 1, posicionDeDadoInicial.obteneDado().getValor());
    }

    @Test
    void testAccionGirar180Grados() {
        accion = new AccionGirarDado180Grados(posicionDeDadoInicial);
        accion.realizaAccion(personaje);

        Assertions.assertEquals(3, posicionDeDadoInicial.obteneDado().getValor());
    }

    @Test
    void testAccionReRollDado() {
        accion = Mockito.mock(AccionReRollDado.class);
        when(accion.puedeRealizarse(any(Personaje.class))).thenReturn(false);
        accion.realizaAccion(personaje);

        verify(accion, times(1)).realizaAccion(personaje);
    }

    @Test
    void testAccionIntercambiarDados() {
        Dado dadoInicial = dado1.clonate();
        Dado dadoFinal = dado2.clonate();
        accion = new AccionIntercambiarDados(posicionDeDadoInicial, posicionDeDadoFinal);
        accion.realizaAccion(personaje);

        Assertions.assertEquals(posicionDeDadoInicial.obteneDado().getValor(), dadoFinal.getValor());
        Assertions.assertEquals(posicionDeDadoInicial.obteneDado().getColor(), dadoFinal.getColor());

        Assertions.assertEquals(posicionDeDadoFinal.obteneDado().getValor(), dadoInicial.getValor());
        Assertions.assertEquals(posicionDeDadoFinal.obteneDado().getColor(), dadoInicial.getColor());

    }

}
