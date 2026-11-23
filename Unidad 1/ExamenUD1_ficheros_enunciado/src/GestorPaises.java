import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.FilerException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GestorPaises {

    // Colección que contiene todos los paises
    private List<Pais> paises = new ArrayList<Pais>();
    private static final int LARGO_ID = 4;
    private static final int LARGO_NOMBRE = 5 ;
    private static final int LARGOINDICE_DESARROLLO = 8;
    private static final int TAMANO_REGISTRO = LARGO_ID + LARGO_NOMBRE * 2 + LARGOINDICE_DESARROLLO;


    // Mostrar todos los países
    public void mostrarPaises() {
        for (Pais p : paises) {
            System.out.println(p);
        }
    }

    // Ejercicio 1: leer CSV
    public void leerCSV(String nombreArchivoCSV){
        /*
        Lee el contenido del archivo CSV
        Salta la primera linea que indica la descripción de cada campo
        Por cada linea crea un pais y añadelo al ArrayList de paises
        Garantiza el cierre de los recursos
        Captura y/o propaga la excepcion
         */
        try {
            BufferedReader br = new BufferedReader(new FileReader("paises.csv"));
            br.readLine();
            String l;
            while ((l = br.readLine()) != null ){
                String[] paisleido = l.split(";");
                paises.add(new Pais(Integer.parseInt(paisleido[0]),paisleido[1],Double.parseDouble(paisleido[2])));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("archivo no encontrado");
        }

    }

    // Ejercicio 2: Leer aleatorio
    public void leerAleatorio(String nombreArchivoCSVAleatorio, int idBuscado){
        /*
        Define claramente el tamaño del registro de cada Pais. Ten en cuenta que el nombre del pais siempre será de 5 letras.
        Lee el registro correspondiente al idbuscado, no es necesario contemplar la posibilidad de que el registro no exista
        Inserta el pais buscado en el arraylist
        Garantiza el cierre de los recursos
        Captura y/o propaga la excepcion
         */

        try{
            RandomAccessFile raf = new RandomAccessFile(nombreArchivoCSVAleatorio, "r");
            
            raf.seek(idBuscado * TAMANO_REGISTRO);
            int id = raf.readInt();
            String nombre  = "";
            
            for (int i = 0 ; i < LARGO_NOMBRE ; i++){
                nombre += raf.readChar();
            }
            
            double indiceDesarrollo  =raf.readDouble();
            paises.add(new Pais(id,nombre,indiceDesarrollo));
            
            raf.close();
        }catch(IOException e ){

        }

    }

    // Ejercicio 3: Escribir XML
    /*
    <paises>
        <pais>
            <id>6</id>
            <nombre>Yemen</nombre>
            <indiceDesarrollo>0.480</indiceDesarrollo>
        </pais>
        ...
    </paises>

    Crea un archivo XML recibido y con la estructura de ejemplo
    Crear el nodo raíz <paises> y, dentro, un nodo <pais> por cada elemento del ArrayList.
    Crea el XML correctamente indentado (legible).
    Garantiza el cierre de los recursos
    Captura y/o propaga la excepcion
     */
    public void escribeXML(String nombreArchivoXML) throws TransformerException, ParserConfigurationException{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder(); 
        Document doc = db.newDocument();

        Element raiz = doc.createElement("paises");
        doc.appendChild(raiz);
       

        for (Pais p  :paises){
            Element pais = doc.createElement("pais");
             
            Element  id = doc.createElement("id");
            id.setTextContent(String.valueOf(p.getId()));

            Element nombre = doc.createElement("nombre");
            nombre.setTextContent(p.getNombre());
            
            Element indiceDesarrollo = doc.createElement("indiceDesarrollo");
            indiceDesarrollo.setTextContent(String.valueOf(p.getIndiceDesarrollo()));

            //añadir al arbol dom 

            pais.appendChild(id);
            pais.appendChild(nombre);
            pais.appendChild(indiceDesarrollo);
            raiz.appendChild(pais);
        }

        //3. genero el xml
        Transformer tr = TransformerFactory.newInstance().newTransformer();
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.transform(new DOMSource(doc), new StreamResult(new File(nombreArchivoXML)));
        
        
    }

}
