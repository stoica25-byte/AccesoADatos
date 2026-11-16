package sesion_9;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Ej2_contacto {
public static void main(String[] args) throws ParserConfigurationException, TransformerException {
     List<Contacto> listaContactos = new ArrayList<>();
        listaContactos.add(new Contacto(1, "Ana"));
        listaContactos.add(new Contacto(2, "Luis"));
        listaContactos.add(new Contacto(3, "María"));

        //crear el dom 

         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();
         Document doc = builder.newDocument();

        //crear etiqueta raiz 

        Element raiz = doc.createElement("contactos");
            doc.appendChild(raiz);

        // bucle para recorrer arraylist

        for (Contacto c : listaContactos){
            Element contacto = doc.createElement("contacto");
            contacto.setAttribute("id", String.valueOf(c.id));
            raiz.appendChild(contacto);

            Element nombre = doc.createElement("nombre");
            nombre.setTextContent(String.valueOf(c.nombre));
            contacto.appendChild(nombre);
        }

        //guardar

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("contactos.xml"));
            transformer.transform(source, result);

            System.out.println("Archivo contactos.xml generado correctamente.");

            
}
}

class Contacto{
    int id;
        String nombre;

        public Contacto(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }
}
