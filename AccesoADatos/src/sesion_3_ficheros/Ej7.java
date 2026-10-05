

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ej7 {
    public static void main(String[] args) {
        /*
        7.6 Crea un método que reciba el nombre de un fichero y devuelva cuántas palabras contiene. 
        Usa BufferedReader para leer línea a línea y split() para separar las palabras
        
        Antes de darlo por bueno, prueba tu método con un fichero que contenga:
        una línea vacía en medio,
        una línea que empiece con espacios,
        dos palabras separadas por varios espacios seguidos.
        Si el resultado no es el que esperabas, investiga por qué y corrígelo.
        */

        System.out.println(contarPalabras("prueba"));

        // se podria con una lambda br.lines()
    }

    public static int contarPalabras(String nombreFichero){

        int contadorPalabras = 0;
        String []palabras = {}; 
        String linea;
        try{
            BufferedReader br = new BufferedReader(new FileReader(nombreFichero));

            while((linea = br.readLine())!= null ){
                linea = linea.trim();

                if(!linea.isEmpty()){
                    palabras = linea.split("\\s+"); // significa que por cualquier espacio en blanco y el + significa 1 o mas
                    
                    contadorPalabras += palabras.length;
                    

                }
            }
            br.close();

        }catch(FileNotFoundException e){

        }catch(IOException e){

        }
        return contadorPalabras;
    }
}
