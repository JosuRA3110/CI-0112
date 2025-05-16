import java.util.Scanner;
public class Interfaz{
    
    /**
     * @brief se declara el booleano jugar, que nos permite crear el ciclo que se cierra unicamente cuando el usuario ya no quiere jugar.
     * el usuario decide que jugar mediante el scanner.
     * si marca 1, se instancia un objeto de BatallaNaval, y se llama al metodo de jugar la batalla naval.
     * si marca 2, se llama al metodo de dosRondas de Ahorcado, e inicia el juego.
     * si marca 3 termina el programa.
     * 
     * Luego de jugar algun juego, se le pregunta al usuario si quiere volver a jugar.
     * si marca 1, se vuelve a la interfaz inicial.
     * si marca 2, se cierra el programa.
     */
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean jugar = true;

        
        while(jugar == true){
            System.out.println("------------------------");
            System.out.println("BIENVENIDO A LA INTERFAZ");
            System.out.println("------------------------");
            System.out.println("Con cual juego desea empezar?");
            System.out.println("------------------------");
            System.out.println("1 - Batalla Naval");
            System.out.println("2 - Ahorcado");
            System.out.println("3- Salir");
            int opcion = scanner.nextInt();


            if (opcion == 1){
                System.out.println("Iniciando Batalla Naval...");
                BatallaNaval jugarBatallaNav = new BatallaNaval();
                jugarBatallaNav.jugarBatallaNaval();
            }else if (opcion == 2){
                System.out.println("Iniciando Ahorcado");
                Ahorcado jugarAhorcado = new Ahorcado();
                jugarAhorcado.dosRondas();
            }else if (opcion == 3){
                System.out.println("Muchas gracias por participar!");
                jugar = false;
            }else{
                System.out.println("Por favor, digite una opcion valida :)");
            }
        
        if(jugar == true){
            System.out.println(" ");
            System.out.println("Desea volver a jugar?");
            System.out.println("1-Si");
            System.out.println(" ");
            System.out.println("2-No");
            int r = scanner.nextInt();

            if (r == 1){
                jugar = true;
            }else if(r == 2){
                jugar = false;
                System.out.println("Muchas gracias por participar!");
            }else{
                System.out.println("Por favor, digite una opcion valida :)");
            }

            }
    }
    scanner.close();
}
}