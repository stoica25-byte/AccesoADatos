package sesion6_binarios;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio41_binarios {
    public static void main(String[] args) throws IOException {

        DataOutputStream out = new DataOutputStream(new FileOutputStream("datos.dat"));

        //escribo los datos

        out.write(7);
        System.out.println("escrito");
        //cierro y libero
        out.close();

    }
}
