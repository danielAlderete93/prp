package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Personaje;
import com.tilineando.jugador_roll_player.domain.PosicionAlineamiento;
import com.tilineando.jugador_roll_player.domain.entorno.TableroAlineamiento;

public class AccionMoveAlineamientoIzquierda implements AccionMoveAlineamiento {
    @Override
    public void accion(Personaje personaje) {
        personaje.getAlineamiento().moveteIzquierda();
    }

    @Override
    public boolean puedeRealizarse(Personaje personaje) {
        PosicionAlineamiento posicionAlineamiento = personaje.getAlineamiento().getPosicionActual();
        return estaEnTableroSiRealizaMovimiento(posicionAlineamiento);
    }


    @Override
    public boolean estaEnTableroSiRealizaMovimiento(PosicionAlineamiento posicionActual) {
        return TableroAlineamiento.getInstance().getMenorPosX() <= posicionActual.getPosicionX() - 1;
    }
}
