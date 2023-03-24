package com.tilineando.jugador_roll_player.domain;

import com.tilineando.jugador_roll_player.domain.bonus_transfondo.BonusTransfondo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transfondo {
    private List<PosicionDeColor> posiciones;
    private List<BonusTransfondo> bonusTransfondos;
    private String nombre;
    private String descripcion;

    public int cantidadOcurrencias() {
        return (int) posiciones.stream().filter(PosicionDeColor::coincideColor).count();
    }

    public Integer obteneBonus() {
        int cantOcurrencias;
        Optional<BonusTransfondo> optBonusTransfondo;

        cantOcurrencias = cantidadOcurrencias();

        optBonusTransfondo = this.bonusTransfondos.stream()
                .filter(bonusTransfondo -> bonusTransfondo.cumpleCondicion(cantOcurrencias))
                .findFirst();

        return optBonusTransfondo.map(BonusTransfondo::obteneBonus)
                .orElse(0);

    }

}
