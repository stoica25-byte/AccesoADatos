import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Prueba01 {

    public static void main(String[] args) throws IOException {
        // 5.1 Instancia un fichero y determina si existe. Muestra su nombre, tamaño y ruta absoluta.
        File archivo = new File("../nose.txt");
    // cuando el archivo real no existe da false, si haces archivo.createNewFile() da true
        if(archivo.exists()){
            System.out.println("nombre :" + archivo.getName());
            System.out.println("tamano :" + archivo.length());
            System.out.println("ruta absoluta:" + archivo.getAbsolutePath());
        }else{
            System.out.println("El archivo no existe");
        }

    }
}
