package com.tilineando.jugador_roll_player.domain;

import com.tilineando.jugador_roll_player.domain.acciones.Accion;
import com.tilineando.jugador_roll_player.domain.exceptions.DomainAtributoException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Atributo {
    private String nombre;
    private List<Dado> dados = new ArrayList<>();
    private Integer limiteDados;
    private Accion accion;
    private boolean puedeUtilizarAccion = true;

    public Integer sumatoriaValorDados() {
        if (dados.isEmpty()) {
            return 0;
        }
        return dados.stream()
                .filter(Objects::nonNull)
                .map(Dado::getValor)
                .reduce(0, Integer::sum);
    }

    public Integer cantDadosDeColor(Color color) {
        if (dados.isEmpty()) {
            return 0;
        }
        return (int) dados.stream()
                .filter(dado -> dado.tenesColor(color))
                .count();
    }

    public void agregateDado(Dado dado) {
        if (!puedeAgregarDado()) {
            throw new DomainAtributoException("Solo se puede agregar " + this.limiteDados + " dados");
        }
        dados.add(dado);
        habilitarAccion();
    }

    public Dado obteneDadoEnPosicion(int posicion) {
        return this.dados.get(posicion);
    }

    public void quitateDado(Dado dado) {
        dados.remove(dado);
    }

    public boolean puedeAgregarDado() {
        return limiteDados > dados.size();
    }


    public boolean estaEnRangoDePosiciones(Integer posicion) {
        return posicion >= 0 && posicion <= limiteDados;
    }

    public void realizaAccion(Personaje personaje) {
        if (!puedeUtilizarAccion) {
            throw new DomainAtributoException("No puede ejecutar la accion del atributo" + this.nombre);
        }
        accion.realizaAccion(personaje);
        deshabilitarAccion();
    }

    public void habilitarAccion() {
        this.puedeUtilizarAccion = true;
    }

    public void deshabilitarAccion() {
        this.puedeUtilizarAccion = false;
    }

}
