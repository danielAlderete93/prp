package com.tilineando.jugador_roll_player.domain;

import com.tilineando.jugador_roll_player.domain.acciones.PosicionDeDado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PosicionDeColor extends PosicionDeDado {
    private Color color;

    public PosicionDeColor(Atributo atributo, Integer posicion, Color color) {
        super(atributo, posicion);
        this.color = color;
    }

    public boolean coincideColor() {
        Dado dado = this.obteneDado();
        if (null == dado) {
            return false;
        }
        return this.obteneDado().tenesColor(color);
    }

}
