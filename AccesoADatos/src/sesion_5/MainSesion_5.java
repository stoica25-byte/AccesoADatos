package sesion_5;

import java.io.FileNotFoundException;

import sesion_5.Model.Equipo;
import sesion_5.Service.EquipoService;

public class MainSesion_5 {
    public static void main(String[] args) throws FileNotFoundException {
        EquipoService eService = new EquipoService();

                eService.creaEquipo(new Equipo(1,"Los buenos",100));
                eService.creaEquipo(new Equipo(2,"Los regulares",100));
                eService.creaEquipo(new Equipo(3,"Los malos",100));

                System.out.println(eService.encuentraEquipo(1));

                eService.borraEquipo(1);

                //Listo los equipos 
                System.out.println("### Listo todos los equipos ###");

                for (Equipo e : eService.listarEquipos()) {
                    System.out.println(e);
                }
    }
}
