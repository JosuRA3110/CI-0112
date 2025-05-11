//Juego Batalla Naval 
/*Cada jugador cuenta con un tablero de 5x5 y debe colocar manualmente tres barcos de una 
casilla en su propio tablero. Los jugadores se turnan para disparar una coordenada (fila y 
columna) al tablero del oponente. Si aciertan, deben marcar el impacto y continúan su turno; si 
fallan, el turno pasa al otro jugador. El primer jugador en hundir los tres barcos del oponente 
gana la partida. El programa debe mostrar ambos tableros: el del jugador actual (con sus 
barcos e impactos recibidos) y el tablero oculto del oponente (mostrando solo los disparos 
realizados y sus resultados). */
import java.util.Scanner;

public class BatallaNaval{
    private String[][] tablero1 = new String[5][5];//Aca creo los tableros para cada uno de los jugadores, note que son matrices pues requerimos de columnas y filas. Y además se utiliza String porque queria que el barco se viera como un emoji :)
    private String[][] tablero2 = new String[5][5];

    private String[][] vistaTab1 = new String[5][5];//Declaro los tableros que veran los usuarios en consola de sus disparos y aciertos del otro tablero
    private String[][] vistaTab2 = new String[5][5];

    private Scanner scanner = new Scanner(System.in); //Aca basicamente inicializamos los scanner que utilizaremos para la recoleccion de datos.
    
            public static void main(String [] args){//Este main es temporal solo lo uso para probar codigo
        BatallaNaval juego = new BatallaNaval();
        juego.tableroInicial();

        System.out.println("Jugador 1 coloque los barcos:");
        juego.colcBarco(juego.tablero1);
        juego.mostrarTab(juego.tablero1);
        
        System.out.println("Jugador 2 coloque los barcos:");
        juego.colcBarco(juego.tablero2);
        juego.mostrarTab(juego.tablero2);

        juego.iniciarTurnos();
    }

    public void tableroInicial(){
        for(int i=0; i<tablero1.length; i++){
            for(int j=0; j<tablero1.length; j++){//Aca estamos recorriendo todas los espacios de la matriz, es decir, sus filas y columnas.
            tablero1[i][j]= "-";
            tablero2[i][j]= "-";//Vista del tablero de los jugadores sin los barcos posicionados y llenos de agua(-)
            vistaTab1[i][j]= "-";
            vistaTab2[i][j]= "-";//Vista del tablero enemigo lleno de agua(-)
            }//Este metodo basicamente inicializa los tablero que utilizaremos para el juego con el fin de luego modificarlos a gusto.
        }
    }
    public void colcBarco(String[][] tablero){//Aca basicamente hacemos el metodo para que el usuario pueda colocar sus barcos 
        int barcsColc = 0;//Casi se me olvide vea que utilizamos en este metodo un parametro tablero que es un array, esto es solo para que el metodo identifique que vamos a recibir ya sea el tablero1 o el tablero2 :)
        while(barcsColc< 3){//Aca basicamente repetimos la accion de colocar barcos hasta que existan tres barcos colocados en el tablero. Pues si son exactamente 3 barcos el while se detiene, que es lo que queremos :)
            System.out.println("Veamos el barco: " + (barcsColc+1) );//Aca el +1 lo meti porque como inicie la variable en cero me tiraba en consola que colocara el barco 0, entonces ahora ya me da los numeros de forma correcta.

            System.out.println("Por favor digite el numero de la fila de su barco "+ (barcsColc+1)+ " (Debe de ser entre 0 y 4)");
            int filaBarc= scanner.nextInt();
        

            System.out.println("Por favor digite el numero de la columna de su barco "+ (barcsColc+1)+ " (Debe de ser entre 0 y 4)");
            int columBarc= scanner.nextInt();
            //para este punto ya tenemos los barcos "creados", ahora validamos que se encuentren el tablero
         
            if(filaBarc<0 || filaBarc>= tablero.length  || columBarc < 0 || columBarc>= tablero.length){//Vea que aca tenemos que evitar que las filas y columnas sean igual a el tamaño del tablero pues nuestros tablero tiene 5 posiciones pero sus indices son de 0 a 4 por ende no pueden ser exactamente 5 las columnas o las filas pues acceden a algo que no existe.
                System.out.println("Ojooo la posicion que dijito esta fuera del tablero debe de ser entre 0 y 4 ;)");
            }else 
            if (tablero[filaBarc][columBarc].equals("■")){
                System.out.println("Ya coloco un barco en esa posicion, debe de colocar los barcos en posiciones distintas");
            }else{
                tablero[filaBarc][columBarc] = "■";//Aca el barco lo pude poner como B pero senti que quedaba muy simple asi q lo puse como cuadritos rellenos pa que se vea mas divertido ■ :)
                barcsColc++;
                System.out.println("Listoo, su barco fue colocado con exito en la posicion: ("+ filaBarc + ", "+ columBarc+ ")");
            }
        }
    }

