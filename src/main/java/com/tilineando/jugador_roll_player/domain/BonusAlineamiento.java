package com.tilineando.jugador_roll_player.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BonusAlineamiento {
    private PosicionAlineamiento posicionAlineamiento;
    private Integer bonus;
}
