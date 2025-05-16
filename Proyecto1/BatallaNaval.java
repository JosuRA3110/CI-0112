//Juego Batalla Naval 

import java.util.Scanner;

public class BatallaNaval{
    private String[][] tablero1 = new String[5][5];//Aca creo los tableros para cada uno de los jugadores, note que son matrices pues requerimos de columnas y filas. Y además se utiliza String porque queria que el barco se viera como un emoji :), spoiler no lo logre, la consola no los lee T_T
    private String[][] tablero2 = new String[5][5];

    private String[][] vistaTab1 = new String[5][5];//Declaro los tableros que veran los usuarios en consola de sus disparos y aciertos del otro tablero
    private String[][] vistaTab2 = new String[5][5];

    private Scanner scanner = new Scanner(System.in); //Aca basicamente inicializamos los scanner que utilizaremos para la recoleccion de datos.
    
    /**
    * @brief En este metodo basicamente se inicia el juego, donde se daran las indicaciones generales y los jugadores podran como tal utilizar el juego en consola.
    */
    public void jugarBatallaNaval(){
        
        tableroInicial();
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
        System.out.println("Jugador 1, preparese y comience a colocar sus barcos por favor :)");
        colcBarco(tablero1);
        System.out.println();
        System.out.println("Sus barcos fueron colocados en el tablero, puede ver sus respectivas posiciones :)");
        mostrarTab(tablero1);

        System.out.println();
        System.out.println("Jugador 2, preparese y comience a colocar sus barcos por favor :)");
        colcBarco(tablero2);
        System.out.println();
        System.out.println("Sus barcos fueron colocados en el tablero, puede ver sus respectivas posiciones :)");
        mostrarTab(tablero2);

        iniciarTurnos();
    }

    /**
     * @brief En este metodo basicamente inicializamos los tableros por comodida para que luego se pueda intercambiar o sustitur el agua por los barcos que se deseen colocar, vea que solo recorremos el array y le colocamos el agua.
     */
    public void tableroInicial(){//Por cuestiones de comodida inicialize todos los tableros llenos de agua pues despues solo los intercambio por barcos y el metodo disparar se me es mucho mas facil. 
        for(int i=0; i<tablero1.length; i++){
            for(int j=0; j<tablero1.length; j++){//Aca estamos recorriendo todas los espacios de la matriz, es decir, sus filas y columnas.
            tablero1[i][j]= "-";
            tablero2[i][j]= "-";//Vista del tablero de los jugadores sin los barcos posicionados y llenos de agua(-)
            vistaTab1[i][j]= "-";
            vistaTab2[i][j]= "-";//Vista del tablero enemigo lleno de agua(-)
            }//Este metodo basicamente inicializa los tablero que utilizaremos para el juego con el fin de luego modificarlos a gusto.
        }
    }

