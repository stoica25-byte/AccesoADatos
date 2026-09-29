

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Ej4 {
    // 7.3 Clase que cree n ficheros llamados nombre1.txt … nombreN.txt,
    // cada uno con el texto «Este es el fichero nombreN.txt».

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            String nombreArchivo = "nombre"+i+".txt";
            crearArchivo(nombreArchivo);
            escribeArchivo(nombreArchivo);
        }
    }

    public static void crearArchivo(String nombre) {
        File f = new File(nombre);

        try {
            f.createNewFile();
        } catch (IOException e) {
            System.out.println("error");
        }

        System.out.println("fichero: " + nombre + "creado");
    }

    public static void escribeArchivo(String nombreArchivo) {
        try {
            FileWriter fw = new FileWriter(nombreArchivo);
            fw.write("Este es el fichero: "+ nombreArchivo);
            fw.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }
}
