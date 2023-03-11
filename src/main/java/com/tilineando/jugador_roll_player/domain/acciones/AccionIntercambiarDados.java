package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Dado;
import com.tilineando.jugador_roll_player.domain.Personaje;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccionIntercambiarDados implements AccionAtributoDado {
    private PosicionDeDado posicionInicio;
    private PosicionDeDado posicionFin;

    @Override
    public void accion(Personaje personaje) {
        Dado dadoARecolocar = posicionInicio.obteneDado().clonate();

        posicionInicio
                .obteneDado()
                .cambiatePor(posicionFin.obteneDado());

        posicionFin
                .obteneDado()
                .cambiatePor(dadoARecolocar);
    }

    @Override
    public boolean puedeRealizarse(Personaje personaje) {
        return posicionDeDadoCorrespondeAPersonaje(personaje, posicionInicio)
                && posicionDeDadoCorrespondeAPersonaje(personaje, posicionFin);
    }

}
