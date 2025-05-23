//Clase Tablero
public class Tablero {//Note que en la clase tablero creamos los tableros, por lo que nos interesa el contenido de dichos objetos, es decir, sus casillas.
    private String [][] casillas = new String[5][5]; 
    
    //Metodo constructor
    public Tablero(){//Note que para este constructor basicamente iniciamos cada uno de los tableros con agua (-); 
        for(int i=0; i<casillas.length; i++){
            for(int j=0; j<casillas.length; j++){
                casillas[i][j]= "-";
            }
        }
    }
    //Getters
    public String[][] getCasillas(){
        return casillas;
    }
    
    /**
     * @brief Este metodo se encarga de verificar por medio de un booleano si se puede colocar un barco en la casilla indicada por los pametros.
     * 
     * Este metodo baicamente ve cada casilla indicada por los parametros de la fila y columna, para ver si esta vacia, si se encuentra en el tamaño permitido, y en dado caso si esta casilla ya posee un barco. 
     * @param fila indice en el tablero que indica la fila por verificar
     * @param columna indice en el tablero que indica la fila por verificar
     * @return true en el caso de que se colocara el barco correctamente, false si no se puede colocar el barco pues no esta en los parametros permitidos o ya habia un barco.
     */
    public boolean colcBarco(int fila, int columna){//Condicionales para colocar barcos:
        if(fila<0 || fila>= casillas.length  || columna < 0 || columna>= casillas.length){
            return false;
        }
        if (casillas[fila][columna].equals("■")){
            return false;
        }else{
            casillas[fila][columna]= "■";
            return true;
        }

    }

    /**
     * @brief Este metodo se encarga de mostrar los tableros de los jugadores conforme se van agregando los barcos. 
     * 
     * Note que este tablero muestra la numeracion de las filas y columnas y su contenido sea un barco o agua que se colocaron anteriormente, para que el jugador observe progresivamente como va colocando sus barcos.
     */
    public void mostrarTab(){//La idea de este metodo es que cualquiera de los jugadores pueda ver su tablero y la colocacion de sus barcos.
        System.out.print("  ");//Esto basicamente me deja la esquina superior izquierda un espacio para que las columnas no se vean feas, o desajustadas. 
        for(int column=0; column < casillas.length; column++){//Vea que aca lo que hacemos es basicamente pedir los numeros de las columnas para mostrarlos en la parte arriba del tablero
            System.out.print((column+1)+ " ");//Vea que aca los espacios en el "" son para acomodar los numeros de forma bonita y que no se vean todos pegados.
        }
        System.out.println();//Aca solo metemos un salto de linea para que se vea acomodada la matriz de los barquitos, ademas este salto de linea nos permite poner los numero de las filas, como se muestra a continuacion.
        
        for(int fil=0; fil< casillas.length; fil++){
            System.out.print((fil+1) + " ");//Ojo que aca solo hemos definido o mostrado el numero de las columnas y filas a los alrededores del tablero, nos falta mostrar lo que tiene cada celda.
            
            //Ahora aca aprovechamos para mostrar lo que tiene cada espacio en el tablero, pues estamos recorriendo toda la fila y debemos mostrar lo que hay dentro o en medio del tablero. Ademas, como ya pusimos los barcos entonces mostraria agua y barcos :)
            for(int column=0; column<casillas.length; column++){
                System.out.print(casillas[fil][column] + " ");//Aca basicamente dejamos el espacio para poner lo que se requiera, en este caso como ya creamos el metodo de colcBarc el codigo ya sabe donde deben de ir los barcos y ya inicializamos los tableros llenos de agua, entonces se supone que deberia de mostrar los barcos y el resto de celdas llenas de agua.
            }
            System.out.println();//Aca otro salto de linea por cuestiones de orden en el tablero.
        }
    }


    /**
     * @brief Vea que este metodo se encarga de registrar los disparos recibidos y actualizar la informacion de la casilla que los recibe
     * 
     * Basicamente este metodo recibe un disparo y verifica si se impacto un barco, se fallo y dio al agua o si ya se disparo con anterioridad allí con lo q actualiza constantemente el tablero posterior a cada disparo.
     * 
     * @param filaDisp Basicamente indica el indice de la fila que esta siendo impacta por el disparo para poder establecer las coordenadas de disparo.
     * @param columnaDisp Indica la columna donde se impacta y ayuda a determinar que coordenada completa se esta afectando con el tiro. 
     * @return basicamente returna impacto si la casilla que recibe el disparo contenia un barco y la actualiza, si retorna fallo es que la casilla contenia agua y la actualiza con la simbologia apropiada,
     * y si no es ninguna de las anteriores returna repetido que indica que ya se disparo con anterioridad en esa casilla. 
     */
    //Note que en la clase tablero, debemos de registrar los disparos que haaremos desde la consola, solo lo que recibe el tablero para que con el metodo de mostrar tab este se actualice con cada disparo.
    public String recibirDisp(int filaDisp, int columnaDisp){
        if(casillas[filaDisp][columnaDisp].equals("■")){
            casillas[filaDisp][columnaDisp] = "X";
            return "impacto";
        } else if(casillas[filaDisp][columnaDisp].equals("-")){
            casillas[filaDisp][columnaDisp] = "O";
            return "fallo";
        }
        return "repetido";
    }
}