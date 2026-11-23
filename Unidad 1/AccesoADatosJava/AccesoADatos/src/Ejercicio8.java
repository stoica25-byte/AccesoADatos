import java.io.File;
import java.nio.file.Path;

public class Ejercicio8 {
    public static void main(String[] args) {
        // Lista recursivamente to do el contenido de una carpeta con su ruta.
        // Resuélvelo dos veces: con listFiles() recursivo y con Files.walk(). Compara
        // ambas soluciones en un comentario.

        File directorio = new File("carpetaDatos2");

        File[] contenido = directorio.listFiles();

        // Llamamos al metodo recursivo
        listarContenido(directorio);

    }

    public static void listarContenido(File carpetaActual) {
        // Liastar de contenido
        File[] contenido = carpetaActual.listFiles();

        // si la carpeta esta vacia o no
        if (contenido == null) {
            System.out.println("no es un directorio");
        }
        if (contenido.length == 0) {
            System.out.println("esta vacio  ");

        } else {
            for (File f : contenido) {
                System.out.println(f.getPath());
                // Muestro el nombre del archivo
                if (f.isDirectory()){
                    //compruebo si es una subcarpeta y si lo es profundizo
                    listarContenido(f);
                }
            }

        }

    }
}
