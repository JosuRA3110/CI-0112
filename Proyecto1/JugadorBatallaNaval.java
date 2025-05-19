//Clase de JugadorBatallaNaval
import java.util.Scanner;

public class JugadorBatallaNaval{
    private String nombre; 
    private Tablero tableroJug;
    private Tablero vistaOponente; 
    private Scanner scanner = new Scanner(System.in);

    //Metodo constructor
    public JugadorBatallaNaval(String nombre){
        this.nombre= nombre;
        this.tableroJug= new Tablero();
        this.vistaOponente= new Tablero();
    }
    //Getters 
    public String getNombre(){
        return nombre; 
    }

    public Tablero getTableroJug(){
        return tableroJug;
    }

    /**
     * @brief Este metodo intenta colocar un barco en la posicion indicada por los parametros
     * 
     * Vea que se esta llamando a la clase tablero donde vemos el metodo colcBarco para verificar si se puede colocar un barco en esa posicion o no
     * @param filaJug baciamente indica la fila donde se esta verificando si se puede colocar un barco
     * @param columnaJug baciamente indica la columna donde se esta verificando si se puede colocar un barco
     * @return retorna true en caso que se pueda y se coloca exitosamente el barco, retorna false si no se pudo colocar el barco 
     */
    public boolean colocarBarcoJug(int filaJug, int columnaJug){
        return tableroJug.colcBarco(filaJug, columnaJug);
    }

    /**
     * @brief En este metodo se colocan como tal los barcos a travez de un parametro scanner, donde se verifican si cumplen con los rangos necesarios y si ya se contaba con un barco en esa posicion. 
     * Esto se repite hasta que el jugador colocara tres barcos. 
     * @param scanner Basicamente es un objeto scanner que se utiliza para leer o procesar las coordenadas dadas por el jugador en consola y vistas en laas variables filaColcBarc y columnaColcBarc. 
     */
    public void colocarBarcosJug(Scanner scanner) {
        int barcosColocar = 3; 
        int colocados = 0;

        while (colocados < barcosColocar) {
            System.out.println("Coloque el barco " + (colocados + 1)+ " por favor :)");
            System.out.print("Digite la fila (1-5): ");
            int filaColcBarc = scanner.nextInt() - 1;
            System.out.print("Digite la columna (1-5): ");
            int columnaColcBarc = scanner.nextInt() - 1;

            if (filaColcBarc < 0 || filaColcBarc >= 5 || columnaColcBarc < 0 || columnaColcBarc >= 5) {
                System.out.println("Cuidado las coordenadas no estan en el rango adecuado, intentalo de nuevo.");
                continue;
            }

            boolean colocacionExitosa = colocarBarcoJug(filaColcBarc, columnaColcBarc);
            if (colocacionExitosa) {
                System.out.println("Barco colocado con exito :)");
                colocados++;
                mostrarTableroJug();
                } else {
                System.out.println("No se pudo colocar el barco ahí, intenta en otra posición.");
                }
            }
    }

    /**
     * @brief Este metodo muestra el tablero del jugador con el respectivo nombre del jugador.
     */
    public void mostrarTableroJug(){
        System.out.println("El tablero del jugador: "+ nombre);
        tableroJug.mostrarTab();
    }

    /**
     * @brief Este metodo se encarga de mostrar el tablero del jugador rival oculto, en este caso el parametro que recibe es el nombre del jugador rival para imprimirlo correctamente en consola. 
     * @param nombreOponente Este parametro basicamente obtiene el nombre del oponente para imprimirlo adecuadamente sobre el tablero. 
     */
    public void mostrarTableroVistaOp(String nombreOponente){
        System.out.println("El tablero de su oponente: "+ nombreOponente);
        vistaOponente.mostrarTab();
    }

    /**
     * @brief Este metodo se encarga de ejecutar la accion de disparar al tablero del oponente y actualiza el tablero del oponente conforme a ello. 
     * 
     * Vea que llama al metodo recibirDisp para identificar si el disparo realizado acerto o no, para poder actualizar el tablero de la vista del oponente conforme a ello. 
     * @param filaOp indica la fila que esta siendo disparada
     * @param columOp indica la columna que esta siendo disparada
     * @param enemigo Basicamente instancia el jugador oponente que esta recibiendo el disparo. 
     * @return Parecido al metodo de recibirDisp, retorna Impacto si se destruyo un barco, fallo si se dio al agua, y repitio en caso de que el disparo sea sobre un mismo punto, vea que devuelve el resultado del disparo
     * para cada uno de estos casos en especifico. Es como una cadena que indica que sucedio con el disparo en el tablero del oponente. 
     */
    public String disparar(int filaOp, int columOp, JugadorBatallaNaval enemigo){
        String resultadoDisp = enemigo.tableroJug.recibirDisp(filaOp, columOp);
        if(resultadoDisp.equals("impacto")){
            vistaOponente.getCasillas()[filaOp][columOp]= "X";
        }else if(resultadoDisp.equals("fallo")){
            vistaOponente.getCasillas()[filaOp][columOp]= "O";
        }else if(resultadoDisp.equals("repetido")){
            System.out.println("Opaaaaa ya disparaste en esta posicion");
        }
        return resultadoDisp;
    }

    /**
     * @brief En este metodo verificamos la existencia de barcos en los jugadores, simplemente para determinar un ganador en el juego. 
     * Vea que lo que hace el metodo es recorrer los tableros para identificar si poseen o no un barco. 
     * @return basicamente retorna true si eciste por lo menos un barco en el tablero y retorna false si ya no se cuentan con barcos en el tablero.
     */
    public boolean existenBarcos(){
        String[][] casillas = tableroJug.getCasillas();
        for(int i= 0; i<casillas.length; i++){
            for(int j=0; j<casillas.length; j++){
                if(casillas[i][j].equals("■")){
                    return true;
                }
            }
        }
        return false; 
    }
}