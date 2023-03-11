package com.tilineando.jugador_roll_player.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {
    private List<Atributo> atributos;

    public Boolean tieneAtributo(Atributo atributo) {
        return this.atributos.contains(atributo);
    }



}
