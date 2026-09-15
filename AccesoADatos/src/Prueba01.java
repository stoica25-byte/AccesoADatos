import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Prueba01 {

    public static void main(String[] args) throws IOException {
        // 5.1 Instancia un fichero y determina si existe. Muestra su nombre, tamaño y ruta absoluta.
        File archivo = new File("../nose.txt");
        archivo.createNewFile();
        System.out.println(System.getProperty("user.dir"));
        System.out.println("es un archivo ? : "+ archivo.isFile()); // cuando el archivo real no existe da false, si haces archivo.createNewFile() da true
        System.out.println("ruta absoluta" + archivo.getAbsolutePath()); // la ruta del archivo absoluta

        /*
        para ver el tamaño de un archivo primero instanciar la ruta del archivo y luego con esa usar el metodo de la clase
        Files
         */

        Path ruta  = Paths.get("nose.txt");
        long bytes = Files.size(ruta);
        System.out.println("el tamaño del archivo en bytes es : " +bytes);

        //5.2 Lo mismo con un directorio. Comprueba con isDirectory() que efectivamente lo es, y explica en un comentario qué devuelve length() sobre él.
        System.out.println("es un directorio? " + archivo.isDirectory());
    }
}
