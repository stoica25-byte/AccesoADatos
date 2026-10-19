package sesion_5.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import sesion_5.Model.Equipo;
import sesion_5.Model.jugador;
import sesion_5.Repository.EquipoRepository;

public class EquipoService {

    private EquipoRepository equipoRepository = new EquipoRepository();

    public void creaEquipo(Equipo e){
        equipoRepository.save(e);
    }

    public ArrayList<Equipo> listarEquipos() throws FileNotFoundException{
            return equipoRepository.findAll();

    }

    public Equipo encuentraEquipo(int id) throws FileNotFoundException{

        return equipoRepository.findById(id);
    }

    public void borraEquipo(int id) throws FileNotFoundException{
        equipoRepository.deleteById(id);
    }


    //crea jugador

    public void creaJugador(jugador j){
        
    }
    //lista de jugadores de equipo
    //cambia de equipo
    //borrajugador
}
