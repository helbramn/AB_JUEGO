package org.example;

import java.util.Scanner;

public class JugadorHumano implements Jugador {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public boolean replicar(String[] secuencia) {
        System.out.println("Replica la secuencia de colores:");
        for (String color : secuencia) {
            System.out.print(color + " ");
            String input = scanner.next();
            if (!input.equalsIgnoreCase(color)) {
                System.out.println("Error al replicar la secuencia.");
                return false;
            }
        }
        System.out.println("¡Secuencia replicada correctamente!");
        return true;
    }
}
