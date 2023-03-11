package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Personaje;

public interface AccionAtributoDado extends Accion {


    default boolean posicionDeDadoCorrespondeAPersonaje(Personaje personaje, PosicionDeDado posicionDeDado) {
        return personaje.tieneAtributo(posicionDeDado.getAtributo())
                && posicionDeDado.tienePosicionValida();
    }
}
