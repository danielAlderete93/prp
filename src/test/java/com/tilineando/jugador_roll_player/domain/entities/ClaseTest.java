package com.tilineando.jugador_roll_player.domain.entities;

import com.tilineando.jugador_roll_player.domain.Clase;
import com.tilineando.jugador_roll_player.domain.Color;
import com.tilineando.jugador_roll_player.domain.atributo_objetivo.AtributoObjetivo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class ClaseTest {

    Clase clase;
    List<AtributoObjetivo> atributoObjetivo;
    Color rojo;

    @BeforeEach
    void setUp() {
        atributoObjetivo = new ArrayList<>();
        rojo = new Color("rojo");
        clase = new Clase(null, atributoObjetivo, rojo, null);
    }

    @Test
    void testClaseTieneBonusDosSiDosDadosCoincidenEnColor() {
        Integer valorEsperado = 3;
        AtributoObjetivo mockAtributo = mock(AtributoObjetivo.class);
        atributoObjetivo.add(mockAtributo);

        when(mockAtributo.bonusPorDadosDeColor(any(Color.class))).thenReturn(valorEsperado);

        Assertions.assertEquals(valorEsperado, clase.bonusPorDados());
        verify(mockAtributo, times(1)).bonusPorDadosDeColor(any(Color.class));


    }

    @Test
    void testClaseTieneBonusDosSiCumpleObjetivo() {
        Integer valorEsperado = 5;
        AtributoObjetivo mockAtributo = mock(AtributoObjetivo.class);
        atributoObjetivo.add(mockAtributo);

        when(mockAtributo.bonusPorObjetivo())
                .thenReturn(valorEsperado);

        Assertions.assertEquals(valorEsperado, clase.bonusPorObjetivo());
        verify(mockAtributo, times(1)).bonusPorObjetivo();


    }

}
