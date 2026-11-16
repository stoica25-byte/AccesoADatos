package sesion_8;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

public class Ej2_agenda {
    public static void main(String[] args) {
        
         escribir(5, "ABC"); // Se guarda en la posición 0 (bytes 0 al 9)
        escribir(8, "LU");  // Se guarda en la posición 1 (bytes 10 al 19)
        escribir(9, "maria");  // Se guarda en la posición 1 (bytes 10 al 19)


        leer(0); // Lee el primer registro (ABC 5)
        leer(1); // Lee el segundo registro (LU 8)  
        leer(2); // Lee el segundo registro (LU 8)  

    }

    static final int TAMANO_ID = 4 ;
    static  final int TAMANO_NOMBRE = 3;
    static final int TAMANO_REGISTRO = TAMANO_ID + TAMANO_NOMBRE * 2 ;
    static  void escribir(int id , String nombre){
        try (RandomAccessFile raf = new RandomAccessFile("contactos.dat", "rw")) {
            
            //saltar al final del archivo   
            raf.seek(raf.length());

            raf.writeInt(id);

            for(int i = 0 ; i < 3 ; i++ ){
                if (i < nombre.length()){
                    raf.writeChar(nombre.charAt(i));
                }else{
                    raf.writeChar(' ');
                }
            }


        } catch (IOException e) {
           System.out.println("archivo no encontrado");
        }
    }

    static void leer(int numeroRegistro){
        try (RandomAccessFile raf = new RandomAccessFile("contactos.dat", "r")) {
            
            raf.seek(TAMANO_REGISTRO * numeroRegistro);

            String nombreLeido = "";
            int numeroLeido = raf.readInt();

            for (int i = 0 ; i< 3 ; i++ ){
                nombreLeido += raf.readChar();
            }
           nombreLeido= nombreLeido.trim();

            System.out.println(nombreLeido + numeroLeido);
        } catch (IOException e) {
            System.out.println("archivo no encontrado");
        }
    }
}


