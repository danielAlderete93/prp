package com.tilineando.jugador_roll_player.domain.entorno;

import com.tilineando.jugador_roll_player.domain.Color;
import com.tilineando.jugador_roll_player.domain.Dado;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DadosDisponibles {
    private static final DadosDisponibles instance = new DadosDisponibles();
    private static final Integer valorMinimo = 1;
    private static final Integer valorMaximo = 6;

    private DadosDisponibles() {
    }

    public static DadosDisponibles getInstance() {
        return instance;
    }

    public static List<Dado> obtener() {
        List<Dado> dados = null;
        try {
            File file = new File("src/main/resources/config/dados");
            Scanner scanner = new Scanner(file);
            String color = "";
            int cantidad = 0;
            dados = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.startsWith("color")) {
                    color = line.substring(line.indexOf("=") + 1);
                }

                if (line.startsWith("cantidad")) {
                    cantidad = Integer.parseInt(line.substring(line.indexOf("=") + 1));

                    for (int i = 0; i < cantidad; i++) {
                        Dado dado = new Dado(new Color(color), null, 1, 6);
                        dados.add(dado);
                    }

                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dados;
    }
}


