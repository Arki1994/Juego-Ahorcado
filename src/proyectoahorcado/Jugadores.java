/**
 * En esta clase manejamos los jugadores del juego, contiene un array que guardará los jugadores que futuramente introduciremos.
 * Tambien tenemos los diferentes metodos que necesitaremos para ejecutar el ahorcado: reset(), partida(), fallosMaximos() y devuelveAciertos().
 */
package proyectoahorcado;

/**
 *
 * @author Arkaitz
 */
public class Jugadores {
    /**
     * Creamos un objeto de la clase Palabras para poder llamar a sus distintos métodos.
     */
    Palabras p=new Palabras();
    
    /**
     * Fichero tde uso temporal que utilizo para visualizar la palabra secreta.
     */
    public void temporal () {
        System.out.println(p.getPalabraSecreta());
    }
    /**
     * Declaramos un array de la clase Jugador llamado jugadores
     */
    private Jugador jugadores[];
    
    /**
     * Creamos una variable String que utilizaremos mas adelante.
     */
    private String jugadorVencedor;
    
    /**
     * Inicializamos el array jugadores segun el número que introducimos (lo pasamos por parámetro) llamando al contructor de la clase Jugador.
     * @param n 
     */
    Jugadores(int n) {
        jugadores=new Jugador[n];
        for (int i=0; i<jugadores.length; i++) {
            jugadores[i]=new Jugador();
        }
    }
    
    /**
     * Este metodo reinicia la partida, llamaremos al metodo inicio de la clase Jugador.
     */
    public void restart() {
        //Creamos una nueva palabraSecreta
        p.nuevaPalabra();
        for (int x=0; x<jugadores.length; x++) {
            jugadores[x].inicio(p.getPalabraSecreta());
        }
    }
    
    /**
     * Desde este metodo llamaremos al metodo juega de la clase jugador para poder empezar las jugadas de cada jugador
     */
    public void partida() {
        for (int x=0; x<jugadores.length; x++) {
            jugadores[x].juega(p.getPalabraSecreta());
        }
        //Comprobamos que si uno de los jugadores o varios llegan a tener un acierto este se visualice.
        for (int y=0; y<jugadores.length; y++) {
            if (jugadores[y].getAciertos()==1) {
                System.out.println("HA GANADO: " + jugadores[y].getNombre());
            }
        }
    }
    
    /**
     * En este método controlaremos lo fallos de cada jugador, si los fallos de un jugador llegan a 5 el contador se sumará.
     * Si cont es menor a el numero de jugadores devolvera true.
     * Este metodo lo usaremos en la clase principal como condición de un while.
     * @return 
     */
    public boolean fallosMaximos(){
        int cont = 0;
        for (int i=0; i<jugadores.length; i++) {
            if (jugadores[i].getFallos()==5) {
                cont++;
            }
        }
        if (cont < jugadores.length){
            return false;
        }
        return true;
    }
    
    /**
     * Este método es un booleano donde controlaremos los aciertos, en caso de que haya un acierto devilverá true, este método lo usaremos en la
     * clase principal como una condicion de un while junto al metodo fallosMaximos.
     * @return 
     */
    public boolean devuelveAciertos() { 
        for (int i=0; i<jugadores.length; i++) {
            if (jugadores[i].getAciertos()==1) {
                return true;
            }
        }
        return false;
    }    
    
    /**
     * Este método devuelve un entero con el numero de partidas maximas que ha ganado un jugador en la partida.
     * @return 
     */
    public int mejoresJugadas() {
        int jugada = 0;
        for(int i=0; i<jugadores.length; i++) {
            if(jugada<jugadores[i].getPartidaGanada()) {
                jugada=jugadores[i].getPartidaGanada();
                jugadorVencedor=jugadores[i].getNombre();
            }
        }
        return jugada;        
    }
    
    /**
     * Este méto devolverá el nombre del jugador con mas rondas ganadas de la partida.
     * @param numero
     * @return 
     */
    public String vencedor(int numero) {
        String nombre = "";
        for(int i=0; i<jugadores.length; i++) {
            if(numero == jugadores[i].getPartidaGanada()) {
                nombre = jugadores[i].getNombre();
            }
        }
        return nombre;
    }

    /**
     * @return the jugadorVencedor
     */
    public String getJugadorVencedor() {
        return jugadorVencedor;
    }
}