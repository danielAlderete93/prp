package com.tilineando.jugador_roll_player.domain;

import com.tilineando.jugador_roll_player.domain.atributo_objetivo.AtributoObjetivo;
import com.tilineando.jugador_roll_player.domain.habilidad_clase.HabilidadClase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Clase {
    private String nombre;
    private List<AtributoObjetivo> objetivos;
    private Color colorDado;
    private HabilidadClase habilidad;

    public Integer bonusPorDados() {
        return objetivos.stream()
                .map(objetivo -> objetivo.bonusPorDadosDeColor(this.colorDado))
                .reduce(Integer::sum)
                .orElse(0);
    }

    public Integer bonusPorObjetivo() {
        return objetivos.stream()
                .map(AtributoObjetivo::bonusPorObjetivo)
                .reduce(Integer::sum)
                .orElse(0);
    }


}
