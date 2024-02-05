import org.example.JugadorHumano;
import org.example.SimonDice;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimonDiceTest {

    // Test para el método 'pausa'
    @Test
    public void testPausa() {
        SimonDice simonDice = new SimonDice(new JugadorHumano());
        long startTime = System.currentTimeMillis();
        simonDice.pausa(1000);  // Pausa de 1000 milisegundos (1 segundo)
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        // Verificar si el tiempo de pausa está dentro de un rango aceptable
        assertTrue(elapsedTime >= 1000 && elapsedTime < 1100, "El tiempo de pausa debería ser aproximadamente 1000 ms");
    }

    // Test para verificar si el método 'replicar' de JugadorHumano funciona correctamente con una secuencia aleatoria
    @Test
    public void testReplicarJugadorHumanoConSecuenciaAleatoria() {
        SimonDice simonDice = new SimonDice(new JugadorHumano());

        // Obtener la secuencia generada aleatoriamente por el juego
        List<String> secuencia = simonDice.getSecuencia();

        // Construir la entrada simulada para el jugador humano
        String input = String.join(" ", secuencia) + "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Verificar si el método replicar del jugador humano devuelve true
        assertTrue(simonDice.jugador.replicar(secuencia.toArray(new String[0])), "La replicación de la secuencia debería ser correcta");

        // Restaurar la entrada estándar
        System.setIn(System.in);
    }
}
