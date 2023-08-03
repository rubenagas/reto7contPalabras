import java.util.ArrayList;
import java.util.Scanner;

/* Reto Mouredev
 * Reto #7
 * CONTANDO PALABRAS
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * *** FUNCIONES ÚTILES ***
 * split --> Genera un array de Strings separando por un carácter en concreto.
 * replace --> Sustituye un carácter por otro.
 * trim --> Elimina todos los espacios.
 *
 */
public class Main {
    public static void main(String[] args) {
        //Creamos la variable
        String palabra;

        //Solicitamos y guardamos el valor de la variable de tipo texto
        System.out.println("Escribe una frase");
        Scanner scanner = new Scanner(System.in);
        palabra = scanner.nextLine();

        //Ponemos los caracteres del valor en minusculas
        palabra = palabra.toLowerCase();

        //Creamos un array de Strings reconociendo el carácter introducido
        String[] palabras = palabra.split(" ");

        //Recorremos el array para sustituir los signos de puntuación por espacios
        for (int i = 0; i < palabras.length; i++){
            //Reconocemos si la posición del array contiene el carácter especificado
            if (palabras[i].contains(",")){
                //Sustituimos el carácter anterior por un espacio
                palabras[i] = palabras[i].replace(",", " ");
            }
            if (palabras[i].contains(".")){
                palabras[i] = palabras[i].replace(".", " ");
            }
            //Eliminamos los espacios que contiene la posición del array seleccionada
            palabras[i] = palabras[i].trim();
        }

        //Creamos un array de enteros para poder comparar las posiciones
        int[] count = new int[50];
        boolean repite = true;

        for (int i = 0; i < palabras.length; i++){
            count[i] = 0;
            repite = true;
            for (int j = 0; j < i; j++){
                if(palabras[i].equals(palabras[j]) && repite){
                    repite = false;
                }
            }
            for(int j = 0; j < palabras.length; j++){
                if(palabras[i].equals(palabras[j]) && repite){
                    count[i]++;
                }
            }
            if (count[i] > 0){
                System.out.println(palabras[i] + ": " + count[i]);
            }
        }

    }
}