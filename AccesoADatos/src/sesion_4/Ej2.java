package sesion_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Ej2 {
    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = cargar("alumnos.csv");
    }

    static ArrayList<Alumno> cargar(String nombreFichero){
        ArrayList<Alumno> alumnosMemoria = new ArrayList<>();
        
        try{
            //leer fichero
            Scanner sc = new Scanner(new File(nombreFichero));

            //recorrer fichero

            //leer primera linea
            String lineaTitulos = sc.nextLine();
            System.out.println(lineaTitulos);

            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] datosLineasSeparado = linea.split(",");

                Alumno a = new Alumno(Integer.parseInt(
                    datosLineasSeparado[0]),
                datosLineasSeparado[1]
                ,datosLineasSeparado[2]
                );

                alumnosMemoria.add(a);
            }
        }catch(FileNotFoundException e){

        }catch(IOException e){

        }

    }

    static void guardar(ArrayList<Alumno> alus,){
        
    }
}