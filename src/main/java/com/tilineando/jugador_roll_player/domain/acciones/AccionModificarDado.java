package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Personaje;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AccionModificarDado implements AccionAtributoDado {
    protected PosicionDeDado posicionDeDado;

    @Override
    public boolean puedeRealizarse(Personaje personaje) {
        return this.posicionDeDadoCorrespondeAPersonaje(personaje, posicionDeDado);
    }
}
