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
        for (int i = 0; i < palabraSecreta.length; i++){
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
        for (int i = 0; i < palabraSecreta.length; i++){ //Recorre cada letra de palabraSecreta
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
        System.out.println("En la primera ronda, el jugador 1 escribe la palabra y el jugador 2 trata de adivinarla");
        System.out.println("En la segunda ronda, el jugador 2 escribe la palabra y el jugador 1 trata de adivinarla");

        
        int puntajeJugador1 = 0; //Vamos a hacer una mecanica de dos rondas, donde en cada ronda se va a guardar el progreso de cada jugador con estas variables auxiliares. Luego, se comparan en otro metodo, que defina al ganador con el mayor numero de intentos restantes.
        int puntajeJugador2 = 0;
    }
    
}