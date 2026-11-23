package sesion7_serializable.ejercicio41_jugador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import sesion7_serializable.ejercicio41_jugador.*;


class Main {

    public static void main(String[] args) {
        
        Jugador j1 = new Jugador("paco", 5);
        Jugador j2 = new Jugador("juan", 6);
        Jugador j3 = new Jugador("andres", 7);

        ArrayList<Jugador> lista = new ArrayList<>();
        
        lista.add(j1);
        lista.add(j2);
        lista.add(j3);


        System.out.println("GUARDAR CON SERIALIZABLE"); // el archivo ocupa 209 bytes 

        try{
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("jugadores.dat"));

            oot.writeObject(lista);

            oot.close();

        }catch(IOException e  ){

        }
        
        

        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("jugadores.dat"));

            ArrayList<Jugador> listaCargada = (ArrayList<Jugador>) in.readObject();
            
            for (Jugador j  : listaCargada) {
                System.out.println(j.toString());
            }

            in.close();
        }catch(IOException e ){

        }catch(ClassNotFoundException e ){

        }



        System.out.println("GUARDAR CON CSV"); // el archivo ocupa 37 bytes 


        try{
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("jugadores_sesion7.csv")));

            pw.println("nombre,dorsal");
            lista.forEach(x -> pw.println(x));

            pw.close();

        }catch(IOException e ){

        }

        
    }
    
}