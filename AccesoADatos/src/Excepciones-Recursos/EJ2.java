import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class EJ2 {
    //3.2 Recupera el de borrar un directorio.
    // Provoca el fallo intentando borrar una carpeta con contenido,
    // comprueba qué excepción se lanza y trátala con un mensaje útil para el usuario.

    public static void main(String[] args) {
        Path ruta  = Path.of("datos");

        try {
            Files.delete(ruta);
            System.out.println("directorio borrado");

        }catch (DirectoryNotEmptyException e){
            System.out.println("El directorio no esta vacio" + ruta.toAbsolutePath());
        }catch (NoSuchFileException e){
            System.out.println("no existe el directorio: " + ruta.toAbsolutePath());
        }
        catch (IOException e) {
            System.out.println("no se pudo borrar: " + e.getMessage());
        }
    }
}
