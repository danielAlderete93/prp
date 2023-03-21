package com.tilineando.jugador_roll_player.domain.atributo_objetivo;

import com.tilineando.jugador_roll_player.domain.Atributo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TipoObjetivoRango implements TipoObjetivo {
    private int valorMinimo;
    private int valorMaximo;

    @Override
    public boolean cumpleObjetivo(Atributo atributo) {
        return atributo.sumatoriaValorDados() <= valorMaximo && atributo.sumatoriaValorDados() >= valorMinimo;
    }
}
