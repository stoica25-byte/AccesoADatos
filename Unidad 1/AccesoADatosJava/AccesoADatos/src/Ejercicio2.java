import java.io.File;

public class Ejercicio2 {
    public static void main(String[] args) {
        //5.2 Lo mismo con un directorio. Comprueba con isDirectory() que efectivamente lo es,
        // y explica en un comentario qué devuelve length() sobre él.
        File archivo = new File("datos");

        if(archivo.isDirectory()){
            System.out.println("tamano :" + archivo.length());
        }else{
            System.out.println("el archivo seleccionado no es un directorio"); // para carpetas
        }
    }
}
