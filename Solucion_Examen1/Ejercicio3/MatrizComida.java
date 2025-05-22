import java.util.Random;

public class MatrizComida {

    private int[][] matrizComida;
    private boolean[][] casillasRecorridas;
    private Random random;

    public MatrizComida() {
        matrizComida = new int[1000][1000];
        casillasRecorridas = new boolean[1000][1000];
        random = new Random();
    }

    public void asignarComida() {
        int comidaAsignada = 0;
        while (comidaAsignada < 200) {
            int fila = random.nextInt(1000);
            int columna = random.nextInt(1000);

            if (casillasRecorridas[fila][columna]) {
                continue;
            }

            casillasRecorridas[fila][columna] = true;
            comidaAsignada++;

            int sumaVecindario = 0;
            boolean vecinosSinComida = true;

            for (int i = fila - 1; i <= fila + 1; i++) {
                for (int j = columna - 1; j <= columna + 1; j++) {
                    if (i >= 0 && i < 1000 && j >= 0 && j < 1000 && !(i == fila && j == columna)) {
                        sumaVecindario += matrizComida[i][j];
                        if (matrizComida[i][j] != 0) {
                            vecinosSinComida = false;
                        }
                    }
                }
            }

            if (matrizComida[fila][columna] == 0 && vecinosSinComida) {
                matrizComida[fila][columna] = 1;
            } else {
                matrizComida[fila][columna] += sumaVecindario;
            }
        }
        System.out.println("Verificación de celdas con comida:");
        int total = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (matrizComida[i][j] > 0) {
                total++;
                }
            }
        }
        System.out.println("Total de celdas con comida asignadas: " + total);
    }

    public int[][] getMatrizComida() {
        return matrizComida;
    }
}