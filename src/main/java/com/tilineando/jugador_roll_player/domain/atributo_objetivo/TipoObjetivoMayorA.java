package com.tilineando.jugador_roll_player.domain.atributo_objetivo;

import com.tilineando.jugador_roll_player.domain.Atributo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TipoObjetivoMayorA implements TipoObjetivo {
    private int valorMinimo;

    @Override
    public boolean cumpleObjetivo(Atributo atributo) {
        return valorMinimo <= atributo.sumatoriaValorDados();
    }
}
