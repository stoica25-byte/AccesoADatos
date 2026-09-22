package sesion_3_ficheros;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EJ1 {

    public static void main(String[] args) throws IOException {

        try {
            FileWriter fw = new FileWriter("datos1.txt", true);
            fw.write("hola que tal");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fr = new FileReader("datos1.txt");
            
            
            
            int letra = fr.read();
            while(letra != -1 ){
                System.out.print((char)letra);
            }
            fr.close();

        } catch (IOException e) {

        }
    }

}