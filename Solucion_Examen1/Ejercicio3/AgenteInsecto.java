import java.util.Random;

public class AgenteInsecto {

    private Agente agente;
    private int fila;
    private int columna;
    private Random random;

    public AgenteInsecto(int id, int filaInicial, int columnaInicial) {
        this.agente = new Agente(id);
        this.fila = filaInicial;
        this.columna = columnaInicial;
        this.random = new Random();
    }

    public int getId() {
        return agente.getId();
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }


    public boolean mover(MatrizComida matriz, ColaDeMensaje colaMensajes) {
        int[][] matrizComida = matriz.getMatrizComida();

        int mejorFila = fila;
        int mejorColumna = columna;
        int maxComida = matrizComida[fila][columna];


        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i >= 0 && i < 1000 && j >= 0 && j < 1000) {
                    if (matrizComida[i][j] > maxComida) {
                        mejorFila = i;
                        mejorColumna = j;
                        maxComida = matrizComida[i][j];
                    }
                }
            }
        }


        if (mejorFila != fila || mejorColumna != columna) {
            fila = mejorFila;
            columna = mejorColumna;

            String contenido = "Comida encontrada en (" + fila + "," + columna + ")";
            for (int i = 1; i <= 5; i++) {
                if (i != agente.getId()) {
                agente.enviarMensajeAg(colaMensajes, agente.getId(), i, contenido);
                }
            }

            return true;
        }


        int nuevaFila = fila + random.nextInt(3) - 1;
        int nuevaCol = columna + random.nextInt(3) - 1;

        if (nuevaFila >= 0 && nuevaFila < 1000 && nuevaCol >= 0 && nuevaCol < 1000) {
            fila = nuevaFila;
            columna = nuevaCol;
            return true;
        }

        return false;
    }

    public void intentarRecibirMensaje(ColaDeMensaje cola) {
        agente.recibirMensajeAg(cola);
    }
}