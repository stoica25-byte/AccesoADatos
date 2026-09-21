import java.io.File;
import java.nio.file.Path;

public class Ejercicio8 {
    public static void main(String[] args) {
        //Lista recursivamente to do el contenido de una carpeta con su ruta.
        // Resuélvelo dos veces: con listFiles() recursivo y con Files.walk(). Compara ambas soluciones en un comentario.

        File directorio = new File("carpetaDatos2");

        File[] contenido = directorio.listFiles();

        for ( File carpeta: contenido ) {
            for (File f :contenido) {
                System.out.println(f);
            }
        }

    }
}
