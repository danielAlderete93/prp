package com.tilineando.jugador_roll_player.domain;


import com.tilineando.jugador_roll_player.domain.interfaces.Identificable;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class Color extends Identificable {
    private String nombre;
}
