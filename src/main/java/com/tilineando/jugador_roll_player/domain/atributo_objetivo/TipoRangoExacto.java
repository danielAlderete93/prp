package com.tilineando.jugador_roll_player.domain.atributo_objetivo;

import com.tilineando.jugador_roll_player.domain.Atributo;

public class TipoRangoExacto implements TipoObjetivo {
    private int valor;

    @Override
    public boolean cumpleObjetivo(Atributo atributo) {
        return atributo.sumatoriaValorDados().equals(valor);

    }
}
