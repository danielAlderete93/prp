package com.tilineando.jugador_roll_player.domain.bonus_transfondo;

public class BonusTransfondoExacto  extends BonusTransfondo{
    private int ocurrenciasExactas;

    public BonusTransfondoExacto(int bonus, int ocurrenciasExactas) {
        super(bonus);
        this.ocurrenciasExactas = ocurrenciasExactas;
    }

    @Override
    public boolean cumpleCondicion(int cantOcurrencias) {
        return cantOcurrencias == ocurrenciasExactas;
    }

}
