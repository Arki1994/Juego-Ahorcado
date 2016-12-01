/**
 * En esta clase llamaremos a todos los metodos necesarios de las demás clases para poder ejecutar el programa.
 */
package proyectoahorcado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Arkaitz
 */
public class ProyectoAhorcado {

    public static void main(String[] args) {
        String contenido;
        //Creamos la variable tamaño para preguntar el tamaño de jugadores.
        int tamaño = Pantalla.pideTamaño();
        Jugadores j=new Jugadores(tamaño);  
        //Hacemos un do while para jugar hasta que el usuario pulse 0 y un while.
        do {
            j.restart();
            j.temporal();
            //Dentro del do while crearemos otro bucle donde los jugadores jugarán al ahorcado hasta que tengan 5 fallos o 1 acierto.
            while(j.devuelveAciertos()!=true && j.fallosMaximos()!=true) {
                j.partida();
            }
        } while (Pantalla.continuar() != true);
        
        /**
         * Creamos un fichero donde se guardarán a los jugadores que han ganado la partida con el número de rondas
         * victoriosas, tambien se visualizará la pantalla.
         */
        try {
            FileOutputStream ficheroEscritura = new FileOutputStream ("MejoresJugadas.txt", true);
            DataOutputStream ficheroSalida = new DataOutputStream(ficheroEscritura);  
            //Escribimos en el fichero el nombre del jugador que ha ganado mas el número de victorias          
            ficheroSalida.writeUTF("El jugador "+j.vencedor(j.mejoresJugadas())+" ha logrado ganar " + j.mejoresJugadas() +" rondas de la partida."+"\n");
            ficheroSalida.close();  
            FileInputStream ficheroLectura = new FileInputStream("MejoresJugadas.txt");
            DataInputStream ficheroEntrada = new DataInputStream(ficheroLectura);
            while(true) {
                contenido = ficheroEntrada.readUTF();
                System.out.print(contenido);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el fichero");
        } catch (IOException e) {
        }
    }
}