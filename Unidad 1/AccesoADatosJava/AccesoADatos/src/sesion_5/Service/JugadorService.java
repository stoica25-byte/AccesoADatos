package sesion_5.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import sesion_5.Model.jugador;
import sesion_5.Repository.jugadorRepository;

public class JugadorService {

        private  jugadorRepository jugadorRepository = new jugadorRepository();
   
        public void creaJugador(jugador j ){
        
                    if( j.getNombre() == null){
                        throw new IllegalArgumentException("el nombre no puede estar vacio ");

                    }

                
                
                if(jugadorRepository.findById(j.getId()) != null){
                        throw new IllegalArgumentException(" no se puede insertar un jugador con un id repetido ");
                }

                if (j.getId() < 1 || j.getId()> 99){
                    throw new IllegalArgumentException("el dorsal debe de estar enter 1 y 99");

                }
    

        }


        public ArrayList<jugador> listaJugadores() throws IOException{

            return jugadorRepository.findAll();
        }

        public void borrajugador(int dorsal) throws IOException{

            jugadorRepository.deleteById(dorsal);
        }

        public jugador buscaJugador(int dorsal ) throws IOException{
            return jugadorRepository.findById(dorsal);
        }

        


}
