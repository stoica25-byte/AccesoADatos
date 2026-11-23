package sesion_5.Model;

public class jugador {
    private String nombre; 
    private int dorsal;
    private int equipo;
    private String posicion;
    
    public jugador(String nombre, int dorsal, int equipo,String posicionc){
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.equipo = equipo;
        this.posicion = posicion;
    }
    // el jugador se identifica con el dorsal
    public jugador(){

    }

    @Override 
    public String toString(){
            return nombre + "," + dorsal + "," + equipo;

    }

    public int getId() {
        return this.dorsal;
    }
    public Object getNombre() {
        
        return this.nombre;
    }
}
