public class JugadorAhorcado{
    private String nombre;


    /**
     * @brief el constructor contiene unicamente:
     * @param nombre , que mas adelante sera utilizado para definir el nombre del jugador1, y el jugador 2.
     */

    public JugadorAhorcado(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }
}