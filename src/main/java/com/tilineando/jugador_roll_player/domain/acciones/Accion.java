package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Personaje;
import com.tilineando.jugador_roll_player.domain.exceptions.DomainAccionException;

public interface Accion {
    default void realizaAccion(Personaje personaje) {
        if (!puedeRealizarse(personaje)) {
            throw new DomainAccionException("No puede realizarse accion");
        }
        this.accion(personaje);
    }

    void accion(Personaje personaje);

    boolean puedeRealizarse(Personaje personaje);
}