    /**
     * @brief En este metodo nos encargamos de "crear" los barcos, vea que implementamos una variable para saber el numero de barcos colocados, luego el ciclo de colocacion de barcos se repite 3 veces,
     * luego registramos con un scanner la fila y columna de los barcos, para poder ver si dicha posicion se encuentra en el tablero con un if para ver si se puede colocar o no el barco.
     * Posteriormente si cumple con las condiciones adecuadas, se coloca un cuadrito en el tablero que representara los barcos y se suma a la variable de barcos colocados.
     * 
     * @param tablero note que el parametro que recibimos es un tablero, pues como en el inicio declaramos los arrays de tabler1 y tablero2 estos seran los que se actualizaran con los barcos colocados,
     * por lo cual, el metodo debe de recibir de parametro el tablero1 o el tablero2. 
     */
    public void colcBarco(String[][] tablero){//Aca basicamente hacemos el metodo para que el usuario pueda colocar sus barcos 
        int barcsColc = 0;//Casi se me olvide vea que utilizamos en este metodo un parametro tablero que es un array, esto es solo para que el metodo identifique que vamos a recibir ya sea el tablero1 o el tablero2 :)
        while(barcsColc< 3){//Aca basicamente repetimos la accion de colocar barcos hasta que existan tres barcos colocados en el tablero. Pues si son exactamente 3 barcos el while se detiene, que es lo que queremos :)
            System.out.println();
            System.out.println("Veamos el barco: " + (barcsColc+1) );//Aca el +1 lo meti porque como inicie la variable en cero me tiraba en consola que colocara el barco 0, entonces ahora ya me da los numeros de forma correcta.

            System.out.println("Por favor digite el numero de la fila de su barco "+ (barcsColc+1)+ " (Debe de ser entre 0 y 4)");
            int filaBarc= scanner.nextInt();//Aca simplemente el jugador me da la fila de donde colocara su barco.
        
            System.out.println();
            System.out.println("Por favor digite el numero de la columna de su barco "+ (barcsColc+1)+ " (Debe de ser entre 0 y 4)");
            int columBarc= scanner.nextInt();//Igual, me dan la columna donde pondran sus barcos.
            //para este punto ya tenemos los barcos "creados", ahora validamos que se encuentren el tablero
         
            if(filaBarc<0 || filaBarc>= tablero.length  || columBarc < 0 || columBarc>= tablero.length){//Vea que aca tenemos que evitar que las filas y columnas sean igual a el tamaño del tablero pues nuestros tablero tiene 5 posiciones pero sus indices son de 0 a 4 por ende no pueden ser exactamente 5 las columnas o las filas pues acceden a algo que no existe.
                System.out.println();
                System.out.println("Ojooo la posicion que dijito esta fuera del tablero debe de ser entre 0 y 4 ;)");
            }else 
            if (tablero[filaBarc][columBarc].equals("■")){//Aca simplemente verificamos si ya coloco un barco en esa posicion, en dado caso que así fuera simplemente se le indica al usuario que ya coloco un barco en esa posicion.
                System.out.println();
                System.out.println("Ya coloco un barco en esa posicion, debe de colocar los barcos en posiciones distintas");
            }else{
                tablero[filaBarc][columBarc] = "■";//Aca el barco lo pude poner como B pero senti que quedaba muy simple asi q lo puse como cuadritos rellenos pa que se vea mas divertido ■ :)
                barcsColc++;//aqui simplemente indicamos que creamos un barco como tal, por eso sumamos en la variable barcscolc.
                System.out.println();
                System.out.println("Listoo, su barco fue colocado con exito en la posicion: ("+ filaBarc + ", "+ columBarc+ ")");
            }
        }
    }

    /**
     * @brief Este metodo se encarga de basicamente mostrar los tableros.
     * Note que lo que hacemos en el metodo es el diseño "estetico" de los tablero, para ello dejamos la esquina superior izquierda vacia con el print inicial, luego recorremos las columnas del tablero para colocar
     * el numero de columna y separarlos, luego metemos un salto de linea para que se logre poner de forma adecuada los numeros de las filas, se reitera el proceso de las columnas con las filas. Por ultimo, mostramos 
     * lo que tiene cada espacio de la matriz, vea que esto se hace paralelamente con las filas, pues estamos recorriendolas con un solo for por lo que requerimos mostrar lo que "tiene" cada tablero y como ya los inicilizamos
     * y colocamos los barcos deben de mostrar dichas simbologias, note que se implemente un salto de linea por cada fila pues si no no se podria ver el orden del "tablero" porque estaria todo pegado. 
     * @param tablero note que nuevamente unicamente se recibe de parametro un tablero, en este caso se utilizara tanto para la vista de enemigo como para los tableros de los jugadores, para mostrarlos en consola.
     */
    public void mostrarTab(String[][] tablero){//La idea de este metodo es que cualquiera de los jugadores pueda ver su tablero y la colocacion de sus barcos.
        System.out.print("  ");//Esto basicamente me deja la esquina superior izquierda un espacio para que las columnas no se vean feas, o desajustadas. 
        for(int column=0; column < tablero.length; column++){//Vea que aca lo que hacemos es basicamente pedir los numeros de las columnas para mostrarlos en la parte arriba del tablero
            System.out.print(column + " ");//Vea que aca los espacios en el "" son para acomodar los numeros de forma bonita y que no se vean todos pegados.
        }
        System.out.println();//Aca solo metemos un salto de linea para que se vea acomodada la matriz de los barquitos, ademas este salto de linea nos permite poner los numero de las filas, como se muestra a continuacion.
        
        for(int fil=0; fil< tablero.length; fil++){
            System.out.print(fil + " ");//Ojo que aca solo hemos definido o mostrado el numero de las columnas y filas a los alrededores del tablero, nos falta mostrar lo que tiene cada celda.
            
            //Ahora aca aprovechamos para mostrar lo que tiene cada espacio en el tablero, como ya pusimos los barcos entonces mostraria agua y barcos :)
            for(int column=0; column<tablero.length; column++){
                System.out.print(tablero[fil][column] + " ");//Aca basicamente dejamos el espacio para poner lo que se requiera, en este caso como ya creamos el metodo de colcBarc el codigo ya sabe donde deben de ir los barcos y ya inicializamos los tableros llenos de agua, entonces se supone que deberia de mostrar los barcos y el resto de celdas llenas de agua.
            }
            System.out.println();//Aca otro salto de linea por cuestiones de orden en el tablero.
        }
    }

