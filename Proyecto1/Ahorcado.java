import java.util.Scanner;

public class Ahorcado {
    private String palabraSecreta;
    private char[] progreso; //Progreso sera un array de letras, para manejarlo de manera mas eficiente
    private String letrasMalas;
    private String letrasBuenas;
    private int intentosRestantes = 6; //Intentos restantes por default


    public Ahorcado(){ //Constructor vacio, pues los parametros que se definan aca van a ser alterados en el metodo dosRondas, por ende es mejor dejar el constructor vacio
    }
  

    //Gettersss
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

    //Settersss

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

    //Metodos para que el juego funcione

    public boolean adivinarLetra(char letra){
        letra = Character.toLowerCase(letra); //Usamos el Character.toLowerCase para poner en minuscula una letra, la variable letra nos ayudara a ser la que el usuario ingrese en la computadora

        boolean usada = false;
        for (int i = 0; i < letrasBuenas.length(); i++){ //buscamos si la letra usada ya esta en letrasBuenas
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
        

        //Ahora vamos a comprobar que la letra esta o no en la palabra secreta, mediante un booleann

        boolean adivinar = false;
        for (int i = 0; i < palabraSecreta.length(); i++){
            if (palabraSecreta.charAt(i) == letra) { //aqui es donde se verifica si la letra se encuentra en la palabra secreta
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

        return adivinar; //Para que el proceso nos retorne la variable adivinada.

    }

    public boolean haGanado(){
        for (int i = 0; i < palabraSecreta.length(); i++){ //Recorre cada letra de palabraSecreta
            if (progreso[i] == '_'){ //Si aun quedan lineas vacias, o sea, letras sin adivinar
                return false; //Se dice directamente que el haGanado es falso. 
            }
        }
        return true; //Si no, se hace verdadero el ha ganado
    }

    public boolean haPerdido(){
        if (intentosRestantes == 0){ //Si directamente un jugador se queda sin chances
            return true;
        }else{
            return false; //Si no, no ha perdido
        }
    }

    
    
    public void dosRondas(){ //Se hace mediante dos rondas para que asi la logica del juego sea mas sencilla
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenidos a ahorcado. El juego consiste en dos rondas.");
        System.out.println(" ");
        System.out.println("En la primera ronda, el jugador 1 escribe la palabra y el jugador 2 trata de adivinarla");
        System.out.println(" ");
        System.out.println("En la segunda ronda, el jugador 2 escribe la palabra y el jugador 1 trata de adivinarla");
        System.out.println(" ");
        System.out.println("Gana el jugador con mas intentos restantes al haber adivinado la palabra");
        System.out.println(" ");
        System.out.println("Si ambos no la logran adivinar, es un empate");
        System.out.println(" ");

        int puntajeJugador1 = 0;
        int puntajeJugador2 = 0;

        //Ronda 1
        System.out.println("Inicia la primera ronda");
        System.out.println(" ");
        System.out.println("Jugador 1, ingrese la palabra secreta: ");
        palabraSecreta = scanner.nextLine().toLowerCase();
        progreso = new char[palabraSecreta.length()]; //Guardamos el progreso de la palagra secreta en un nuevo arrar del tipo char
        letrasBuenas = ""; // Investigue y con las comillas se reinicia el valor de la variable, esto funciona porque la logica del juego es mediante rondas. Asi para la segunda ronda se vuelve a reiniciar
        letrasMalas = "";
        intentosRestantes = 6;
        for (int i = 0; i < progreso.length; i++){
            progreso[i] = '_'; //Es necesario volver a definir el progreso, pues estamos definiendo el progreso por rondas
        }

        System.out.println(" ");
        System.out.println("Turno del jugador 2");
        System.out.println(" ");
        while(!haGanado() && !haPerdido()){ //Mientras que no haya adivinado ya la palabra, o no se haya quedado sin intentos restantes
            System.out.println("Progreso: " + getProgreso()); //Llamamos al array con las letras que iremos adivinando
            System.out.println(" ");
            System.out.println("Intentos restantes: " + getIntentosRestantes()); //Ponemos cuantos intentos restantes le quedan al jugador 2
            System.out.println(" ");
            System.out.println("Adivina una letra: ");
            System.out.println(" ");
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

        System.out.println(" ");
        System.out.println("Turno del jugador 1: ");
        System.out.println(" ");
        while(!haPerdido() && !haGanado()){
            System.out.println("Progreso: " + getProgreso());
            System.out.println(" ");
            System.out.println("Intentos Restantes: " + getIntentosRestantes());
            System.out.println(" ");
            System.out.println("Adivina una letra: ");
            System.out.println(" ");
            char letra = scanner.nextLine().toLowerCase().charAt(0);
            adivinarLetra(letra);
        }
        puntajeJugador2 = getIntentosRestantes();
        System.out.println(" ");
        System.out.println("Ronda 2 terminada");
        System.out.println(" ");

        //Comparamos los puntajes mediante el metodo de declararGanador
        declararGanador(puntajeJugador1, puntajeJugador2);
    }
    
    public void declararGanador(int puntajeJugador1, int puntajeJugador2){
        System.out.println("==== GANADOR ====");
        if(puntajeJugador1 > puntajeJugador2){
            System.out.println(" ");
            System.out.println("El ganador es el jugador 1! con " + puntajeJugador1 + " intentos restantes, felicidades!");
        }else if(puntajeJugador2 > puntajeJugador1){
            System.out.println(" ");
            System.out.println("El ganador es el jugador 2! con " + puntajeJugador2 + " intentos restantes, felicidades!");
        }else{
            System.out.println(" ");
            System.out.println("Empate! no hay ganador! Ambos quedaron con " + puntajeJugador1 + " puntos restantes!");
        }
    }
}