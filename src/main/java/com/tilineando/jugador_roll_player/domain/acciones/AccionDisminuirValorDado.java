package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Personaje;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class AccionDisminuirValorDado implements AccionAtributoDado {
    private PosicionDeDado posicionDeDado;
    private Integer valor;

    @Override
    public void accion(Personaje personaje) {
        posicionDeDado.obteneDado().restateCant(valor);
    }

    @Override
    public boolean puedeRealizarse(Personaje personaje) {
        return posicionDeDadoCorrespondeAPersonaje(personaje, posicionDeDado);
    }
}