    /**
     * @brief Metodo para disparar a los tableros
     * Vea que este metodo se maneja mediante un while que se reitera infinitamente hasta devolver un impacto o un fallo esto es practico para hacer un bucle de turnos hasta que alguno de los jugadores destruya todos 
     * los barcos del otro mediante el registro de impactos. Note que en el while se registran las posiciones por disparar mediante scanners, luego se verifican que dichas posiciones esten en el tablero que entra como parametro,
     * inclusive se utilizo un continue para evitar que la consola cierre el programa y reitere la peticion de coordenadas hasta que esten en el intervalo acordado. Luego se verifica si la posicion donde se dispara 
     * ya se disparo anterioremente, si ese es el caso se reitera la peticion de coordenadas cone l continue.  
     * @param tableroImpacto Note que este parametro representa los tableros 1 y 2 de los jugadores pues son los que reciben los impactos y registran si un barco fue destruido.
     * @param vistaTabContrincante Vea que en este caso debemos de utilizar dos parametros, en este se representaran a los tableros con la vista del enemigo para poder actualizar en tiempo real los tableros mostrados
     * en consola con el pasar de cada turno. 
     * @return en continuidad con la explicacion del metodo, para los returns si la posicion disparada fue un barco con el if retornamos un impacto que indica que se le dio a un 
     * barco y se sustituye el cuadrito por una X que indica que se destruyo el barco. Si el disparo dio en el agua se retorna un fallo, como indicacion de que el jugador fallo su disparo. Note que este registro se hace
     * de forma paralela para los tableros de los jugadores como para la vista de los tableros enemigos por la utilidad de los parametros, lo cual ahorro bastante codigo. Ademas por facilidad los returns son strings, pues
     * simplemente se llaman mediante .equals.
     */
    //Ahora vamos con los metodos de disparar, la logica ya no me da T_T
    public String disparar(String[][] tableroImpacto, String[][] vistaTabContrincante){//Aqui cambie el metodo para que cada vez que se disapare los arrays con la vista del enemigo, es decir los vistaTab1 y 2 se actualizen con cada turno, ademas de los tableros de los jugadores, de alli que el metodo solicite o tenga de entrada dichos arrays.
        while (true) {//Ojo aca lo que decimos es que se repita esta secuencia hasta q lo que pase dentro del while se cumpla, esto con el fin de que no se dispare sobre una coordenada que anteriormente ya se disparo. 
            System.out.println();
            System.out.println("Digite la posicion que desea impactar");
            
            System.out.println("Fila (0-4)");
            int filadisp = scanner.nextInt();  

            System.out.println();
            System.out.println("Columna (0-4)");
            int columdisp = scanner.nextInt();//Note que para este punto ya sabemos la posicion donde se desea disparar, falta verificar si esa posicion esta en el tablero y si el disparo no fue realizado en un lugar donde ya se habia disparado con anterioridad, en parte esa es la idea del while true.

            if(filadisp<0 || filadisp>=tableroImpacto.length || columdisp<0 || columdisp>=tableroImpacto.length){
                System.out.println();
                System.out.println("Debe de digitar una coordenada que se encuentre dentro del tablero, es decir, en donde las filas y columnas por impactar esten entre 0 y 4");
                continue;//Este continue lo que hace es que basicamente no se prosiga en el metodo de disparo si no se cumple con la condicional establecida, vuelve a preguntar al jugador por nuevas coordenadas de disparo
            }else{
                if((tableroImpacto[filadisp][columdisp].equals("X") || tableroImpacto[filadisp][columdisp].equals("O")) || (vistaTabContrincante[filadisp][columdisp].equals("O") || vistaTabContrincante[filadisp][columdisp].equals("X"))){//Aca basicamente estamos diciendo que O es la zona donde disparamos con anterioridad, entonces si es igual reinicie el cuestionamiento
                    System.out.println();
                    System.out.println("Disparo anteriormente en esta zona, debe de disparar en una coordenada distinta ;)");
                    continue;//Okay, este if quedo un toque largo porque cuando compile y lo probe, tenia un problema que el bucle me dejaba digitar las posiciones de los barcos destruidos de forma infinita, por ende tuve que poner de condicional que tambien tuviera ya un barco destruido reiterara la peticion de las coordenadas.
                }
            } 
            if(tableroImpacto[filadisp][columdisp].equals("■")){//Esto es el corazon de lo que queremos del metodo, es decir, si tenemos un barco en esta posicion cambielo por X, para indicar que fue destruido, tanto para el tablero al que disparo como para la vista del tablero enemigo para poder ver una actualizacion adecuada en cada uno de los tablero :)
                tableroImpacto[filadisp][columdisp]= "X";
                vistaTabContrincante[filadisp][columdisp]= "X";
                return "impacto";
            }else{
                if(tableroImpacto[filadisp][columdisp].equals("-")){//Y aca simplemente nos indica que fallo el disparo del jugador pues le dio al agua, en este caso se actualiza de forma simultaneaa en el tablero enemigo y mi vision del tab enemigo.
                    tableroImpacto[filadisp][columdisp]="O";
                    vistaTabContrincante[filadisp][columdisp]= "O";
                    return "fallo";
                }
            }
        }//Listo aca ya terminamos el metodo de disparar, por cuestion de orden voy a realizar otro metodo donde determine y use los returns de impacto y fallo, para que cada vez que se presente impacto se repite disparar, si no pasa al otro jugador.

    }

