package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Personaje;



public class AccionAumentarValorDado extends AccionModificarDado {
    private final Integer valor;

    public AccionAumentarValorDado(PosicionDeDado posicionDeDado, Integer valor) {
        super(posicionDeDado);
        this.valor = valor;
    }

    @Override
    public void accion(Personaje personaje) {
        posicionDeDado.obteneDado().sumateCant(valor);
    }

}

