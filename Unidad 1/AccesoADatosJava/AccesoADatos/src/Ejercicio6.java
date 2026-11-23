import java.io.File;

public class Ejercicio6 {
    public static void main(String[] args) {
        //5.6 Borra un directorio. Comprueba qué ocurre si no está vacío y explica por qué.

        File f = new File("datos");

        if (f.delete()){
            System.out.println("directorio borrado");
        }else{
            System.out.println("error al borrar");
        }
    }
}