    public void mostrarTab(String[][] tablero){//La idea de este metodo es que cualquiera de los jugadores pueda ver su tablero y la colocacion de sus barcos.
        System.out.print("  ");//Esto basicamente me deja la esquina superior izquierda un espacio para que las columnas no se vean feas, o desajustadas. 
        for(int column=0; column < tablero.length; column++){//Vea que aca lo que hacemos es basicamente pedir los numeros de las columnas para mostrarlos en la parte arriba del tablero
            System.out.print(column + " ");//Vea que aca los espacios en el "" son para acomodar los numeros de forma bonita y que no se vean todos pegados.
        }
        System.out.println();//Aca solo metemos un salto de linea para que se vea acomodada la matriz de los barquitos
        
        for(int fil=0; fil< tablero.length; fil++){
            System.out.print(fil + " ");//Ojo que aca solo hemos definido o mostrado el numero de las columnas y filas a los alrededores del tablero, nos falta mostrar lo que tiene cada celda.
            
            //Ahora aca aprovechamos para mostrar lo que tiene cada espacio en el tablero, como ya pusimos los barcos entonces mostraria agua y barcos :)
            for(int column=0; column<tablero.length; column++){
                System.out.print(tablero[fil][column] + " ");//Aca basicamente dejamos el espacio para poner lo que se requiera, en este caso como ya creamos el metodo de colcBarc el codigo ya sabe donde deben de ir los barcos y ya inicializamos los tableros llenos de agua, entonces se supone que deberia de mostrar los barcos y el resto de celdas llenas de agua.
            }
            System.out.println();//Aca otro salto de linea por cuestiones de orden en el tablero.
        }
    }
    //Ahora vamos con los metodos de disparar, la logica ya no me da T_T
    public String disparar(String[][] tableroImpacto){
        while (true) {//Ojo aca lo que decimos es que se repita esta secuencia hasta q lo que pase dentro del while se cumpla, esto con el fin de que no se dispare sobre una coordenada que anteriormente ya se disparo. 
            System.out.println("Digite la posicion que desea impactar");
            
            System.out.println("Fila (0-4)");
            int filadisp = scanner.nextInt();  

            System.out.println("Columna (0-4)");
            int columdisp = scanner.nextInt();//Note que para este punto ya sabemos la posicion donde se desea disparar, falta verificar si esa posicion esta en el tablero y si el disparo no fue realizado en un lugar donde ya se habia disparado con anterioridad, en parte esa es la idea del while true.

            if(filadisp<0 || filadisp>=tableroImpacto.length || columdisp<0 || columdisp>=tableroImpacto.length){
                System.out.println("Debe de digitar una coordenada que se encuentre dentro del tablero, es decir, en donde las filas y columnas por impactar esten entre 0 y 4");
                continue;//Este continue lo que hace es que basicamente no se prosiga en el metodo de disparo si no se cumple con la condicional establecida, vuelve a preguntar al jugador por nuevas coordenadas de disparo
            }else{
                if(tableroImpacto[filadisp][columdisp].equals("O")){//Aca basicamente estamos diciendo que O es la zona donde disparamos con anterioridad, entonces si es igual reinicie el cuestionamiento
                    System.out.println("Disparo anteriormente en esta zona, debe de disparar en una coordenada distinta ;)");
                    continue;
                }
            }
            if(tableroImpacto[filadisp][columdisp].equals("■")){
                tableroImpacto[filadisp][columdisp]= "X";
                return "impacto";
            }else{
                if(tableroImpacto[filadisp][columdisp].equals("-")){
                    tableroImpacto[filadisp][columdisp]="O";
                    return "fallo";
                }
            }
        }//Listo aca ya terminamos el metodo de disparar, por cuestion de orden voy a realizar otro metodo donde determine y use los returns de impacto y fallo, para que cada vez que se presente impacto se repite disparar, si no pasa al otro jugador.

    }

    public void iniciarTurnos(){
        int barcsJug1 = 3;//Note que aca como estamos en el primer turno lo que hacemos es que los barcos colados ya sean tres, pues desde un inicio ya los colocamos para cada jugador.
        int barcsJug2 = 3;
        boolean turnoJug1 = true;//Aca facilitamos el metodo usando la variable booleana donde ya sabemos si el jugador 1 va a empezar su turno
        while(barcsJug1>0 && barcsJug2>0){//Parece un poco obvio las condicionales pero es simplmente notacion para saber que ya tenemos los barcos para iniciar el intercambio de turnos
            if(turnoJug1){
                System.out.println("Jugador 1 dispare!!");
                String resultadodisp = disparar(tablero2);//Vea que aca lo que hacemos es decir, si el resultado del metodo disparar es una variable resultado y cuando aplico disparo al tablero del jugador 2 este me retorna algo, que hago con eso. Que posteriormente lo que hacemos es que si impacta, juege nuevamente y si falla va el otro jugador. Esa es la importancia de los returns declarados.
                if(resultadodisp.equals("impacto")){
                    barcsJug2--;//Aca lo que hacemos es como un contador de los barcos de los jugadores para ir viendo si eliminamos o no un barco rival con el metodo de disparar.
                    System.out.println("El Jugador 1 dio en el blanco, puede repetir su turno");
                }else{
                    System.out.println("El Jugador 1 fallo su disparo, turno del Jugador 2");
                    turnoJug1= false;//Este false lo que hace es que vayamos a el turno del jugador 2.
                }
            }else{
                System.out.println("Jugador 2 dispare!!");
                String resultadodisp = disparar(tablero1);//aca es un poco mas de lo mismo disparamos al tablero del jugador 1
                if(resultadodisp.equals("impacto")){//Si impactamos restamos un barco al jugador 1.
                    barcsJug1--;
                    System.out.println("El Jugador 2 dio en el blanco, puede repetir su turno");
                }else{
                    System.out.println("El Jugador 2 fallo su disparo, turno del Jugador 1");
                    turnoJug1= true;//Aqui esta la importancia del boolean que declaramos pues simplificamos el proceso de turnos para que se reitere hasta que los barcos sean destruidos, ya sea del jugador uno  o del jugador 2.
                }

            }
        }
        if(barcsJug1==0){//Aqui caemos cuando alguno de los barcos de los jugadores es menor o igual a cero, es decir, ya determinamos un ganador. 
            System.out.println("¡¡Felicidades Jugador 2, eres el ganador!!");
        }else{
            if(barcsJug2==0){
                System.out.println("¡¡Felicidades Jugador 1, eres el ganador!!");
            }
        }
    }
}