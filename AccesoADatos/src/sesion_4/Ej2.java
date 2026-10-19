package sesion_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Ej2 {
    public static void main(String[] args) throws IOException {
        ArrayList<Alumno> alumnos = cargar("alumnos.csv");

        // recorrer el arraylist para ver que se guarda bien
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }

        // o con lambda --> .forEach(x -> System.out.printnln(x)) o
        // .foreach(System.out::println)

        // modificar algun alumno o añadir alguno nuevo
        alumnos.add(new Alumno(3, "julian", "j@iespabloserrrano.com"));
        alumnos.get(2).setNombre("Eustaquio");
        // volver a guardar
        alumnos.forEach(System.out::println);
        guardar(alumnos, "alumnos.csv");
    }

    static ArrayList<Alumno> cargar(String nombreFichero) {
        ArrayList<Alumno> alumnosMemoria = new ArrayList<>();

        try {
            // leer fichero
            Scanner sc = new Scanner(new File(nombreFichero));

            // recorrer fichero

            // leer primera linea
            String lineaTitulos = sc.nextLine();
            System.out.println(lineaTitulos);

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                // separo los datos
                String[] datosLineasSeparado = linea.split(",");
                // creo alumnos con los datos leidos
                Alumno a = new Alumno(Integer.parseInt(
                        datosLineasSeparado[0]),
                        datosLineasSeparado[1], datosLineasSeparado[2]);

                alumnosMemoria.add(a);
            }
        } catch (FileNotFoundException e) {
            System.out.println("fichero no encontrado");
        } catch (IOException e) {
            System.out.println("error de archivos");
        }

        return alumnosMemoria;

    }

    static void guardar(ArrayList<Alumno> alus, String nombreFichero) throws IOException {

        // abrir el fichero para escritura
        PrintWriter pw = new PrintWriter(new File(nombreFichero));
        pw.println("id.nombre,email");
        alus.forEach(x -> pw.println(x));

        pw.close();
    }

    // ampliacion
    static void cambiarEmail(int id, String email) throws IOException{
        // cargar()
        ArrayList<Alumno> alumnos = cargar("alumnos.csv");

        // recorrer todo el arraylist y buscar qien tiene ese id
        alumnos.forEach(x -> {
            if (x.getId() == id) {
                // modificar el email
                x.setEmail(email);
            }
        });

        // guardar
        guardar(alumnos,"alumnos.csv");
    }
}