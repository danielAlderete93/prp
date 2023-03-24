package com.tilineando.jugador_roll_player.domain.entorno;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TableroAlineamiento {
    private static final TableroAlineamiento instance = new TableroAlineamiento();
    private int menorPosX = 0;
    private int mayorPosX = 2;
    private int menorPosY = 0;
    private int mayorPosY = 2;


    private TableroAlineamiento() {
    }

    public static TableroAlineamiento getInstance() {
        return instance;
    }


}
