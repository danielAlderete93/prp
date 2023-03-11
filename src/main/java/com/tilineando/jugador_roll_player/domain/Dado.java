package com.tilineando.jugador_roll_player.domain;

import com.tilineando.jugador_roll_player.domain.exceptions.DomainDadoException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dado {
    private Color color;
    private Integer valor;
    private Integer minimoValor;
    private Integer maximoValor;

    public Dado(Dado dado) {
        this.color = dado.getColor();
        this.valor = dado.getValor();
        this.minimoValor = dado.minimoValor;
        this.maximoValor = dado.maximoValor;
    }

    public void setValor(Integer valor) {
        if (valor > maximoValor || valor < minimoValor) {
            throw new DomainDadoException("El nuevo valor " + valor + " del dado supera a los valores maximo y minimo del dado.");
        }
        this.valor = valor;
    }

    public void realizaRoll() {
        int range = maximoValor - minimoValor + 1;
        int newValue = (int)(Math.random() * range) + minimoValor;
        setValor(newValue);
    }



    public Dado girate180() {
        int valorMedio;
        int distancia;
        int res;

        valorMedio = (maximoValor + minimoValor) / 2;
        distancia = valorMedio - valor;

        res = valorMedio + distancia + 1;

        this.setValor(res);
        return this;
    }

    public Dado sumateCant(int cant) {
        Integer res = this.valor + cant;

        if (res > this.maximoValor) {
            res = maximoValor;
        }

        this.setValor(res);
        return this;
    }

    public Dado restateCant(int cant) {
        Integer res = this.valor - cant;

        if (res < this.minimoValor) {
            res = minimoValor;
        }

        this.setValor(res);
        return this;
    }

    public Dado cambiateColor(Color color) {
        this.setColor(color);
        return this;
    }

    public Dado cambiatePor(Dado otroDado) {

        if (otroDado == null) {
            throw new IllegalArgumentException("El dado a intercambiar no puede ser nulo.");
        }
        Dado original = new Dado(this);
        this.setColor(otroDado.getColor());
        this.setValor(otroDado.getValor());
        return original;
    }



    public Dado clonate() {
        return new Dado(this);
    }

}
