 package sesion6_binarios;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class Ejercicio44_binarios {

    public static void main(String[] args) throws IOException {
        
         //abrir el fichero de origen 
            FileInputStream in = new FileInputStream("pequena.estrella.png");


            //abrir el fichero de destino 
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("copia.jpg"));

            //medida del tiempo

            long t1 = System.nanoTime();

            //ir leyendo byte a byte en origen
             //guardar byte a bye en destino 
            int b ;
            while ( (b = in.read()) != -1 ){
                    out.write(b);
            }

            long tiempoConBuffer = (System.nanoTime() - t1 )/ 1_000_000;
            
           //cierro
           in.close();
           out.close();
    }
    
}