    /**
     * @brief Metodo de Iniciar turnos:
     * En este metodo basicamente se genera el sistema de turnos entre jugadores, note que establecimos tres variables donde vemos que la cantidad de barcos de cada jugador es de tres, y un boolean, esto para facilitar
     * el conocimiento sobre cual jugador recibe su turno, pues solo asignamos que true es cuando juega el jugador 1 y false es el turno del jugador 2. Ahora bien hacemos un while para repetir el sistema de turnos hasta
     * que alguno de los jugadores no tenga barcos en pie. Con los if diseñamos cada escenario, en el jugador 1 mostramos los tableros, tanto el tablero del jugador como el tablero del enemigo, esto por medio de la
     * funcion mostrarTabs donde true asume que el turno es del jugador 1, esta funcion se explicara despues. Posterior a ello llamamos a una variable tipo String (de alli la importancia de los returns como strings en el
     * metodo anterior) que va a ser el resultado del metodo disparar empleado, que en este caso vea que dispara en el tablero2 y en vistaTab1 pues es el turno del jugador 1, ello para actualizarlos de forma simultanea. Ahora bien, se construye la condicional 
     * sobre si esta variable que es el resultado del metodo es un impacto, si es ese el caso disminuimos el numero de barcos del jugador 2 y se repite el turno del jugador 1 pues esta en un while. Si el resultado del metodo disparo
     * es decir la variable resultadodisp es fallo, o cualquier otro distinto a impacto se asume que el jugador 1 fallo su disparo y se procede a repetir este mismo proceso descrito para el jugador 2. Esto hasta que alguno de los
     * dos jugadores se quede sin barcos, que dado sea ese el caso se muestra un mensaje indicando el ganador en dependencia de cual jugador se quedo con un total de cero barcos. 
     */
    public void iniciarTurnos(){
        int barcsJug1 = 3;//Note que aca como estamos en el primer turno lo que hacemos es que los barcos colados ya sean tres, pues desde un inicio ya los colocamos para cada jugador.
        int barcsJug2 = 3;
        boolean turnoJug1 = true;//Aca facilitamos el metodo usando la variable booleana donde ya sabemos si el jugador 1 va a empezar su turno, en dadod caso que sea false, sabemos que le corresponde al jugador 2, pero empezamos en true pues ya asumimos que empieza el jugador 1.
        System.out.println();
        System.out.println("------Inicial el juegoooo-------");
        while(barcsJug1>0 && barcsJug2>0){//Parece un poco obvio las condicionales pero es simplemente notacion para saber que ya tenemos los barcos para iniciar el intercambio de turnos, ademas que si no se cumple esta condicion ya sabemos que alguno de los dos jugadores ya gano pues no tiene barcos.
            if(turnoJug1){
                System.out.println();
                System.out.println("Jugador 1 dispare!!");
                mostrarTabs(true);//Okay aca se ve un toque feo pero basicamente mostramos los tableros, el del jugador 1 y la vista del tablero de disparos y aciertos en el tablero enemigo, este metodo lo desarrollo más adelante.
                System.out.println();
                System.out.println("Barcos del Jugador 1: "+ contadorBarcos(tablero1));//Aca simplemente muestro cuantos barcos posee cada jugador respectivamente.
                System.out.println("Barcos del Jugador 2: "+ contadorBarcos(tablero2));

                String resultadodisp = disparar(tablero2, vistaTab1);//Vea que aca lo que hacemos es decir, si el resultado del metodo disparar es una variable resultado y cuando aplico disparo al tablero del jugador 2 este me retorna algo, que hago con eso. Que posteriormente lo que hacemos es que si impacta, juege nuevamente y si falla va el otro jugador. Esa es la importancia de los returns declarados.
                if(resultadodisp.equals("impacto")){//Aca tomamos el return impacto del metodo de disparo como si hubieramos acertado el tiro.
                    barcsJug2--;//Aca lo que hacemos es un contador de los barcos de los jugadores para ir viendo si eliminamos o no un barco rival con el metodo de disparar.
                    System.out.println();
                    System.out.println("El Jugador 1 dio en el blanco, puede repetir su turno");
                }else{
                    System.out.println();
                    System.out.println("El Jugador 1 fallo su disparo, turno del Jugador 2");//Vea que lo que ocurre aca es que simplemente le dio al agua, por lo que concluye su turno, pues si el metodo dispara no retorna impacto, retorna fallo. 
                    turnoJug1= false;//Este false lo que hace es que vayamos a el turno del jugador 2.
                }
            }else{
                System.out.println("Jugador 2 dispare!!");
                mostrarTabs(false);
                String resultadodisp = disparar(tablero1, vistaTab2);//aca es un poco mas de lo mismo disparamos al tablero del jugador 1, olvide decir que en este caso el disparar toma el tablero 1 y la vistaTab2 pues actualiza ambos arrays con cada disparo por lo que toma ambos y retorna impacto o fallo.
                if(resultadodisp.equals("impacto")){//Si impactamos restamos un barco al jugador 1.
                    barcsJug1--;
                    System.out.println();
                    System.out.println("El Jugador 2 dio en el blanco, puede repetir su turno");
                }else{
                    System.out.println();
                    System.out.println("El Jugador 2 fallo su disparo, turno del Jugador 1");
                    turnoJug1= true;//Aqui esta la importancia del boolean que declaramos pues simplificamos el proceso de turnos para que se reitere hasta que los barcos sean destruidos, ya sea del jugador uno o del jugador 2.
                }

            }
        }
        if(barcsJug1==0){//Aqui caemos cuando alguno de los barcos de los jugadores es menor o igual a cero, es decir, ya determinamos un ganador. 
            System.out.println();
            System.out.println("Pero esperen, no quedan mas barcos enm pie del jugador 1, entonces...");
            System.out.println("¡¡Felicidades Jugador 2, eres el ganador!!");
        }else{
            if(barcsJug2==0){
                System.out.println();
                System.out.println("Pero esperen, no quedan mas barcos en pie del jugador 2, entonces...");
                System.out.println("¡¡Felicidades Jugador 1, eres el ganador!!");
            }
        }
    }

