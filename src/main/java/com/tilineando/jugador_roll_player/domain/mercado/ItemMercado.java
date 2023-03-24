package com.tilineando.jugador_roll_player.domain.mercado;

import com.tilineando.jugador_roll_player.domain.Alineamiento;
import com.tilineando.jugador_roll_player.domain.PosicionAlineamiento;
import com.tilineando.jugador_roll_player.domain.acciones.Accion;

public abstract class ItemMercado {
    private int costo;
    private int grupoPreparacion;
    private String nombre;
    private String descripcion;
    private String ambientacion;
    private PosicionAlineamiento posicionAlineamiento;
    private Accion accion;

    public void moveAlinemiento(Alineamiento alineamiento){

    };
 

}
