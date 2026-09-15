import java.io.File;

public class Ejercicio4 {
    public static void main(String[] args) {
        //5.4 Crea una carpeta e informa de si se ha creado o ya existía.
        // Prueba con una ruta de varios niveles y comprueba la diferencia entre mkdir() y mkdirs().

        File archivo = new File("carpetaDatos");
        if (archivo.mkdir()){ // mkdir crea un directorio y devuelve true o false
            System.out.println("directorio creado");
        }else{
            System.out.println("directorio no creado, ya existe ");
        }

        File archivo2 = new File("carpetaDatos2/1/2/3");
        if (archivo2.mkdirs()){ // mkdirs crea un directorios con niveles y devuelve true o false
            System.out.println("directorio creado");
        }else{
            System.out.println("directorio no creado, ya existe ");
        }

    }
}
