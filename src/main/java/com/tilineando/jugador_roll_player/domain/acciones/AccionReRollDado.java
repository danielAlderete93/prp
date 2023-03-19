package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Personaje;

public class AccionReRollDado extends AccionModificarDado {
    public AccionReRollDado(PosicionDeDado posicionDeDado) {
        super(posicionDeDado);
    }

    @Override
    public void accion(Personaje personaje) {
        posicionDeDado.obteneDado().realizaRoll();
    }
}
