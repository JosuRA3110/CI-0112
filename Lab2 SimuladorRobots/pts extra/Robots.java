//Robots
public class Robots{

    //Atributos
    private String nombre;
    private int puntosVida;
    private int ataque;
    private int defensa;

    //Metodo Constructor
    public Robots(String nombre, int puntosVida, int ataque, int defensa){
        this.nombre= nombre;
        this.puntosVida= puntosVida;
        this.ataque= ataque;
        this.defensa = defensa;
    }

    //Getters
    public String getNombre(){
        return nombre;
    }
    public int getPuntosVida(){
        return puntosVida;
    }
    public int getAtaque(){
        return ataque;
    }
    public int getDefensa(){
        return defensa;
    }

    //Setters
    public void setNombre(String nombre){
        this.nombre= nombre;
    }
    public void setPuntosVida(int puntosVida){
        this.puntosVida= puntosVida;
    }
    public void setAtaque(int ataque){
        this.ataque= ataque;
    }
    public void setDefensa(int defensa){
        this.defensa= defensa;
    }

    //Metodos solicitados
    public void atacar(Robots otroRobot){//Note que aca ya estamos suponiendo que existen dos objetos que son los robots que estaran activos para el encuentro por realizar//
        if (ataque>=10 && ataque<=20){
            int dañoActu = this.ataque - otroRobot.getDefensa();//Aca implemento la defensa como un atributo que reduce el daño de los enemigos, para seguir la logica, si la defensa del robot es mayor que el ataque recibido inmediatamente no recibe daño pues tampoco tendria logica que lo cure con daño negativo.
            if(dañoActu<0){
                dañoActu =0;
            }
            otroRobot.puntosVida-= dañoActu;
            System.out.println(this.nombre + " ha realizado el ataque al robot "+ otroRobot.nombre + " los puntos de vida restantes de "+ otroRobot.nombre + " son de "+ otroRobot.puntosVida);
        }else{
            System.out.println("Digite nuevamente el ataque de "+ this.nombre + " recuerde que debe de ser un numero entre 10 y 20 :)");
        }
    }//*Okay, para este punto solo atacamos entre los robots pero no sabemos si siguen vivos, es decir tienen puntos de vida, incluire una verificacion de ello, como se solicita en las indicaciones*/
    
    public boolean estaVivo(){//Note que esta funcion facilitara el verificar si los robots estan vivos o fueron destruidos para la clase juegosdebatalla, pues ya sabremos cuando un robot sigue con vida (si es true) o si fue destruido (si el boolean es falso)//
        return this.puntosVida > 0;
    }
}