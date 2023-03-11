package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Personaje;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccionAumentarValorDado implements AccionAtributoDado {
    private PosicionDeDado posicionDeDado;
    private Integer valor;

    @Override
    public void accion(Personaje personaje) {
        posicionDeDado.obteneDado().sumateCant(valor);
    }

    @Override
    public boolean puedeRealizarse(Personaje personaje) {
        return posicionDeDadoCorrespondeAPersonaje(personaje, posicionDeDado);
    }
}
