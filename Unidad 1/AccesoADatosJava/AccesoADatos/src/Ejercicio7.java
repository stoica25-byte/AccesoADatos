import java.io.File;

public class Ejercicio7 {
    public static void main(String[] args) {
        // Dado un directorio, muestra el nombre
        // de tod o lo que contiene, distinguiendo ficheros de carpetas, o indica que está vacío.

        //Instanciamos el directorio
        File directorio = new File("carpetaDatos");

        //TODO COMPROBAR QUE ES UN DIRECTORIO

        //version 1 utilizando list()
        //miramos si es un directorio

        //forma primitiva de recorrer un array
        String[] contenido = directorio.list();
        for (int i = 0; i < contenido.length; i++) {
            System.out.println(contenido[i]);
        }

        //otra forma de recorrer un array
        System.out.println();
        System.out.println("CON BUCLE FOR EACH");
        System.out.println();
        for (String s : contenido) {
            System.out.println(s);
        }

        //version 2 utilizando listFiles() que devuelve un File()
        System.out.println();
        System.out.println("version 2 ");
        System.out.println();
        File[] contenido2 = directorio.listFiles();

        for (File f : contenido2) {
            if (f.isDirectory()) {
                System.out.println("[Carpeta]" + f.getName());
            } else {
                System.out.println("- " + f.getName());
            }

            System.out.println("con operador ternario\n");
            System.out.println(f.isDirectory() ? " [Carpeta]" + f.getName() : "- " + f.getName());

        }



    }
}
