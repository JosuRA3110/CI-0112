//Juego de Batalla
import java.util.Scanner;
import java.util.Random;//En este caso estamos implementando la clase Random para que se seleccione un numero aleatorio del 1 al 10 y que los robots puedan atacarse entre si de forma randomizada tal y como se solicita.


public class JuegoBatalla{

//Atributos del arreglo
private Robots[] robots; //Note que aca declaramos el arrey donde estaran los objetos, robots en este caso.
private Random random; //Declaramos la variable random para usarla mas adelante. 

//Metodo para iniciar la batalla:
public void iniciarBatalla(){//Ojo aca cantRobots es la cantidad de robots que recibiremos de parte del usuario para realizar la batalla. 

    Scanner scanner = new Scanner(System.in);
    random = new Random();//Note que aca creamos un objeto "random" donde podremos generar numeros aleatorios para que las batallas sean al azar entre los diferentes robots :)
    System.out.println("Bienvenido al menu de batalla robotica");
    System.out.println("-------------------------------------------");
    System.out.println("Ingrese la cantidad de robots que participaran, recuerde que deben de ser entre 2 a 10");
    int cantRobots = scanner.nextInt();
    scanner.nextLine(); //*Aca póngo este nextline para que no se bugue la solicitud de informacion en consola y lograr mantener el orden */
    
    if(cantRobots<2 || cantRobots>10){
        System.out.println("Debe de ingresar de 2 a 10 robots para empezar la batalla.");
        return;//Note que este return lo que hace es que corta la simulacion, esto para que no continue solictando datos pues no se puede pelear con solo un robot o mas de 10.
    }

    robots = new Robots[cantRobots];//Observe que aqui lo que realizamos es delimitaar el arrey con respecto a la info que nos da el usuario y guardaremos los robots creados.

    //Ahora solicitamos los datos necesarios para los robots:
    
    for(int i=0; i<cantRobots; i++){
        System.out.println("Por favor ingrese el nombre del robot "+ (i + 1));
        String nombre = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Por favor ingrese los puntos de vida del robot "+ (i + 1)+ "(deben de estar entre 50 y 100)");
        int puntosVida = scanner.nextInt();
        scanner.nextLine();
        if(puntosVida<50 || puntosVida>100){
            System.out.println("Debe de ingresar de 50 a 100 puntos de vida para empezar la batalla.");
            return;
        }

        System.out.println("Por favor ingrese el ataque del robot "+ (i + 1) +" (debe de estar entre 10 y 20)");
        int ataque = scanner.nextInt();
        scanner.nextLine();
        if(ataque<10 || ataque>20){
            System.out.println("Debe de ingresar de 10 a 20 de ataque para empezar la batalla.");
            return;
        }

        robots[i] = new Robots(nombre, puntosVida, ataque);//Para este punto ya el usuario nos dio todos los datos que necesitamos con los parametros adecuados, entonces nada mas los asignamos a los respectivos robots del arrey.
        System.out.println("Su robot "+ nombre + " fue creado con exito,tiene los siguientes atributos: ");
        System.out.println("Puntos de vida de "+ nombre + ": "+ puntosVida);
        System.out.println("Ataque de "+ nombre+ ": "+ ataque);
    }
    System.out.println("¡¡Todos listos, empecemos los combates!!");
    
    /*Con todos los robot creados ahora me centrare en las batallas*/
    //Batalla en bucle hasta que un solo robot quede con vida: Ojo todos los metodos utilizados en el bucle se presentan posterior a el while de la batalla.
    while(robotsVivos()>1){/*Note que aca implementamo un metodo que cuenta cuantos robots siguen con vida, con el objetivo de poder realizar los ataques necesarios para encontrar un ganador en la batalla robotica. */
        for(int i=0; i<robots.length; i++){
            if(robots[i] != null && robots[i].estaVivo()){/*Aca simplmente verificamos que el robot seleccionado se encuentre con vida para poder encontrar otro robot diferente al cual atacar */
                Robots robotRandom = robotAlAzar(i);/*En este caso el robotRandom es el robot encontrado por la funcion robotAlAzar en el indice i que sigue con vida, tal que si no es null va a ser atacado */
                if(robotRandom != null){
                    robots[i].atacar(robotRandom);
                }
            }
        }
        System.out.println("-----------------------------------");
        System.out.println("Iniciara una nueva ronda de combate");
        System.out.println("-----------------------------------");
    }
    mostrarGanador();/*Aqui mostramos al ganador despues de que el while diera fin, es decir no se encontrara
    otro robot de forma aleatoria el cual atacar */
    }

    //Metodo para contar cuantos robots se encuentran con vida :)
    private int robotsVivos(){
        int contRobots = 0;
        for(Robots robot : robots){//Aca recorremos todo el arreglo para verificar el estado de cada uno de los robots creados, con el fin de ver cuales estan con vida para considerarse en batalla.
            if (robot != null && robot.estaVivo()){
                contRobots++;//Aqui consideramos que el robot estaVivo y aumentamos el contador de robots vivos.
            }
        }
        return contRobots;//Con esto brindamos el dato de cuantos robots se encuentran con vida para poder continuar la batalla. 
    }

    //Metodo para seleccionar contrincantes robots de manera aleatoria, cosa más terribe T_T
    private Robots robotAlAzar(int i){//Aca como en la linea 14 ya instanciamos un random podemos utilizarlo con normalidad.
        int robotRandomIndice = random.nextInt(robots.length); //Aca estamos generando un indice aleatorio para buscar un robot al azar dentro del arrey.

        /*Importante, este while nos ayuda para saber si el robot aleatorio es el mismo, caso donde es igual a i. 
         * Si el robot ya esta muerto o tiene un espacio null. Basicamente el while colabora para evitar que al atacar ocurra un erro
         * por inexistencia del robot. :)
         */
        while(robotRandomIndice == i || robots[robotRandomIndice] == null || !robots[robotRandomIndice].estaVivo()){
            robotRandomIndice = random.nextInt(robots.length); //Aqui ya evitamos lo anterior por ende nos da un robot con vida y distinto al que ataca.
        }
        return robots[robotRandomIndice];//Y aqui ya devolvemos el robot aleatorio valido para realizar el ataque, al fin T_T
    }

    //Metodo para mostrar el ultimo robot en pie, es decir, el ganador.
    private void mostrarGanador(){
        for(Robots robot: robots){//Nuevamente recorremos todo el arrey y vemos los robots uno a uno.
            if(robot.estaVivo() && robot !=null){//Vemos cual de los robots queda con vida, es decir, es el ganador, pues este metodo es despues del while de batalla.
                System.out.println("El ultimo robot en pie es......"+ robot.getNombre());/*Por ultimo obtenemos el nombre del robot encontrado con vida por el getNombre y con el return finalizamos la simulacion. */
                System.out.println("----------Felicidades:)--------------");
                return;
            }
        }
    }

    //Por ulitmo, el main:
    public static void main(String[] args) {
        JuegoBatalla juego = new JuegoBatalla(); //Simplemente intanciamos el objeto juego de esta clase.
        juego.iniciarBatalla();//E iniciamos la batalla yyyy listooo :)
    }
}

