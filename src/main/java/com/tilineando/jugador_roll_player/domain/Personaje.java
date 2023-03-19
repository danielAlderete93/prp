package com.tilineando.jugador_roll_player.domain;

import com.tilineando.jugador_roll_player.domain.exceptions.DomainPersonajeException;
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

    public boolean tieneAtributo(Atributo atributo) {
        return this.atributos.contains(atributo);
    }

    public void agregaDadoEnAtributo(Dado dado, Atributo atributo) {
        if (!tieneAtributo(atributo)) {
            throw new DomainPersonajeException("El atributo no corresponde a este jugador");
        }
        atributo.agregateDado(dado);
    }


}
