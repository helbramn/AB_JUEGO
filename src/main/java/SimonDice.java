import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SimonDice {
    private final Jugador jugador;
    private final List<String> secuencia = new ArrayList<>();
    private final String[] colores = {"Rojo", "Azul", "Verde", "Amarillo"}; // Todos los colores que pueden aparecer
    private final Random random = new Random();
    private final int limiteRepeticiones = 8; // Limite de colores que aparecera en una partida. Editable
    private int repeticionesRealizadas = 0;
    private final int tiempoVisualizacion = 3000; // 3000 milisegundos (3 segundos)

    public SimonDice(Jugador jugador) {
        this.jugador = jugador;
    }

    public void jugar() {
        System.out.println(" Bienvenido al juego de 'Simón dice'!");

        while (repeticionesRealizadas < limiteRepeticiones) {
            // Agrega un nuevo color a la secuencia
            secuencia.add(colores[random.nextInt(colores.length)]);

            // Muestra la secuencia al jugador durante 3 segundos
            if (repeticionesRealizadas > 0) {
                mostrarSecuencia(tiempoVisualizacion);
            }

            // Permite al jugador intentar replicar la secuencia
            if (!jugador.replicar(secuencia.toArray(new String[0]))) {
                // Si el jugador falla, se termina el juego y sale mensaje de derrota por pantalla
                System.out.println("Lo siento, has perdido, a ver si aprendemos a leer. La secuencia era: ");
                mostrarSecuencia(0); // Mostrar la secuencia completa si hay un error
                return;
            }

            // Limpia la pantalla (simulado)
            limpiarPantalla();

            // Incrementa el contador de repeticiones realizadas
            repeticionesRealizadas++;
        }

        // Muestra un mensaje de felicitaciones al llegar al límite
        System.out.println("¡Felicidades! Has replicado la secuencia " + limiteRepeticiones + " veces. ¡Fin del juego!");
    }

    private void mostrarSecuencia(int tiempoVisualizacion) {
        for (String color : secuencia) {
            System.out.print(color + " ");
            pausa(tiempoVisualizacion / secuencia.size());
        }
        pausa(tiempoVisualizacion % secuencia.size()); // Tiempo adicional al final
        limpiarPantalla();
    }

    private void pausa(int milisegundos) {
        try {
            TimeUnit.MILLISECONDS.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void limpiarPantalla() {
        // Simula la limpieza de la pantalla
        for (int i = 0; i < 50; ++i) System.out.println();
    }
}
