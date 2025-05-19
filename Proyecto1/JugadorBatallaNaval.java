//Clase de JugadorBatallaNaval
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

    public boolean colocarBarcoJug(int filaJug, int columnaJug){
        return tableroJug.colcBarco(filaJug, columnaJug);
    }

    public void mostrarTableroJug(){
        System.out.println("El tablero del jugador: "+ nombre);
        tableroJug.mostrarTab();
    }

    public void mostrarTableroVistaOp(){
        System.out.println("El tablero de su oponente: "+ nombre);
        vistaOponente.mostrarTab();
    }

    public String disparar(int filaOp, int columOp, JugadorBatallaNaval Enemigo){
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