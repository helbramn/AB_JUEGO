package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SimonDice {
    public final Jugador jugador;
    private final List<String> secuencia = new ArrayList<>();
    private final String[] colores = {"Rojo", "Azul", "Verde", "Amarillo"};
    private final Random random = new Random();
   ;
    private int limiteRepeticiones = 8; // Puedes ajustar este límite
    private int repeticionesRealizadas = 0;
    private final int tiempoVisualizacion = 5000; // 5000 milisegundos (5 segundos)

    public SimonDice(Jugador jugador) {
        this.jugador = jugador;
    }

    public boolean jugar() {
        System.out.println("Bienvenido al juego de 'Simón dice'!");

        while (repeticionesRealizadas < limiteRepeticiones) {
            // Agrega un nuevo color a la secuencia
            secuencia.add(colores[random.nextInt(colores.length)]);

            // Muestra la secuencia al jugador durante 5 segundos
            mostrarSecuencia(tiempoVisualizacion, secuencia);

            // Permite al jugador intentar replicar la secuencia
            if (!jugador.replicar(secuencia.toArray(new String[0]))) {
                // Si el jugador falla, muestra el mensaje y termina el juego
                System.out.println("Lo siento, has perdido. La secuencia era: ");
                mostrarSecuencia(0, secuencia); // Mostrar la secuencia completa si hay un error
                return false;
            }

            // Limpia la pantalla (simulado)
            limpiarPantalla();

            // Incrementa el contador de repeticiones realizadas
            repeticionesRealizadas++;
        }

        // Muestra un mensaje de felicitaciones al llegar al límite
        System.out.println("¡Felicidades! Has replicado la secuencia " + limiteRepeticiones + " veces. ¡Fin del juego!");
        return false;
    }

    public List<String> getSecuencia() {
        return new ArrayList<>(secuencia);
    }

    public void setSecuencia(List<String> nuevaSecuencia) {
        secuencia.clear();
        secuencia.addAll(nuevaSecuencia);
    }

    public void setLimiteRepeticiones(int nuevoLimite) {
        limiteRepeticiones = nuevoLimite;
    }

    public void mostrarSecuencia(int tiempoVisualizacion, List<String> secuencia) {
        for (String color : this.secuencia) {
            System.out.print(color + " ");
            pausa(tiempoVisualizacion / this.secuencia.size());
        }
        pausa(tiempoVisualizacion % this.secuencia.size()); // Tiempo adicional al final
        limpiarPantalla();
    }

    public void pausa(int milisegundos) {
        try {
            TimeUnit.MILLISECONDS.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void limpiarPantalla() {
        // Simula la limpieza de la pantalla (puedes ajustar esto según tu entorno de desarrollo)
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public void mostrarSecuencia(int i) {
    }
}
