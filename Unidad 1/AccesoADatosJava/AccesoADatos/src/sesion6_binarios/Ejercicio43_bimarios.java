package sesion6_binarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

class Ejercicio43_bimarios {

        public static void main(String[] args)  throws IOException{
            

            //abrir el fichero de origen 
            FileInputStream in = new FileInputStream("pequena.estrella.png");


            //abrir el fichero de destino 
            FileOutputStream out = new FileOutputStream("copia.jpg");


            //ir leyendo byte a byte en origen
             //guardar byte a bye en destino 
            int b ;
            while ( (b = in.read()) != -1 ){
                    out.write(b);
            }


           //cierro
           in.close();
           out.close();


        }
     
}