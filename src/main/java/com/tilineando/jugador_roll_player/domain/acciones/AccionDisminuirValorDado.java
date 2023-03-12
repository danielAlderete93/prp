package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Personaje;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class AccionDisminuirValorDado extends AccionModificarDado {
    private final Integer valor;

    public AccionDisminuirValorDado(PosicionDeDado posicionDeDado, Integer valor) {
        super(posicionDeDado);
        this.valor = valor;
    }

    @Override
    public void accion(Personaje personaje) {
        posicionDeDado.obteneDado().restateCant(valor);
    }

}
