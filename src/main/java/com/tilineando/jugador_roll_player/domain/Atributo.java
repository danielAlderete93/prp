package com.tilineando.jugador_roll_player.domain;

import com.tilineando.jugador_roll_player.domain.acciones.Accion;
import com.tilineando.jugador_roll_player.domain.exceptions.DomainAtributoException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Atributo {
    private String nombre;
    private List<Dado> dados = new ArrayList<>();
    private Integer limiteDados;
    private Accion accion;

    public Integer sumatoriaValorDados() {
        if (dados.isEmpty()) {
            return 0;
        }
        return dados.stream()
                .map(Dado::getValor)
                .reduce(0, Integer::sum);
    }

    public void agregateDado(Dado dado) {
        if (!puedeAgregarDado()) {
            throw new DomainAtributoException("Solo se puede agregar " + this.limiteDados + " dados");
        }
        dados.add(dado);
    }

    public void quitateDado(Dado dado) {
        dados.remove(dado);
    }

    public boolean puedeAgregarDado() {
        return limiteDados > dados.size();
    }


    public boolean estaEnRangoDePosiciones(Integer posicion) {
        return posicion > 0 && posicion <= this.dados.size();
    }


}
