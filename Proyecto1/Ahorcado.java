import java.util.Scanner;

public class Ahorcado {
    private String palabraSecreta;
    private char[] progreso; //Progreso sera un array de letras, para manejarlo de manera mas eficiente
    private String letrasMalas;
    private String letrasBuenas;
    private int intentosRestantes = 6; //Intentos restantes por default


    public Ahorcado(String palabraSecreta, String letrasMalas, String letrasBuenas, int intentosRestantes) { //Constructorcillo
        this.palabraSecreta = palabraSecreta;
        this.letrasMalas = letrasMalas;
        this.letrasBuenas = letrasBuenas;
        this.intentosRestantes = intentosRestantes;
        this.progreso = new char[palabraSecreta.length()]; //Aqui definimos la longitud de progreso, que sera la longitud de la palabra secreta ingresada por el usuario mismo.
        for (int i = 0; i < progreso.length; i++){
            progreso[i] = '_'; 
        }
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
    }
}