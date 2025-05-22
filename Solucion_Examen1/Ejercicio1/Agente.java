//Clase Agente

public class Agente {

    private int id;

    public Agente(int id){
        this.id = id;
    }
    //Getters
    public int getId(){
        return id;
    }

    //Metodos solicitados:
    //Metodo para crear y enviar mensajes a la cola:
    public void enviarMensajeAg(ColaDeMensaje cola, int idAgenteFuente, int idAgenteDestinatario, String contenido){
        Mensaje mensajeAgente = new Mensaje(idAgenteFuente, id, idAgenteDestinatario, contenido);
        cola.agregarMensajeCola(mensajeAgente);
    }

    //Metodo para recibir un mensaje, en dado caso que coincida el id
    public void recibirMensajeAg(ColaDeMensaje colax){
        if(colax.existeMensaje()){
            int idSiguente = colax.verIdSiguienteAgenteDestinatario();
            if(idSiguente == this.id){
                Mensaje mensajeExtraido = colax.extraerMensaje();
                System.out.println("El Agente con el id: "+ id + " recibio el mensaje");
                System.out.println("Las caracteristicas del mensaje son: ");
                System.out.println("Fuente: "+ mensajeExtraido.getIdAgenteFuente());
                System.out.println("Emisor: "+ mensajeExtraido.getIdAgenteEmisor());
                System.out.println("Contenido: "+ mensajeExtraido.getContenido());
            } else{
                System.out.println("El Agente "+ id + " no puede leer el mensaje, su id no coinside");
            }
        } else {
            System.out.println("No hay mensajes disponibles en la cola");
        }
    }
}