public class JugadorComputadora implements Jugador {
    @Override
    public boolean replicar(String[] secuencia) {
        for (String color : secuencia) {
            try {
                Thread.sleep(1000); //Simula un retraso de 1000 milisegundos (1 segundo) entre cada color
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(color);  // Imprime el color actual
        }
        return true; // Siempre replica correctamente
    }
}