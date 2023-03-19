package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Atributo;
import com.tilineando.jugador_roll_player.domain.Dado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PosicionDeDado {
    private Atributo atributo;
    private Integer posicion;

    public Dado obteneDado() {

        if (!tienePosicionValida()) {
            return null;
        }
        return this.atributo.obteneDadoEnPosicion(posicion);
    }

    public boolean tienePosicionValida() {
        return this.atributo != null
                && atributo.estaEnRangoDePosiciones(posicion)
                ;
    }

    @Override
    public String toString() {
        return "PosicionDeDado{" +
                "atributo=" + atributo +
                ", posicion=" + posicion +
                '}';
    }
}