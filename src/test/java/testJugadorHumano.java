import org.example.Jugador;
import org.example.JugadorHumano;
import org.example.SimonDice;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SimonDiceTest {

    @Test
    public void testGenerarSecuencia() {
        Jugador jugador = new JugadorHumano();
        SimonDice simonDice = new SimonDice(jugador);

        simonDice.jugar();  // Ejecuta el juego para generar una secuencia

        assertNotNull(simonDice.getSecuencia());
        assertTrue(simonDice.getSecuencia().size() > 0);
    }

    @Test
    public void testJugarSecuenciaCorrecta() {
        Jugador jugador = new JugadorHumano();
        SimonDice simonDice = new SimonDice(jugador);

        simonDice.setSecuencia(Arrays.asList(new String[]{"Rojo", "Azul", "Verde", "Amarillo"}));

        assertTrue(simonDice.jugar());
    }

    @Test
    public void testJugarSecuenciaIncorrecta() {
        Jugador jugador = new JugadorHumano();
        SimonDice simonDice = new SimonDice(jugador);

        simonDice.setSecuencia(Arrays.asList(new String[]{"Rojo", "Azul", "Verde", "Rojo"}));

        assertFalse(simonDice.jugar());
    }

    @Test
    public void testLimiteRepeticiones() {
        Jugador jugador = new JugadorHumano();
        SimonDice simonDice = new SimonDice(jugador);

        simonDice.setSecuencia(Arrays.asList(new String[]{"Rojo", "Azul", "Verde", "Amarillo"}));
        simonDice.setLimiteRepeticiones(2);

        for (int i = 0; i < 2; i++) {
            assertTrue(simonDice.jugar());
        }

        assertFalse(simonDice.jugar());
    }
}
