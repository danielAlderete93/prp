package com.tilineando.jugador_roll_player.domain.entities;

import com.tilineando.jugador_roll_player.domain.Atributo;
import com.tilineando.jugador_roll_player.domain.Dado;
import com.tilineando.jugador_roll_player.domain.Personaje;
import com.tilineando.jugador_roll_player.domain.acciones.Accion;
import com.tilineando.jugador_roll_player.domain.acciones.PosicionDeDado;
import com.tilineando.jugador_roll_player.domain.exceptions.DomainAtributoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AtributoTest {

    Personaje personaje;
    Integer limiteDado;
    Atributo fuerza;
    Atributo destreza;

    PosicionDeDado posicionDeDado;

    @BeforeEach
    public void setUp() {
        //Lista de atributos con 3 dados como limites.
        List<Atributo> atributos = new ArrayList<>();
        limiteDado = 3;

        //crear atributo fuerza y destreza.
        fuerza = new Atributo("fuerza", new ArrayList<>(), limiteDado, null, true);
        destreza = new Atributo("destreza", new ArrayList<>(), limiteDado, null, true);

        //Se crea personaje y se agrega los atributos al personaje
        atributos.add(fuerza);
        atributos.add(destreza);

        personaje = new Personaje(atributos);


    }

    @Test
    void PersonajeTieneAtributos() {
        Assertions.assertNotNull(personaje.getAtributos());
        Assertions.assertTrue(personaje.tieneAtributo(fuerza));
        Assertions.assertTrue(personaje.tieneAtributo(destreza));
    }

    @Test
    void testAtributoPuedeAgregarDado() {

        //Se crea dado
        Dado dado = new Dado();

        //Se agrega al atributo
        fuerza.agregateDado(dado);

        Assertions.assertTrue(fuerza.getDados().size() > 0);
        Assertions.assertTrue(fuerza.getDados().contains(dado));
    }

    @Test
    void testObtenerDadoPorPosicionEnAtributo() {
        Dado dado = new Dado();

        fuerza.agregateDado(dado);
        posicionDeDado = new PosicionDeDado(fuerza, fuerza.getDados().indexOf(dado));

        Assertions.assertEquals(dado, posicionDeDado.obteneDado());
    }

    @Test
    void testAtributoFallaAlAgregarDadoExtra() {

        //Se rellena la lista de dados del atributo.
        for (int i = 0; i < limiteDado; i++) {
            personaje.agregaDadoEnAtributo(new Dado(), fuerza);
        }

        Assertions.assertThrows(DomainAtributoException.class, () -> personaje.agregaDadoEnAtributo(new Dado(), fuerza));
    }

    @Test
    void testAtributoAlAgregarDadoSePuedeUtilizarAccion() {
        //Se setea falso. Para luego, al agregarse el dado, se habilite accion.
        fuerza.setPuedeUtilizarAccion(false);
        fuerza.agregateDado(new Dado());
        Assertions.assertTrue(fuerza.isPuedeUtilizarAccion());
    }

    @Test
    void testAtributoRealizaAccion() {

        //Se crea el mock de accion.
        Accion accionMock = mock(Accion.class);
        when(accionMock.puedeRealizarse(any(Personaje.class))).thenReturn(false);

        //Se setea la accion y luego se simula la accion
        fuerza.setAccion(accionMock);
        fuerza.realizaAccion(personaje);
        Mockito.verify(accionMock, times(1)).realizaAccion(personaje);
    }

    @Test
    void testAtributoDebeFallarSiNoPuedeRealizarAccion() {
        //Se crea el mock de accion.
        Accion accionMock = mock(Accion.class);
        when(accionMock.puedeRealizarse(any(Personaje.class))).thenReturn(false);

        // Se setea a fuerza con la accion y que no pueda realizar accion.
        fuerza.setPuedeUtilizarAccion(false);
        fuerza.setAccion(accionMock);
        Assertions.assertThrows(DomainAtributoException.class, () -> fuerza.realizaAccion(personaje));
        Mockito.verify(accionMock, never()).realizaAccion(personaje);
    }


}
