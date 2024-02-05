public class JugadorComputadora implements Jugador {
    @Override
    public boolean replicar(String[] secuencia) {
        for (String color : secuencia) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(color);
        }
        return true; // Siempre replica correctamente
    }
}