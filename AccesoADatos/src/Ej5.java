import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {
        //7.4 Programa que pida frases por teclado hasta que se escriba «fin» y las guarde en un fichero.
        //  Después, muestra el contenido del fichero frase por frase.

        try{

            Scanner teclado = new Scanner(System.in);
            System.out.println("escribe lo que quieras guardar en el archivo ");
            String frase = teclado.nextLine();

            FileWriter fw = new FileWriter("Escribir.txt",true);
            while (!frase.toLowerCase().equals("fin")) {
                fw.write(frase+ "\n");
                System.out.println("siguiente frase");
                frase = teclado.nextLine();
            }
            fw.close();

        }catch(FileNotFoundException e){

        }catch(IOException e){

        }

    }
}
