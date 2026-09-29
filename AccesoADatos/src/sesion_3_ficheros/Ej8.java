import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.classfile.BufWriter;

public class Ej8 {
    public static void main(String[] args) {
        // 7.7 Crea un método que reciba dos ficheros de texto
        // y genere un tercero con el contenido de ambos, uno detrás de otro.

        // Ten cuidado con una cosa: el fichero de destino debe abrirse una sola vez.
        // Si lo abres dentro del bucle que recorre los dos ficheros de origen, el
        // segundo borrará lo que escribió el primero.

        combinarFicheros("libro.txt", "prueba", "Ej8Prueba.txt");

    }

    public static void combinarFicheros(String fichero1, String fichero2, String ficheroDestino) {

        try {
            String linea = "";

            BufferedReader br1 = new BufferedReader(new FileReader(fichero1));

            BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroDestino));

            while ((linea = br1.readLine()) != null) {

                bw.write(linea + "\n");

            }
            br1.close();

            BufferedReader br2 = new BufferedReader(new FileReader(fichero2));
            while ((linea = br2.readLine()) != null) {

                bw.write(linea + "\n");

            }
            br2.close();
            bw.close();
        } catch (IOException e) {

        }
    }
}
