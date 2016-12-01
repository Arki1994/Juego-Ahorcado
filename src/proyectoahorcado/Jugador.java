/**
 * En esta clase tendremos el constructor jugador que se utiliza en la clase Jugadores.
 * Tambien contendrá los metodos necesarios para que cada jugador juegue su partida: inicio(String palabra), juega (String palabra), 
 * ocultarPalabra(String palabra) y mostrarLetras(char letraIntroducida, String palabra).
 */
package proyectoahorcado;

/**
 *
 * @author Arkaitz
 */
public class Jugador {
    /**
     * Creamos 3 enteros llamados fallos, aciertos y partidaGanada, trabajaremos con ellos mas adelante
     */
    private int fallos, aciertos, partidaGanada;
    /**
     * Creamos una variable String nombre que introduciremos mas adelante y una de letras acertadas.
     */
    private String nombre;
    private String letrasAcertadas;
    
    /**
     * Creamos un construcctor que se guardará en el array jugadores.
     * Cada contructor tendra un nombre, sus fallos y aciertos y su partida ganada en el juego. 
     */
    Jugador() {
        this.nombre=Pantalla.pideCadena("Introduce el nombre: ");
        this.fallos=0;
        this.aciertos=0;
        this.partidaGanada=0;
    }
    
    /**
     * Este metodo se encarga de iniciar la partida, oculta toda la palabra a guiones gracias al metodo ocultarPalabra y deja los valores de
     * aciertos y fallos a 0.
     * @param palabra
     * @return 
     */
    public String inicio(String palabra) {
        ocultarPalabra(palabra);
        fallos=0;
        aciertos=0;
        return palabra;
    }
    
    /**
     * Con este metodo hará jugar a cada jugador, pide una lera y la muestra si existe en la palabra, en caso de llegar a 5 fallos informara que
     * el jugador ya ha perdido.
     * @param palabra 
     */
    public void juega (String palabra) {
        if (getFallos()!=5) {
            //Visualizamos el nombre del jugador con los fallos que lleva.
            System.out.println("************** " + getNombre() + " fallos: " + getFallos() + "**************");
            //Visualizamos la palabra con las letras que ya lleva acertadas.
            System.out.println(getLetrasAcertadas());
            char letra = Pantalla.pideletra();
            mostrarLetras(letra,  palabra);
        }
        else{
            System.out.println(getNombre() + ", ya has perdido");
        }
    }
    
    /**
     * Con este método ocultamos la palabra en guiones.
     * @param palabra 
     */
    public void ocultarPalabra(String palabra) {
        letrasAcertadas="";
        for (int i = 0; i <palabra.length(); i++){
            letrasAcertadas+="-";         
        }
    } 
    
    /**
     * Este método muestra la letra que introduce el usuario siempre que se encuentre en la palabraSecreta, es decir, intercambia un guion por
     * la letra introducida.
     * @param letraIntroducida
     * @param palabra 
     */    
    public void mostrarLetras(char letraIntroducida, String palabra) {
        String temporal = "";
        int pos = 0;
        //Igualamos la variable pos a la posicion de la letra que hemos introducido respecto a la palabraSecreta.
        pos = palabra.indexOf(letraIntroducida);
        //En caso de que la posicion fuera -1 significaria que la letra no esta en la palabra.
        if (pos != -1) {
            for (int i=0; i<palabra.length(); i++) {
                if(letraIntroducida == palabra.charAt(i)) {
                    temporal += letraIntroducida + "";
                }
                else {
                    temporal += getLetrasAcertadas().charAt(i) + "";
                }
            }
            letrasAcertadas=temporal;
            System.out.println(getLetrasAcertadas());
            //Si la variable letrasAcertadas es igual que palabraSecreta sumaremos un acierto y una partida ganada al jugador.
            if (getLetrasAcertadas().equals(palabra)) {
                aciertos++;
                partidaGanada++;
            }
        }
        //Si la letra no se encuentra en la palabra sumaremos un fallo al jugador.
        else {
            System.out.println(getLetrasAcertadas());
            fallos++;
        }
    }

    /**
     * @return the fallos
     */
    public int getFallos() {
        return fallos;
    }

    /**
     * @return the aciertos
     */
    public int getAciertos() {
        return aciertos;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the partidaGanada
     */
    public int getPartidaGanada() {
        return partidaGanada;
    }

    /**
     * @return the letrasAcertadas
     */
    public String getLetrasAcertadas() {
        return letrasAcertadas;
    }
}