package sesion_8;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ej1_enteros {
    public static void main(String[] args) {
       Scanner teclado= new Scanner(System.in); 
        try (RandomAccessFile raf = new RandomAccessFile("random.dat", "rw")) {
            
            for (int i = 0 ; i <= 9 ; i++){
                raf.writeInt(i);
            }

            System.out.println("ingresa un numero a buscar ");
            int numero = teclado.nextInt();

            final int TAMANO_REGISTRO = 4 ; 

            raf.seek( TAMANO_REGISTRO * numero );
            int numeroLeido = raf.readInt();

            System.out.println("el numero leido es : " + numeroLeido);

            //si pones 15 da end of file exception
            long tamano_archivo = raf.length();
            
        } catch (EOFException e) {
            System.out.println("NUMERO NO ENCONTRADO");
        }catch(IOException e){
            System.out.println("archivo no encontrado");
        }
    }
}
