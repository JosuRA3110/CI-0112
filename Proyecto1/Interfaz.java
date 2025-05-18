import java.util.Scanner;
public class Interfaz{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean jugar = true;

        while(jugar){
            System.out.println("------------------------");
            System.out.println("BIENVENIDO A LA INTERFAZ");
            System.out.println("------------------------");
            System.out.println("Con cual juego desea empezar?");
            System.out.println("------------------------");
            System.out.println("1 - Batalla Naval");
            System.out.println("2 - Ahorcado");
            System.out.println("3- Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();


            if (opcion == 1){
                System.out.println("Iniciando Batalla Naval...");
            }else if (opcion == 2){
                System.out.println("Iniciando Ahorcado");
                
                System.out.println("Nombre del jugador 1: ");
                String nombre1 = scanner.nextLine();

                System.out.println("Nombre del jugador 2: ");
                String nombre2 = scanner.nextLine();


                ControladorAhorcado controlador = new ControladorAhorcado(nombre1, nombre2, scanner);
                controlador.jugar();

                
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