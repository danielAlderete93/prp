package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Personaje;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class AccionGirarDado180Grados implements AccionAtributoDado {
    private PosicionDeDado posicionDeDado;

    @Override
    public void accion(Personaje personaje) {
        this.posicionDeDado.obteneDado().girate180();
    }

    @Override
    public boolean puedeRealizarse(Personaje personaje) {
        return this.posicionDeDadoCorrespondeAPersonaje(personaje, posicionDeDado);
    }


}
