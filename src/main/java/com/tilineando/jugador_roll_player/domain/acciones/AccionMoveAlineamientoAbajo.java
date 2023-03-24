package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Alineamiento;
import com.tilineando.jugador_roll_player.domain.Personaje;
import com.tilineando.jugador_roll_player.domain.PosicionAlineamiento;
import com.tilineando.jugador_roll_player.domain.entorno.TableroAlineamiento;

public class AccionMoveAlineamientoAbajo implements AccionMoveAlineamiento {
    @Override
    public void accion(Personaje personaje) {
        Alineamiento alineamiento = personaje.getAlineamiento();
        alineamiento.moveteAbajo();
    }

    @Override
    public boolean puedeRealizarse(Personaje personaje) {
        PosicionAlineamiento posicionAlineamiento = personaje.getAlineamiento().getPosicionActual();
        return estaEnTableroSiRealizaMovimiento(posicionAlineamiento);
    }


    @Override
    public boolean estaEnTableroSiRealizaMovimiento(PosicionAlineamiento posicionActual) {
        return posicionActual.getPosicionY() + 1 <= TableroAlineamiento.getInstance().getMayorPosY();
    }
}
