package sesion_3_ficheros;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ej2 {
    // 7.1 Crea un fichero de texto con un editor y escribe una clase que muestre su
    // contenido por pantalla.
    // Gestiona el caso de que no exista el fichero con un mensaje claro.
    public static void main(String[] args) {

        try {
            FileReader fr = new FileReader("datos1.txt");
            int letra = fr.read();
            while (letra != -1) {
                System.out.print((char) letra);
                letra = fr.read();
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado " + e.getMessage());
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}
