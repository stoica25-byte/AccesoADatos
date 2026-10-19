package sesion_5.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Scanner;

import sesion_5.Model.Equipo;
import sesion_5.Model.jugador;

public class jugadorRepository {

    public final String nombreFichero = "jugadores.csv";

    public ArrayList<jugador> cargarCSV() throws IOException{
        File file = new File(nombreFichero);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        // abro el fichero
        Scanner sc = new Scanner(file);
        // cargo todo el arraylist y lo devuelvo
        ArrayList<jugador> jugadoresCargados = new ArrayList<>();

        while (sc.hasNextLine()) {
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) {
                continue;
            }
            String[] lineaLeida = linea.split(",");

            jugadoresCargados.add(new jugador(lineaLeida[0],Integer.parseInt(lineaLeida[1]), Integer.parseInt(lineaLeida[2])));

            

        }
        sc.close();

        return jugadoresCargados;
        
    }

    public void guardarCSV(ArrayList<jugador> jugadores) throws IOException{
         PrintWriter pw = new PrintWriter(new File(nombreFichero));

         jugadores.forEach(x -> pw.println(x));

         pw.close();
    }

    public jugador findById(int id) throws IOException{

        ArrayList<jugador> jugadoresCargados = cargarCSV(); 

        jugador jugadorEncontrado = new jugador();

        for (jugador j : jugadoresCargados) {
            if (j.getId() == id ){
                jugadorEncontrado = j;
            }
        }

        return jugadorEncontrado;
    }

    public ArrayList<jugador> findAll() throws IOException{
        ArrayList<jugador>jugadoresEncontrados = cargarCSV();
        
        return jugadoresEncontrados;
    }

    public void deleteById(int id) throws IOException{

        ArrayList<jugador> jugadores = cargarCSV();
         
        jugadores.removeIf(x ->  x.getId() == id);

    }

    public void save( jugador j )throws IOException{

            // abro la lista de todos los jugadores 
            ArrayList<jugador> jugadores  = cargarCSV();
            
            // añado el jugador nuevo

            jugadores.add(j);

            //guardo el csv

            guardarCSV(jugadores);  
    }
}
