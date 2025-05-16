import java.util.Scanner;
public class Ahorcado {
    private String palabraSecreta;
    private char[] progreso; //Progreso sera un array de letras, para manejarlo de manera mas eficiente
    private String letrasMalas;
    private String letrasBuenas;
    private int intentosRestantes = 6; //Intentos restantes por default

    /**
     * @brief Constructor vacio; pues los atributos son cambiados en los metodos, por lo que no es necesario definirlo.
     * 
     */

    public Ahorcado(){ 
    }

    /**
     * 
     * @brief se declaran los metodos getters, que nos permiten invocar los valores de los atributos de Ahorcado en la Interfaz.
     * Esto nos es muy util, ya que muchos metodos requieren el getPalabraSecreta por ejemplo.
     */
    public String getPalabraSecreta(){
        return palabraSecreta;
    }public String getProgreso(){
        return new String(progreso);
    }public String getLetrasMalas(){
        return letrasMalas;
    }public String getLetrasBuenas(){
        return letrasBuenas;
    }public int getIntentosRestantes(){
        return intentosRestantes;
    }

    /**
     * @brief Metodos setters; estos nos permiten modificar los valores de nuestros atributos en la clase Interfaz.
     */

    public void setPalabraSecreta(String palabraSecreta){
        this.palabraSecreta = palabraSecreta;
    }
    public void setLetrasMalas(String letrasMalas){
        this.letrasMalas = letrasMalas;
    }
    public void setLetrasBuenas(String letrasBuenas){
        this.letrasBuenas = letrasBuenas;
    }
    public void setIntentosRestantes(int intentosRestantes){
        this.intentosRestantes = intentosRestantes;
    }

  
    /**
     * @brief Se realiza el intento de ver si la letra se ha adivinado en la palabra secreta o no.
     * 
     * @param letra es el parametro de la letra que se desea adivinar, este parametro es una variable local que se utiliza en el metodo dosRondas.
     * Primero, se verifica que la palabra no haya sido ingresada.
     * Si se adivina, se actualiza letrasBuenas .
     * Si no, se actualiza letrasMalas y se resta una vez la cantidad de intentosRestantes .
     * 
     * por default, se utiliza la variable usada como falsa, y si se ha usado @return usada = true;
     * 
     */

    public boolean adivinarLetra(char letra){
        letra = Character.toLowerCase(letra); //Usamos el Character.toLowerCase para poner en minuscula una letra, la variable letra nos ayudara a ser la que el usuario ingrese en la computadora

        boolean usada = false;
        for (int i = 0; i < letrasBuenas.length(); i++){ 
            if (letrasBuenas.charAt(i) == letra) {
                usada = true;
            }
        }

        for (int i = 0; i < letrasMalas.length(); i++){ //Analogamente lo de arriba, pero con letrasMalas
            if (letrasMalas.charAt(i) == letra){
                usada = true;
            }
        }

        if (usada == true){
            System.out.println("La letra ingresada ya ha sido usada. Por favor ingrese otra letra");
            return false;
        }
        
        //A partir de aqui, vamos a comprobar que la letra esta o no en la palabra secreta, mediante un booleann

        boolean adivinar = false;
        for (int i = 0; i < palabraSecreta.length(); i++){
            if (palabraSecreta.charAt(i) == letra) { 
                progreso[i] = letra; //Guardamos la letra en el array de progreso
                adivinar = true;
            }
        }

        if(adivinar == true) {
            letrasBuenas += letra; //Agregamos la letra a letras buenas :)
        }else{
            letrasMalas += letra; //Agregamos la letra a letras malas si no la pego el jugador
            intentosRestantes --; //Descontamos un intento si no se adivino la letra
        }

        return adivinar; 

    }

    /**
     * 
     * @brief Verifica si el jugador correspondiente ha adivinado en su totalidad la palabra secreta.
     * @return false si aun en el array del progreso aun quedan espacios vacios, o sea, letras por adivinar.
     * @return true si el progreso es igual a la palabra secreta.
     */
    public boolean haGanado(){
        for (int i = 0; i < palabraSecreta.length(); i++){
            if (progreso[i] == '_'){ 
                return false;
            }
        }
        return true; 
    }

    /**
     * 
     * @brief Verifica si al jugador ya no le quedan intentos restantes.
     * @return true si al los intentos restantes del jugador respectivo son equivalentes a cero.
     * @return false si aun le quedan intentos restantes.
     */
    
    public boolean haPerdido(){
        if (intentosRestantes == 0){ 
            return true;
        }else{
            return false; 
        }
    }

    /**
     * 
     * @brief Ejecutra el juego en una mecanica de dos rondas.
     * 
     * En la primera ronda, el jugador 1 introduce la palabra secreta, y el jugador 2 le toca adivinarla,
     * En la ronda dos el proveso es en viceversa.
     * 
     * Usamos las variables auxiliares puntajeJugador1 y puntajeJugador 2 para guardar la cantidad de intentos restantes de cada jugador.
     * Si adivina la palabra, se agregan los intentos restantes a estas variables auxiliares.
     * Si no, igual se guarda el puntaje, pero equivalente a cero.
     * 
     * La gracia de estas variables es que sean comparadas en declararGanador. 
     * Tambien cabe recalcar que aqui se declara la variable letra, que es la que se guarda en el array de tipo char de progreso.
     * @param letra letra, es el parametro que se verifica en el metodo de adivinarLetra; este se llama justo despues de haber de que el usuario haya ingresado una letra.
     * Al final de las dos rondas se llama al metodo de declarar ganador, para definirlo.
     * 
     */

