//Clase Juego Batalla Naval 

import java.util.InputMismatchException;
import java.util.Scanner;

public class BatallaNaval{
    private JugadorBatallaNaval jug1;
    private JugadorBatallaNaval jug2;
    private Scanner scanner = new Scanner(System.in);
    
    public void jugarBatallaNaval(){
        System.out.println("Bienvenido a el juego Batalla Naval, por favor lea lo siguiente :)");
        System.out.println();
        System.out.println("Nociones generales:");
        System.out.println();
        System.out.println("1. Los barcos son representados por ■");
        System.out.println();
        System.out.println("2. El agua en los tableros es representada por -");
        System.out.println();
        System.out.println("3. Los disparos exitosos en los barcos son representados por X");
        System.out.println();
        System.out.println("4. Los disparos fallidos o sobre el agua son representados por O");
        System.out.println();
        System.out.println("5. Por ultimo, pero no menos importante, recuerde divertirse y espero que disfrute del juego, usuario promedio :)");
        System.out.println();
        System.out.println(" -------------¡Mucha Suerte!-------------");
        System.out.println(" ----------------------------------------");
        System.out.println();
    
        //Aca estamos creando a los jugadores, bueno en verdad poniendoles nombre
        System.out.println("Digite el nombre del jugador 1 por favor :)");
        jug1 = new JugadorBatallaNaval(scanner.nextLine());

        System.out.println("Digite el nombre del jugador 2 por favor :)");
        jug2 = new JugadorBatallaNaval(scanner.nextLine());

        //Aca utilizamos los metodos creados en las diferentes clases para colocar los barcos:
        System.out.println("Ahora preparen sus tableros :)");
        System.out.println("Empiece a colocar sus barcos");
        colocarBarcos(jug1);
        limpPantalla();
        colocarBarcos(jug2);
        limpPantalla();

        //Ahora si vamos con el juego:
        boolean turnoJug1 = true; //Aca por comodidad asumimos que empieza el jugador 1
        System.out.println("¡¡Ahora si, que empiece la Batalla Naval!!");
        while(true){
            JugadorBatallaNaval jugadorActu = turnoJug1 ? jug1 : jug2;
            JugadorBatallaNaval jugadorEnemigo = turnoJug1 ? jug2 : jug1;

            System.out.println("Vamos " + jugadorActu.getNombre() + ", es tu turno");
            jugadorActu.mostrarTableroJug();
            jugadorActu.mostrarTableroVistaOp();

            int tableroTam = jug1.getTableroJug().getCasillas().length; 
            while(true){
                try{
                    System.out.println("Fila por disparar (1-5): ");
                    int filaDispJug = scanner.nextInt() -1;

                    System.out.println("Columna por disparar (1-5): ");
                    int columnaDispJug = scanner.nextInt() -1;
                    
                    if(filaDispJug<0 || filaDispJug>=tableroTam || columnaDispJug<0 || columnaDispJug>=tableroTam){
                        System.out.println("Ojooooo las coordenadas por disparar estan fuera del rango permitido por el tablero, digitelas nuevamente por favor");
                        continue;
                    }

                    String resultadoDisp = jugadorActu.disparar(filaDispJug, columnaDispJug, jugadorEnemigo);

                    if(resultadoDisp.equals("impacto")){
                        System.out.println("Felicidades acertaste el disparo :)");
                        System.out.println("Puesdes repetir tu turno");
                    }else if(resultadoDisp.equals("fallo")){
                        System.out.println("Lamentablemente fallaste :(");
                        turnoJug1 = false;
                    }else {
                        System.out.println("Ya habias disparado en esta posicion, intentalo nuevamente");
                        continue;
                    }
                    if(!jugadorEnemigo.existenBarcos()){
                        System.out.println("Enhorabuena "+ jugadorActu.getNombre()+ "tumbaste todos los barcos, eres el ganador :)");
                        return;
                    } 
                }catch(InputMismatchException e){
                    System.out.println("Debes de digitar un numero valido");
                    scanner.nextLine();
                }
            }

        }

    }
    public void limpPantalla(){
        for(int i=0; i<60; i++){//Aca basicamente, no se mucho sobre como limpiar la pantalla pero ya con estos 60 espacios en blanco digamooos que se limpia la pantalla ;)
            System.out.println();
        }
    }

    public void colocarBarcos(JugadorBatallaNaval jugador1o2){
        System.out.println("Te toca colocar los barcos "+ jugador1o2.getNombre());
        jugador1o2.mostrarTableroJug();
        jugador1o2.colocarBarcosJug(scanner);
    }


}
