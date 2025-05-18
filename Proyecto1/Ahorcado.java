public class Ahorcado{
    private String palabraSecreta;
    private char[] progreso;
    private String letrasBuenas;
    private String letrasMalas;
    private int intentosRestantes;


    /**
     * @brief Constructor vacio, pues las variables del mismo son cambiadas en la clase del ControladorAhorcado.
     */
    public Ahorcado(){
    }

    //Getters
    public String getProgreso(){
        return new String(progreso);
    }
    public String getLetrasBuenas(){
        return letrasBuenas;
    }
    public String getLetrasMalas(){
        return letrasMalas;
    }
    public int getIntentosRestantes(){
        return intentosRestantes;
    }


    /**
     * @brief Iniciamos todas las variables en valores vacios
     * @param palabraSecreta se convierte a minuscula con toLowerCase
     * los intentosRestantes se igualan a 6 por indicaciones del ejercicio.
     * se agrega un ciclo for para que el progreso contenta guiones bajos.
     */
    public void iniciarJuego(String palabraSecreta){
        this.palabraSecreta = palabraSecreta.toLowerCase();
        this.progreso = new char[palabraSecreta.length()];
        this.letrasBuenas = "";
        this.letrasMalas = "";
        this.intentosRestantes = 6;

        for(int i = 0; i < progreso.length; i++){
            progreso[i] = '_';
        }
    }

    /**
     * @brief Se verifica que primero @param letra no haya sido ingresada. 
     * Luego se verifica si @param letra se encuentra en palabra secreta
     * Se utiliza un palabraSecreta.charAt(i) para definir la posicion de la letra i en esta variable
     */
    public boolean adivinarLetra(char letra){
        letra = Character.toLowerCase(letra);
        if(letrasBuenas.indexOf(letra) >= 0 || letrasMalas.indexOf(letra)>= 0 ){
            System.out.println("Por favor ingrese otra letra. Esta ya ha sido usada");
            return false;
        }
        boolean acertado = false; 
        for(int i = 0; i < palabraSecreta.length(); i++){
            if(palabraSecreta.charAt(i) == letra){
                progreso[i] = letra;
                acertado = true;
            }
        }
        if (acertado){
            letrasBuenas += letra;
        }else if(!acertado && intentosRestantes > 0){
            letrasMalas += letra;
            intentosRestantes--;
        }
        return acertado;
    }

    /**
     * @brief Se verifica que la palabra secreta haya sido descubierta en su totalidad.
     * @return false si aun quedan espacios vacios (letras por adivinar restantes).
     * @return true si ya se adivino la palabra secreta.
     */
    public boolean haGanado(){
        for (char c : progreso){ //Ciclo for mejorado
            if (c == '_'){
                return false;
            }
        }return true;
    }

    /**
     * @return true si se queda sin intentos restantes.
     */
    public boolean haPerdido(){
        return intentosRestantes == 0;
    }
}