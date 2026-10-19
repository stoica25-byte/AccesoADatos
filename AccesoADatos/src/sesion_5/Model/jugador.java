package sesion_5.Model;

public class jugador {
    private String nombre; 
    private int dorsal;
    private int equipo;
    
    public jugador(String nombre, int dorsal, int equipo){
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.equipo = equipo;
    }

    public jugador(){

    }

    @Override 
    public String toString(){
            return nombre + "," + dorsal + "," + equipo;

    }

    public int getId() {
        return this.equipo;
    }
}
