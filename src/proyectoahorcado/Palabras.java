/*
 * Se guardará un Array de 20 palabras del que luego se escogerá una al azar.
 */
package proyectoahorcado;

/**
 *
 * @author Arkaitz
 */
public class Palabras {
    /**
     * Creamos un Array de 20 palabras
     */
    private String[] palabras = {"sol", "hoz", "luna", "flor", "casa", "fantastico", "decepcion", "gato", "chaqueta", "mochila", "uno", "numeracion", "puerta", "estupidez", "pintor", "autor", "pelicula", "adicto",
                                 "efermedad", "persona"};
    
    /**
     * Creamos la variable palabraSecreta, se le dará un valor más adelante.
     */
    private String palabraSecreta;
    
    /**
     * Creamos un numero aleatorio entrel el 0 al 19, despues le asignaremos a la variable palabraSecreta el contenido de una posicion aleatoria del
     * array palabras.
     */
    public String nuevaPalabra() {
        int numRandon = (int) Math.round(Math.random() * 19) ;
        palabraSecreta=palabras[numRandon];
        return palabraSecreta;
    }
    
    /**
     * @return the palabraSecreta
     */
    public String getPalabraSecreta() {
        return palabraSecreta;
    }
}