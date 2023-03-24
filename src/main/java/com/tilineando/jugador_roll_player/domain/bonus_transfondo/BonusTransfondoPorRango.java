package com.tilineando.jugador_roll_player.domain.bonus_transfondo;

public class BonusTransfondoPorRango extends BonusTransfondo {
    private int maxValor;
    private int minValor;

    public BonusTransfondoPorRango(int bonus, int maxValor, int minValor) {
        super(bonus);
        this.maxValor = maxValor;
        this.minValor = minValor;
    }

    @Override
    public boolean cumpleCondicion(int cantOcurrencias) {
        return cantOcurrencias >= maxValor && cantOcurrencias <= minValor;
    }

}
