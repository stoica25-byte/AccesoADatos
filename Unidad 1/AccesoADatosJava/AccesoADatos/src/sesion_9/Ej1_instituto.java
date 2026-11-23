package sesion_9;

import java.io.File;
import java.io.IOException;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ej1_instituto {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument(); // el xml

        Element raiz = doc.createElement("instituto");
        doc.appendChild(raiz);

        Element nombre = doc.createElement("nombre");
        nombre.setTextContent("IES PABLO SERRANO");
        raiz.appendChild(nombre);

        Element ciudad = doc.createElement("ciudad");
        ciudad.setTextContent("ZGZ");
        raiz.appendChild(ciudad);

        
        //guardar

        Transformer tr = TransformerFactory.newInstance().newTransformer();
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.transform(new DOMSource(doc), new StreamResult(new File("instituto.xml")));



        //leer 

        

                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc2 = db.parse(new File("instituto.xml"));

        NodeList lista = doc2.getElementsByTagName("instituto"); // Corregido: doc2

        for (int i = 0; i < lista.getLength(); i++) {
            Node nodo = lista.item(i);
            
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo;
                
                // Corregido: buscamos cada etiqueta hija dentro de <instituto>
                String nombreLeido = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                String ciudadLeida = elemento.getElementsByTagName("ciudad").item(0).getTextContent();

                System.out.println("Nombre: " + nombreLeido);
                System.out.println("Ciudad: " + ciudadLeida);
            }
        }


        
    }
}
