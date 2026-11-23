import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Ej1{
    public static void main(String[] args) {
        //3.1 Recupera el ejercicio de borrar un fichero. Tenías la versión con File.delete(), que devuelve boolean. 
        // Escribe ahora la versión con Files.delete() distinguiendo en el catch el caso de que no exista del resto de errores.

        // con java nio por que lanza excepciones

        
        try{
            Path ruta =Path.of("");
            
            //borro el fichero
            Files.delete(ruta);
        }catch(NoSuchFileException e){
           System.out.println("el fichero no existe");

        }catch( DirectoryNotEmptyException e){
            System.out.println("La carpeta no esta vacia");

        }catch(IOException e){
            System.out.println("Error. No se pudo borrar el elemento"+ e.getMessage());
        }
    }
}