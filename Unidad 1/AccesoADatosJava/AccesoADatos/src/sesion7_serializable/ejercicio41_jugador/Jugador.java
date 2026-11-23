package sesion7_serializable.ejercicio41_jugador;

import java.io.Serializable;

public class Jugador implements  Serializable{
    private static final long serialVersionUID = 1L;

    private String nombre ;
    private int dorsal ; 

    public  Jugador(){

    }

    public Jugador(String nombre , int dorsal){
        this.nombre = nombre;
        this.dorsal = dorsal; 


    }

    @Override 
    public String toString(){

        return this.nombre + "," + this.dorsal;
    }
}
