package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Personaje;

public class AccionGirar180GradosDado extends AccionModificarDado {

    public AccionGirar180GradosDado(PosicionDeDado posicionDeDado) {
        super(posicionDeDado);
    }

    @Override
    public void accion(Personaje personaje) {
        this.posicionDeDado.obteneDado().girate180();
    }


}
