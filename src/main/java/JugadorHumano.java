import java.util.Scanner;

public class JugadorHumano implements Jugador {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public boolean replicar(String[] secuencia) {
        System.out.println("Replica la secuencia de colores:");
        for (String color : secuencia) { // Imprime el color actual y espera la entrada del jugador
            System.out.print(color + " ");
            String input = scanner.next();

            // Compara la entrada del jugador con el color actual, sin importar mayúsculas o minúsculas
            if (!input.equalsIgnoreCase(color)) {
                System.out.println("Error al replicar la secuencia."); // Si la entrada no coincide con el color actual, muestra un mensaje de error y devuelve falso
                return false;
            }
        }
        System.out.println("¡Secuencia replicada correctamente!");  // Si la secuencia se completa sin errores, muestra un mensaje de éxito y devuelve verdadero
        return true;
    }
}