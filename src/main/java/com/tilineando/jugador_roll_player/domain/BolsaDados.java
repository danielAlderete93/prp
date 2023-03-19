package com.tilineando.jugador_roll_player.domain;

import com.tilineando.jugador_roll_player.domain.entorno.DadosDisponibles;
import com.tilineando.jugador_roll_player.domain.exceptions.DomainBolsaDadosException;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter
@Setter
public class BolsaDados {
    List<Dado> dadosDisponibles;

    public BolsaDados() {
        this.dadosDisponibles = DadosDisponibles.obtener();
        if (null == dadosDisponibles) {
            throw new DomainBolsaDadosException("No se pudo rellenar la bolsa con dados.");
        }
    }

    public BolsaDados(List<Dado> dadosDisponibles) {
        this.dadosDisponibles = dadosDisponibles;
        if (null == dadosDisponibles) {
            throw new DomainBolsaDadosException("No se pudo rellenar la bolsa con dados.");
        }
    }

    public Dado sacateDado() {
        if (dadosDisponibles.isEmpty()) {
            throw new DomainBolsaDadosException("La bolsa de dados esta vacia");
        }
        return sacaEliminandoDado();
    }

    private Dado sacaEliminandoDado() {
        Random random = new Random();
        int index = random.nextInt(dadosDisponibles.size());
        Dado dado = dadosDisponibles.get(index);
        dadosDisponibles.remove(dado);
        return dado;
    }


}
