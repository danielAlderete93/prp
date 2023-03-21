package com.tilineando.jugador_roll_player.domain.atributo_objetivo;

import com.tilineando.jugador_roll_player.domain.Atributo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AtributoObjetivoTest {
    final int BONUS_OBJETIVO = 3;
    final int LIM_INF = 14;
    final int LIM_SUP = 18;
    final int VALOR_INTERMEDIO = 16;
    AtributoObjetivo atributoObjetivo;
    TipoObjetivo tipoObjetivo;
    Atributo atributo;

    @BeforeEach
    void setUp() {
        atributo = mock(Atributo.class);
        atributoObjetivo = new AtributoObjetivo(atributo, tipoObjetivo, BONUS_OBJETIVO);
    }

    @Test
    void testAtributoObjetivo_SeObtieneBonusPorTipoObjetivoMayorALimInferior() {
        tipoObjetivo = new TipoObjetivoMayorA(LIM_INF);
        atributoObjetivo.setTipoObjetivo(tipoObjetivo);

        when(atributo.sumatoriaValorDados()).thenReturn(VALOR_INTERMEDIO);

        Assertions.assertEquals(BONUS_OBJETIVO, atributoObjetivo.bonusPorObjetivo());
    }

    @Test
    void  testAtributoObjetivo_NoSeObtieneBonusPorTipoObjetivoMayorALimSuperior() {
        tipoObjetivo = new TipoObjetivoMayorA(LIM_SUP);
        atributoObjetivo.setTipoObjetivo(tipoObjetivo);

        when(atributo.sumatoriaValorDados()).thenReturn(VALOR_INTERMEDIO);

        Assertions.assertEquals(0, atributoObjetivo.bonusPorObjetivo());
        verify(atributo,times(1)).sumatoriaValorDados();
    }

    @Test
    void testAtributoObjetivo_SeObtieneBonusPorTipoObjetivoExactoALimInferior() {
        tipoObjetivo = new TipoObjetivoMayorA(LIM_INF);
        atributoObjetivo.setTipoObjetivo(tipoObjetivo);

        when(atributo.sumatoriaValorDados()).thenReturn(LIM_INF);

        Assertions.assertEquals(BONUS_OBJETIVO, atributoObjetivo.bonusPorObjetivo());
        verify(atributo,times(1)).sumatoriaValorDados();
    }

    @Test
    void testAtributoObjetivo_NoSeObtieneBonusPorTipoObjetivoExactoALimInferior() {
        tipoObjetivo = new TipoObjetivoMayorA(LIM_INF);
        atributoObjetivo.setTipoObjetivo(tipoObjetivo);

        when(atributo.sumatoriaValorDados()).thenReturn(LIM_SUP);

        Assertions.assertEquals(BONUS_OBJETIVO, atributoObjetivo.bonusPorObjetivo());
        verify(atributo,times(1)).sumatoriaValorDados();
    }

    @Test
    void testAtributoObjetivo_SeObtieneBonusPorTipoObjetivoRango() {
        tipoObjetivo = new TipoObjetivoRango(LIM_INF,LIM_SUP);
        atributoObjetivo.setTipoObjetivo(tipoObjetivo);

        when(atributo.sumatoriaValorDados()).thenReturn(VALOR_INTERMEDIO);

        Assertions.assertEquals(BONUS_OBJETIVO, atributoObjetivo.bonusPorObjetivo());
        verify(atributo,times(1)).sumatoriaValorDados();
    }


}
