package com.tilineando.jugador_roll_player.domain.acciones;

import com.tilineando.jugador_roll_player.domain.Personaje;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AccionGirarDado180Grados extends AccionModificarDado {

    public AccionGirarDado180Grados(PosicionDeDado posicionDeDado) {
        super(posicionDeDado);
    }

    @Override
    public void accion(Personaje personaje) {
        this.posicionDeDado.obteneDado().girate180();
    }


}
