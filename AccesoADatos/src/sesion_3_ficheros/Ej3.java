package sesion_3_ficheros;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ej3 {
    public static void main(String[] args) {
        // 7.2 Clase que busque una vocal en un fichero y muestre cuántas veces aparece.
        // Trata las mayúsculas y minúsculas como el mismo carácter.

        char vocalBuscada = 'a';
        int contador = 0;

        // 1. Abrir el fichero (usamos try-with-resources para asegurarnos de que se cierra siempre)
        try (FileReader fr = new FileReader("libro.txt")) {

            int letra = fr.read();

            // Corregido: El fin de fichero en Java es -1
            while (letra != -1) {
                // Corregido: Convertimos el entero a char y luego a minúscula
                char caracterActual = Character.toLowerCase((char) letra);

                if (caracterActual == Character.toLowerCase(vocalBuscada)) {
                    contador++;
                }

                letra = fr.read();
            }

            System.out.println("La vocal '" + vocalBuscada + "' aparece " + contador + " veces.");

        } catch (FileNotFoundException e) {
            System.out.println("El archivo 'libro.txt' no se ha encontrado.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }

    }
}