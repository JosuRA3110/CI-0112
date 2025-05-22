public class Simulacion {

    public static void main(String[] args) {
 
        MatrizComida matriz = new MatrizComida();
        matriz.asignarComida();

        ColaDeMensaje colaMensajes = new ColaDeMensaje();

        AgenteInsecto[] agentes = new AgenteInsecto[5];
        for (int i = 0; i < 5; i++) {
            int filaRandom = (int)(Math.random() * 1000);
            int colRandom = (int)(Math.random() * 1000);
            agentes[i] = new AgenteInsecto(i + 1, filaRandom, colRandom);
        }

        boolean cambio;
        int iteraciones = 0;

        // Inicamos el ciclo de la simulacion.
        do {
            cambio = false;

            System.out.println("Iteración: " + (++iteraciones));

            for (AgenteInsecto agente : agentes) {
                boolean seMovio = agente.mover(matriz, colaMensajes);
                if (seMovio) {
                    cambio = true;
                    System.out.println("Agente " + agente.getId() + " se movió a (" + agente.getFila() + ", " + agente.getColumna() + ")");
                }
            }

            // Todos intentan recibir mensajes
            for (AgenteInsecto agente : agentes) {
                agente.intentarRecibirMensaje(colaMensajes);
            }

            System.out.println("Mensajes en cola: " + colaMensajes.cantidadMensajes());
            System.out.println("------------------------------------------------");

        } while (cambio || colaMensajes.existeMensaje());

        System.out.println("Simulación terminada.");
    }
}