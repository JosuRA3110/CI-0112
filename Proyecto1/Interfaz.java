import java.util.Scanner;
public class Interfaz{
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