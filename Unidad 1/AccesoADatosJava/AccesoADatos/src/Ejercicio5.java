import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Ejercicio5 {
    public static void main(String[] args) {
    // Instanciar el file del fichero

        File f = new File("ejercicio345.txt"); // para que funcione habra que crear el archivo primero

        //borramos el fichero
        //comprobamos el resultado
        if (f.delete())
            System.out.println("fichero borrado");
        else
            System.out.println("ha sucedido un error");

        System.out.println("BORRADO CON FILE(S)");
        //version 2 utilizando FILES (java.nio)
        //instancio una ruta al fichero  o directorio
        Path ruta =  Path.of("datos1.txt") ;

        //borro esa ruta utilizando Files ( s plural)
        try {
            Files.delete(ruta);

        } catch (NoSuchFileException e) {
            System.out.println("archivo no encontrado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
