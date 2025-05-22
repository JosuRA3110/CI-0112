//Clase ColadDeMensaje

public class ColaDeMensaje{
    private Mensaje[] mensajes; 
    private int cantidad;

    public ColaDeMensaje(){
        mensajes = new Mensaje[50];//Aca el enunciado no comenta nada sobre el tamaño del array, entonces por cuestiones de facilidad simplemente lo establesco en 50 pues no dice nada de un arreglo que se "expanda" conforme agragamos mensajes, por cualquier cosa :)
        cantidad = 0;
    }

    //Metodo para agregar un mensaje, convocado por los agentes. 
    public void agregarMensajeCola(Mensaje mensajex){
        if(cantidad < mensajes.length){
            mensajes[cantidad] = mensajex;
            cantidad++;
        } else {
            System.out.println("Lo lamento cola llena no puede agregar más mensajes");
        }
    }

    public boolean existeMensaje(){
        if(cantidad>0){
            return true;
        } else {
            return false;
        }
    }

    public int verIdSiguienteAgenteDestinatario(){
        if(existeMensaje()){
            return mensajes[0].getIdAgenteDestinatario();//Vea que aca vemos el indice 0 pues estamos en un sistema donde tomamos la primera entrada y la primera salida.
        }
        return -1; //Esta es una notacion basica, es cuando no se cumple una condicional, pero recuerde que este metodo es int, por lo que no podemos devolver null. Para representarlo utilizamos el -1
    }

    public Mensaje extraerMensaje(){
        if(existeMensaje()== false){
            return null;
        }
        Mensaje primerMensaje = mensajes[0];
        for(int i= 1; i<cantidad; i++){
            mensajes[i-1]= mensajes[i];//Vea que como ya sacamos el primer mensaje tenemos que acomodar el arreglo para no dejar vacia la posicion 0, los desplazamos hacia la izquierda basicamente. 
        }
        mensajes[cantidad-1] = null; //Aca representamos que sacamos un mensaje al dejar la posicion nula y lista para recibir los mensajes que viene "desde la izquierda"
        cantidad--;//Vea que quitamos un mensaje del array, entonces disminuimos su tamaño.
        return primerMensaje; //Aca retornamos el mensaje para el agente que deseamos.
    }

    public int cantidadMensajes(){//Aca por cuestiones de orden simplemente contamos la cantidad de mensajes. 
        return cantidad; 
    }
}