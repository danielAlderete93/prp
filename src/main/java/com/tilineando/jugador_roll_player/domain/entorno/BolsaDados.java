package com.tilineando.jugador_roll_player.domain.entorno;

import com.tilineando.jugador_roll_player.domain.Color;
import com.tilineando.jugador_roll_player.domain.Dado;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class BolsaDados {
    List<Dado> dadosDisponibles;

    public BolsaDados() {
        this.dadosDisponibles = DadosDisponibles.obtener();

    }

    public Dado sacaDado() {
        Random random = new Random();
        int index = random.nextInt(dadosDisponibles.size());
        Dado dado = dadosDisponibles.get(index);
        dadosDisponibles.remove(dado);
        return dado;
    }

}
