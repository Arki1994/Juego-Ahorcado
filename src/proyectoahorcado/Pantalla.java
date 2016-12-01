/**
 * Clase donde tendremos metodos para pedir por teclado datos.
 */
package proyectoahorcado;
/**
 *
 * @author Arkaitz
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Pantalla {   
    
    /**
     * Pide un entero por teclado, en caso de que sea una letra lo avisará y se repetirá la peticion del numero.
     * @param cadena
     * @return 
     */
    static int pideNum(String cadena) {
        int n = 0;
        Scanner teclado=new Scanner(System.in);
        boolean correcto = false;
        while (!correcto) {
            try {                
                System.out.println(cadena);
                n=teclado.nextInt();
                correcto = true;
            }
            catch (InputMismatchException e) {
                System.out.println("El numero no es valido");
                teclado.nextLine();
            }
        }
        return n;
    }
    
    /**
     * Pide un String por teclado.
     * @param cadena
     * @return 
     */
    static String pideCadena(String cadena) {
        System.out.println(cadena);
        Scanner teclado=new Scanner(System.in);
        return teclado.nextLine();
    }
    
    /**
     * Se pedirá una letra que pasaremos a char, en caso de introducir un numero o cualquier otro caracter que no sea una letra tambien nos 
     * avisará y la volverá a pedir, si se introducen dos letras en vez de una sucederá lo mismo.
     * Utilizo else if para que en el caso de que se cumpla una de las condiciones deje de estar verificando las demas.
     * @return 
     */
    static char pideletra() {
        char letra = 0;
        boolean correcto = false;
        while(!correcto) {
            String letraPedida = Pantalla.pideCadena("Introduce una letra: ");
            letraPedida.toLowerCase();
            if (letraPedida.length()>1) {
                System.out.println("Solo tienes que introducir una letra");
            }
            else if (letraPedida.length()==0) {
                System.out.println("Caracter no valido");
            }
            else if( letraPedida.charAt(0) < 'a' || letraPedida.charAt(0) >'z') {
                System.out.println("Caracter no valido");
            }
            
            else {
                letra=letraPedida.charAt(0);
                correcto=true;
            }
        } 
        return letra;
    }
    
    /**
     * Este metodo controla que el numero de jugadores que se introducirá sea mayor a 0 y menor a 10.
     * @return 
     */
    static int pideTamaño() {
        int tamaño;
        do {
            tamaño = Pantalla.pideNum("Introduce el nº de Jugadores: ");
            if(tamaño>10) {
                System.out.println("No se admite más de 10 jugadores");
            }
        }
        while (tamaño<1 || tamaño>10);
        return tamaño;
    }
    
    /**
     * Este método pide por teclado un numero, en caso de que se introduza un 0 se devolverá true.
     * @return 
     */
    static boolean continuar() {
        int opcion = pideNum("Introduza 0 para salir u otro número para echar otra partida: ");
        if (opcion == 0) {
            return true;
        } 
        return false;
    }
}
