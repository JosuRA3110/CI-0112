//Juego Batalla Naval 
/*Cada jugador cuenta con un tablero de 5x5 y debe colocar manualmente tres barcos de una 
casilla en su propio tablero. Los jugadores se turnan para disparar una coordenada (fila y 
columna) al tablero del oponente. Si aciertan, deben marcar el impacto y continúan su turno; si 
fallan, el turno pasa al otro jugador. El primer jugador en hundir los tres barcos del oponente 
gana la partida. El programa debe mostrar ambos tableros: el del jugador actual (con sus 
barcos e impactos recibidos) y el tablero oculto del oponente (mostrando solo los disparos 
realizados y sus resultados). */
public class BatllaNaval{
    private int[][] tablero1;//Aca creo los tableros para cada uno de los jugadores, note que son matrices pues requerimos de columnas y filas.
    private int[][] tablero2;

    private int[][] vistaTab1;//Declaro los tableros que veran los usuarios en consola de sus disparos y aciertos del otro tablero
    private int[][] vistaTab2;

}