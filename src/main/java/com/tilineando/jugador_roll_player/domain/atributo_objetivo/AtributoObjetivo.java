package com.tilineando.jugador_roll_player.domain.atributo_objetivo;

import com.tilineando.jugador_roll_player.domain.Atributo;
import com.tilineando.jugador_roll_player.domain.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AtributoObjetivo {
    private Atributo atributo;
    private TipoObjetivo tipoObjetivo;
    private int bonus;

    public int bonusPorDadosDeColor(Color color) {
        return atributo.cantDadosDeColor(color);
    }

    public int bonusPorObjetivo() {
        return tipoObjetivo.cumpleObjetivo(atributo) ? bonus : 0;
    }

}
