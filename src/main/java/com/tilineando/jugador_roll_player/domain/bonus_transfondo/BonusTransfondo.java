package com.tilineando.jugador_roll_player.domain.bonus_transfondo;

public abstract class BonusTransfondo {
    protected int bonus;

    protected BonusTransfondo(int bonus) {
        this.bonus = bonus;
    }

    public abstract boolean cumpleCondicion(int cantOcurrencia);

    public int obteneBonus() {
        return bonus;
    }

}
