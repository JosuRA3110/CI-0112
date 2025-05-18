import java.util.Scanner;
public class ControladorAhorcado{
    private JugadorAhorcado jugador1;
    private JugadorAhorcado jugador2;
    private Ahorcado juego;
    private Scanner scanner; 



    /**
     * @brief El constructor consta del nombre de los jugadores, la variable scanner y la instancia de la clase Ahorcado, para llamar a sus metodos.
     * @param nombreJ1 es el nombre que se le pone al jugador1
     * Analogamente con @param nombreJ2.
     * @param scanner para llamar a Scanner.
     */
    public ControladorAhorcado(String nombreJ1, String nombreJ2, Scanner scanner){
        this.jugador1 = new JugadorAhorcado(nombreJ1);
        this.jugador2 = new JugadorAhorcado(nombreJ2);
        this.juego = new Ahorcado();
        this.scanner = scanner;
    }

    /**
     * @brief se aplica la mecanica de las dos rondas para cada jugador con la logica de que gana el jugador con mas intentos restantes.
     * Se guarda el puntaje en el int de J1 y J2.
     */
    public void  jugar(){
        System.out.println(" ");
        System.out.println("Bienvenidos a ahorcado. El juego consiste en dos rondas.");
        System.out.println(" ");
        System.out.println("En la primera ronda, " + jugador2.getNombre() + " debe de adivinar la palabra secreta");
        System.out.println(" ");
        System.out.println("En la segunda ronda, " + jugador1.getNombre() + " debe de adivinar la palabra secreta");
        System.out.println(" ");
        System.out.println("Gana el jugador con mas intentos restantes al haber adivinado la palabra secreta");
        System.out.println(" ");
        System.out.println("Si ambos jugadores tienen la misma cantidad de intentos restantes es un empate");
        System.out.println(" ");

        int puntajeJ1 = jugarRonda(jugador1, jugador2);
        int puntajeJ2 = jugarRonda(jugador2, jugador1);

        declararGanador(puntajeJ1, puntajeJ2);
    }

    /**
     * @brief Aqui se juega la ronda.
     * @param jugadorPalabra es J1 en la primera ronda, y J2 en la segunda (Los que ingresan la palabra secreta).
     * @param jugadorAdivina es J2 en la primera ronda, y J2 en la segunda (Los que les toca adivinar la palabra secreta).
     * los intentos restantes definen al ganador en el siguiente metodo.
     */
    public int jugarRonda(JugadorAhorcado jugadorPalabra, JugadorAhorcado jugadorAdivina){
        System.out.println("Inicia la ronda:");
        System.out.println(" ");

        System.out.println(jugadorPalabra.getNombre() + ", ingrese la palabra secreta:");
        String palabra = scanner.nextLine().trim().toLowerCase();

        juego.iniciarJuego(palabra); //Se reinician las variables que definimos en la clase Ahorcado.
        System.out.println(" ");
        System.out.println("Turno de " + jugadorAdivina.getNombre());

        while (!juego.haGanado() && !juego.haPerdido()) {
            System.out.println("Progreso: " + juego.getProgreso());
            System.out.println("Intentos restantes: " + juego.getIntentosRestantes());
            System.out.print("Adivina una letra: ");

            String entrada = scanner.nextLine().toLowerCase().trim();
            if (entrada.isEmpty()) { //Si el usuario no agrega nada en consola.
                System.out.println("Debe ingresar una letra.");
                continue; //Se repite el ciclo 
            }

            char letra = entrada.charAt(0);
            juego.adivinarLetra(letra);
        }

        System.out.println("Ronda terminada.");
        return juego.getIntentosRestantes();
    }

    /**
     * @brief Se declara quien es el ganador mediante los parametros. Se comparan con condicionales y el mayor gana.
     * @param puntajeJ1
     * @param puntajeJ2
     * 
     * Si son iguales se declara un empate.
     */
    public void declararGanador(int puntajeJ1, int puntajeJ2){
        System.out.println(" ");
        System.out.println("PUNTAJE FINAL");
        System.out.println("El puntaje de " + jugador1.getNombre() + " es de: " + puntajeJ1 + " puntos.");
        System.out.println("El puntaje de " + jugador2.getNombre() + " es de: " + puntajeJ2 + " puntos.");

         if (puntajeJ1 > puntajeJ2) {
            System.out.println("El ganador es " + jugador1.getNombre() + "! Felicidades!");
        } else if (puntajeJ2 > puntajeJ1) {
            System.out.println("El ganador es " + jugador2.getNombre() + "! Felicidades!");
        } else {
            System.out.println("Empate! No hay ganador.");
        }
    }
}