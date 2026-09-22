import java.nio.file.*;
import java.util.stream.Stream;
import java.io.*;
public class Ejercicio8_nio {
    public static void main(String[] args) {
        //Lista todo el contenido de una carpeta con Files.walk()
        
        
        //Path y files
        Path ruta = Path.of("carpetaDatos2");

        try {
            //recupero el contenido de la carpeta con Files.walk
            Stream<Path> contenido = Files.walk(ruta);
            //Recorro el contenido y lo muestro
            contenido.forEach(x -> System.out.println(x));
            contenido.close(); // si haces try with resources --> try(Stream<Path> contenido = Files.walk(ruta)) no hace falta el close 
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}