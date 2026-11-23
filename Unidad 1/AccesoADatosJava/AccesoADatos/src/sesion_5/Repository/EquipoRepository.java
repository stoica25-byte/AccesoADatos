package sesion_5.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sesion_5.Model.Equipo;

public class EquipoRepository {
    private final String nombreFichero = "equipos.csv";

    private ArrayList<Equipo> cargarCSV() throws FileNotFoundException {
        File file = new File(nombreFichero);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        // abro el fichero
        Scanner sc = new Scanner(file);
        // cargo todo el arraylist y lo devuelvo
        ArrayList<Equipo> equiposCargados = new ArrayList<>();

        while (sc.hasNextLine()) {
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) {
                continue;
            }
            String[] lineaLeida = linea.split(",");

            equiposCargados.add(new Equipo(
                    Integer.parseInt(lineaLeida[0]),
                    lineaLeida[1],
                    Integer.parseInt(lineaLeida[2])

            ));

        }
        sc.close();

        return equiposCargados;

    }

    private void guardarCSV(ArrayList<Equipo> equipos) throws FileNotFoundException {

        PrintWriter pw = new PrintWriter(new File(nombreFichero));

        // Recorro el arraylist y voy escribiendo

        equipos.forEach(x -> pw.println(x));

        // libero recursos

        pw.close();
    }

    public void save(Equipo e) {

        try {
            // cargar el csv
            ArrayList<Equipo> equipos = cargarCSV();

            // añadimos nuestro equipo
            equipos.add(e);

            // guardamos el csv
            guardarCSV(equipos);
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        }
    }

    public Equipo findById(int id) throws FileNotFoundException {
        // cargo el csv
        Equipo equipoEncontrado = new Equipo();

            ArrayList<Equipo> equipos = cargarCSV();

            for (Equipo e  : equipos) {
                if(e.getId()== id){
                    equipoEncontrado = e;
                }
            }

       

        // devuelvo el equipo encontrado
        return equipoEncontrado;

    }

    public ArrayList<Equipo> findAll() throws FileNotFoundException {
        // cargar el csv
        ArrayList<Equipo> equiposEncontrados = cargarCSV();
        // devolver todo el contenido
        return equiposEncontrados;
    }

    public void deleteById(int id) throws FileNotFoundException {
        // cargo csv
        ArrayList<Equipo> equipos = cargarCSV();

        // borro el equipo que no quiero
        equipos.removeIf(x -> x.getId() == id);

        // guardo
        guardarCSV(equipos);
    }

}