    /**
     * @brief Metodo para mostrar tableros actualizados en cada turno.
     * Vea que este metodo es llamado en IniciarTurno basicamente lo que hace es declarar dos tableros, uno que representara el tablero del jugador activo en el turno y otro que representa el tablero del enemigo con base
     * en el jugador que este activo en el turno, esto evita tener que repetir este metodo para cada jugador en especifico. Vea que posterior a la declaracion de los tableros, asumimos que juega el jugador uno por medio de un if
     * y en dado caso asigamos sus tableros a los arrays declarados, para luego llamar la funcion mostrarTab y mostrar ambos tableros en consola, al utilizar un if, simplemente si no es el turno del jugador 1 va a ser el turno
     * del jugador 2 y representa el mismo proceso antes descrito. Con lo cual en cada turno se mostraran los tableros deseados. 
     * @param jug1 Note que este parametro lo que indica es cual jugador esta por observar sus tableros, si es true el jugador uno ve sus respectivos tableros y lo mismo para el jugador 2 si es false. 
     */
    public void mostrarTabs(boolean jug1){//Okay este metodo lo utilice en el de iniciar turnos, basicamente lo que hace es mostar los dos tableros, el del jugador y su enemigo.
        String[][] tablerojug;//Esta forma de mostrar lo hace por medio de dos arrays que representan los tableros por mostrar.
        String[][] vistaTabEnemigo;
        if(jug1){//
            tablerojug= tablero1;//Vea que el metodo recibe una variable booleana jug1 que indica si esta jugando el jugador 1 (true) o el jugador 2(false), esto es super util pues simplemente utlizamos los arrays establecidos de forma general en un inicio y los "sustituimos" a como se desea en cada turno.
            vistaTabEnemigo= vistaTab1;//A esto me refiero con sustituir que es basicamente establer las condiciones para el jugadodr 1(true) y las del jugador 2(false) para mostrar los tableros adecuados.
        }else{
            tablerojug= tablero2;
            vistaTabEnemigo= vistaTab2;
        }

        System.out.println();
        System.out.println("El tablero del jugador actual es:");//Ves ahora que establecimos las condiciones de los arrays "generales" y que deben de ser en cada caso(true o false), simplemente llamamos el metodo de mostrar tab para cada tablero necesario y nos mostrara los dos tableros en consola al iniciar cada turno, tambien por eso llamo este metodo en la linea 125 y 139:)
        mostrarTab(tablerojug);

        System.out.println();
        System.out.println("El tablero de los impactos y aciertos que has realizado es el siguiente");
        mostrarTab(vistaTabEnemigo);
    }

