package sesion_4;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.StructuredTaskScope.FailedException;

public class Ejercicio_1 {
    public static void main(String[] args) {
        /*
        6.1 Un fichero de texto contiene una lista de números, uno por línea. 
        Escribe un programa que calcule la media y guarde el resultado en otro fichero.
        Usa Scanner para leer los números.
        Usa PrintWriter con printf para escribir el informe, con la media a dos decimales.
        El fichero puede contener líneas vacías o líneas que no sean números: el programa no debe caerse por ello.
        El informe generado debe tener este aspecto:
        */

        ArrayList<Integer> numeros = new ArrayList<>();
        int numeroValores = 0;
        int valorSumaTotal = 0;
        int cantNumeros = 0;
        try{
            Scanner sc = new Scanner(Path.of("numeros.txt"));


            while (sc.hasNextLine()){
                int numeroAux = Integer.valueOf(sc.nextLine());
                valorSumaTotal+= numeroAux;
                numeros.add(numeroAux);

            }
            sc.close();

            cantNumeros = numeros.size();
            float resultado = valorSumaTotal / cantNumeros ;
            System.out.println("la media es : " + resultado);
            
            //apertura del fichero para escribir
            PrintWriter pw = new PrintWriter(new FileWriter("resultado.txt"));

            pw.printf("Numeros leidos: %d\n", cantNumeros);
            pw.printf("Media: %.2f%n",resultado);

            //liberar recursos
            pw.close();
            
            
        }catch(FileNotFoundException e){

        }catch(IOException e){

        }catch(Exception e){
            System.out.println("He leido algo raro");
        }

    }
}
