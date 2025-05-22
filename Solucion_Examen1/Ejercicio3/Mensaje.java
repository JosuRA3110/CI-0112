//Clase Mensajes

public class Mensaje {

    private int idAgenteFuente;
    private int idAgenteEmisor;
    private int idAgenteDestinatario;
    private String contenido;

    //Hacemos el metodo constructor que define lo que tendra cada objeto de la clase mensaje. Es decir lo que tendran los mensajes y sus parametros esperados.
    public Mensaje(int idAgenteFuente, int idAgenteEmisor, int idAgenteDestinatario, String contenido){
        this.idAgenteFuente = idAgenteFuente;
        this.idAgenteEmisor = idAgenteEmisor;
        this.idAgenteDestinatario = idAgenteDestinatario;
        this.contenido = contenido;
    }

    //Getters, vea que no requerimos de setters pues unicamente crearemos nuevos mensajes no necesitaremos modificarlos como tal, por lo que los hacemos sin setters para no cambiarlos en las siguientes clases.

    public String getContenido(){
        return contenido;
    }

    public int getIdAgenteDestinatario(){
        return idAgenteDestinatario;
    }

    public int getIdAgenteEmisor(){
        return idAgenteEmisor;
    }

    public int getIdAgenteFuente(){
        return idAgenteFuente;
    }

}