    /**
     * @brief Metodo de contar barcos:
     * Note que este metodo simplemente muestra los barcos con vida en el tablero de cada jugador, por ende, iniciamos el metodo con una variable que registre el numero de barcos de cada jugador, luego lo que hacemos
     * es que este metodo recorra todo el tablero que se establecio de parametro, que despues solo registrara la cantidad de barcos en el tablero1 o tablero2. Luego suma 1 a la variable si encuentra una casilla con un barco
     * y por ultimo cuando ya recorre todo el tablero retorna el contador de barcos.
     * @param cualquierTab este parametro basicamente representa los tableros del jugador 1 y 2 que son los que nos interesan pues este metodo registra el numero de barcos con vida de cada jugador en tiempo real.
     * @return note que el return simplemente retorna el numero de barcos en los tableros. 
     */
    //Por ultimo, me parecio adecuado hacer un metodo para contar la cantidad de barcos de cada jugador para tener mas orden en el transcurso del juego
    public int contadorBarcos(String [][] cualquierTab){
        int contaBarc= 0;
        for(int i =0; i<cualquierTab.length; i++){
            for(int j=0; j<cualquierTab.length; j++){
                if(cualquierTab[i][j].equals("■")){
                    contaBarc++;//Aca no hace falta mucha explicacion, este tipo de metodos ya los hicimos en varios quices, pero basicamente lo que hago es revisar si tengo barcos, o sea cuadritos en la matriz y que si tengo una posicion con un cuadrito le sume al contador de barcos.
                }
            }
        }
        return contaBarc;//Aca retorno el resultado paraa poder mostrarlo en la consola :)
    }
    
}//Cualquier cosa agregue los system.out.println vacios para que la interfaz de batalla naval se viera un poco mas limpia :)