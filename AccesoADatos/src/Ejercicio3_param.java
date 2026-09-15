import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3_param {
    public static void main(String[] args) throws IOException {
        // 5.3 Crea un fichero e informa de si se ha creado o ya existía.
        // Hazlo en una de estas dos versiones: leyendo el nombre con Scanner o recibiéndolo como argumento en args[].

        // instancio el objeto del fichero del usuario
        File ficheroUsuario = new File(args[0]);

        //compruebo si existe y si no lo creo
        if (ficheroUsuario.exists()){
            System.out.println("el fichero ya existia");
        }else{
            ficheroUsuario.createNewFile();
        }
    }
}