    public void dosRondas(){ //Se hace mediante dos rondas para que asi la logica del juego sea mas sencilla
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenidos a ahorcado. El juego consiste en dos rondas.");
        System.out.println("En la primera ronda, el jugador 1 escribe la palabra y el jugador 2 trata de adivinarla");
        System.out.println("En la segunda ronda, el jugador 2 escribe la palabra y el jugador 1 trata de adivinarla");

        int puntajeJugador1 = 0; //Vamos a hacer una mecanica de dos rondas, donde en cada ronda se va a guardar el progreso de cada jugador con estas variables auxiliares. Luego, se comparan en otro metodo, que defina al ganador con el mayor numero de intentos restantes.
        int puntajeJugador2 = 0;

        //Ronda 1
        System.out.println("Inicia la primera ronda");
        System.out.println("Jugador 1, ingrese la palabra secreta: ");
        palabraSecreta = scanner.nextLine().toLowerCase();
        progreso = new char[palabraSecreta.length()]; //Guardamos el progreso de la palagra secreta en un nuevo arrar del tipo char
        letrasBuenas = ""; // Investigue y con las comillas se reinicia el valor de la variable, esto funciona porque la logica del juego es mediante rondas. Asi para la segunda ronda se vuelve a reiniciar
        letrasMalas = "";
        intentosRestantes = 6;
        for (int i = 0; i < progreso.length; i++){
            progreso[i] = '_'; //Es necesario volver a definir el progreso, pues estamos definiendo el progreso por rondas
        }

        System.out.println("Turno del jugador 2");
        while(!haGanado() && !haPerdido()){ //Mientras que no haya adivinado ya la palabra, o no se haya quedado sin intentos restantes
            System.out.println("Progreso: " + getProgreso()); //Llamamos al array con las letras que iremos adivinando
            System.out.println("Intentos restantes: " + getIntentosRestantes()); //Ponemos cuantos intentos restantes le quedan al jugador 2
            System.out.println("Adivina una letra: ");
            char letra = scanner.nextLine().toLowerCase().charAt(0);
            adivinarLetra(letra); //Llamamos al metodo ya definido de adivinar letra
        }
        puntajeJugador1 = getIntentosRestantes(); //Guardamos los intentos restantes en la variable auxiliar de puntajeJugador 1, para luego compararla con la del jugador 2 en declararGanador
        System.out.println("Ronda 1 terminada");
        System.out.println(" ");

        //Ronda 2,repetimos todo el progreso que en la ronda 1
        System.out.println("Inicia la ronda 2");
        System.out.println(" ");
        System.out.println("Jugador 2, ingrese la palabra secreta");
        palabraSecreta = scanner.nextLine().toLowerCase();
        progreso = new char[palabraSecreta.length()];
        letrasBuenas = ""; //Volvemos a reiniciar las variables
        letrasMalas = "";
        intentosRestantes = 6;
        for (int i = 0; i < progreso.length; i++ ){
            progreso[i] = '_';
        }
        
        System.out.println("Turno del jugador 1: ");
        while(!haPerdido() && !haGanado()){
            System.out.println("Progreso: " + getProgreso());
            System.out.println("Intentos Restantes: " + getIntentosRestantes());
            System.out.println("Adivina una letra: ");
            char letra = scanner.nextLine().toLowerCase().charAt(0);
            adivinarLetra(letra);
        }
        puntajeJugador2 = getIntentosRestantes();
        System.out.println("Ronda 2 terminada");
        System.out.println(" ");

        //Comparamos los puntajes mediante el metodo de declararGanador
        declararGanador(puntajeJugador1, puntajeJugador2);
        scanner.close();
    }
    
    /**
     * @brief Se verifica cual de los dos jugadores tuvo mejor rendimiento en su respectiva ronda
     * Se utilizan las variables auxiliares de dosRondas para compararlas y definir al ganador:
     * @param puntajeJugador1
     * @param puntajeJugador2
     * El jugador que tenga un puntaje mayor (Mayor cantidad de intentos restantes) se define como el ganador.
     * En el caso en que ambos tengan un puntaje equivalente, se declara un empate.
     */
    
    public void declararGanador(int puntajeJugador1, int puntajeJugador2){
        System.out.println("==== GANADOR ====");
        if(puntajeJugador1 > puntajeJugador2){
            System.out.println("El ganador es el jugador 1! con " + puntajeJugador1 + ", felicidades!");
        }else if(puntajeJugador2 > puntajeJugador1){
            System.out.println("El ganador es el jugador 2! con " + puntajeJugador2 + ", felicidades!");
        }else{
            System.out.println("Empate! no hay ganador! Ambos quedaron con " + puntajeJugador1 + " puntos restantes!");
        }
    }
}