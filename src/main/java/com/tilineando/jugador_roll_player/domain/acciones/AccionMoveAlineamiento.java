package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.PosicionAlineamiento;

public interface AccionMoveAlineamiento extends Accion {
    public boolean estaEnTableroSiRealizaMovimiento(PosicionAlineamiento posicionActual);
}
