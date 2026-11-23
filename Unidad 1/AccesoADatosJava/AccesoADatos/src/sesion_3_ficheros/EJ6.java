

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TransferQueue;

public class EJ6 {
    public static void main(String[] args) {
        // 7.5 Crea un método que reciba el nombre de un fichero y un entero n,
        // y escriba n líneas con el texto «Esta es la línea n», sustituyendo n por el
        // número correspondiente.

        // Usa BufferedWriter y el método newLine() para los saltos de línea.
        // Después abre el fichero generado con un editor y comprueba que las líneas
        // están bien separadas.

        escribeLineas("prueba", 8);

    }

    public static void escribeLineas(String nombreFichero, int numLineas) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero));

            for (int i = 0; i < numLineas; i++) {
                bw.write("Esta es la linea: " + i);
                bw.newLine();
            }
            // si no cierras recursos no se escribe en el archivo y tendrias que usar
            // bw.flush()
            bw.close();

        } catch (FileNotFoundException e) {
            try {

                File f = new File(nombreFichero);
                f.createNewFile();
            } catch (IOException f) {
                System.out.println("El archivo no existe y no se pudo crear");
            }
        } catch (IOException e) {

        }
    }
}
