package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Atributo;
import com.tilineando.jugador_roll_player.domain.Dado;
import com.tilineando.jugador_roll_player.domain.Personaje;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AccionTest {

    Personaje personaje;
    Integer limiteDado;
    Atributo fuerza;
    Atributo destreza;

    @BeforeEach
    public void setUp() {

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(fuerza);
        atributos.add(destreza);

        limiteDado = 3;
        fuerza = new Atributo("fuerza", new ArrayList<>(), limiteDado, null);
        fuerza = new Atributo("destreza", new ArrayList<>(), limiteDado, null);

        personaje = new Personaje(atributos);

    }

    @Test
    public void sePuedeAgregarDadosCorrectamente(){
        Dado dado = new Dado(null,null,null,null);
    }


}
