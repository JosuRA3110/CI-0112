import java.util.Random;

public class MatrizComida{

    private int[][] matrizComida;
    private boolean[][] casillasRecorridas;//Esta matriz nos indica las posiciones que y recorrimos con anterioridad, es decir que ya se les asigno la comida respectiva. 
    private Random random; 

    public MatrizComida(){
        matrizComida = new Int[1000][1000];
        casillasRecorridas = new Int[1000][1000];
        random = new Random();
    }

    public void asignarComida(){
        int comidaAsignada = 0;
        while (comidaAsignada<200) {
            int fila = random.nextInt(1000);
            int columna = random.nextInt(1000);

            if (casillasRecorridas[fila][columna]) {//Aca basicamente lo que decimos es que si ya visitamos esta celda continuamos con el while. 
                continue;
            }
            casillasRecorridas[fila][columna]= true; //Vea que de hecho decimos que si ocurre que ya pasamos por esta celda la cuente como comida ya asignada, con el fin de no repetir celdas con comida.
            comidaAsignada++;

            int sumaVecindario =0; 
            boolean vecinosSinComida = true;
            for(int i = fila-1; i<fila +1; i++){
                for(int j= columna-1; j< columna+1;j++){
                    if(i>= 0 && i<1000 && j>=0 && j<1000 && !(i == fila && j == columna)){
                        sumaVecindario+= matrizComida[i][j];
                        
                        if (matrizComida[i][j] != 0) {
                        vecinosSinComida = false; 
                        }
                    }

                }
            }

            if(matrizComida[fila][columna] == 0 && vecinosSinComida){
                matrizComida[fila][columna]=1;
            }else{
                matrizComida[fila][columna]+= sumaVecindario;
            }
        }
    }

    public int[][] getMatrizComida(){
        return matrizComida;
    }
}