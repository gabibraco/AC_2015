package Marshaller_XL;

import java.io.File;
import java.util.ArrayList;







import java.util.Iterator;

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
import org.w3c.dom.Text;
/*
 * Con esta Actividad los que se pretende es el paso inverso a 
 * la anterior actividad , que en este caso es la de Serilizar 
 * El objeto Document para hacer un document Xml
 */
public class Marshaller {
	//Definimos nuestros objetos 
	private Document dom=null;//Document
	private ArrayList<Libro> libros = null;
	//Pasamos al constructor el ArrayList 
	public Marshaller(ArrayList<Libro> lib ){
		//Asignamos el ArrayList a nuestro objeto local
		libros= lib;	
	}
	/*
	 * Generamos nuestro Objeto Document del mismo modo que lo hicimos anteriormente
	 */
	public void crearDocumento() {
		// Se crea un Factory para poder parsear el archivo
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// se crea el document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			//Aqui no parseamos creamos el documento
			dom = db.newDocument(); 
		  //Capturams las excepciones pero no tantas omo en la otra
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
	}
	/*
	 * Con este metod crearemos el elemento raiz y los subelementos
	 */
	public void crearArbolDOM() {

		// creamos el elemento raíz "Libros" qu es la etiqueta que se creara
		Element docEle = dom.createElement("libros");
		//Se lo asignamos al document
		dom.appendChild(docEle);
		// Vamos iterando por el ArrayList 
		Iterator it = libros.iterator();
		//Generamos el bucle que recorrera nuestros Objetos
		while (it.hasNext()) {
			Libro e = (Libro) it.next();
			// para cada objeto libro creamos el elemento <libro> 
			//y lo añadimos a la raíz
			Element libroEle = setLibro(e);
			docEle.appendChild(libroEle);//Añadimos en el elemento 
		}
	}
	/*
	 * Para crear el arbol jerarquico del arbol creamos el elemento raiz y 
	 * sus nodos
	 */
	
	private Element setLibro(Libro lib) {

		// creamos el elemento libro
		Element LibroEle = dom.createElement("libros");

		// creamos el elemento nombre y el nodo de texto y lo añadimos al elemento persona
		Element tituloEle = dom.createElement("titulo");//Creamos el Titulo		
		Text tituloTexto = dom.createTextNode(lib.gettitulo());//creamos un nodo de texto
		tituloEle.appendChild(tituloTexto);//Lo añadimos 
		LibroEle.appendChild(tituloEle);//Lo añadimos al elemento

		// creamos el elemento autor y el nodo  y lo añadimos al elemento persona
		Element autorEle = dom.createElement("autor");//Creamos el Autor	
		Text autorTexto = dom.createTextNode(lib.getautor());//creamos un nodo de texto
		autorEle.appendChild(autorTexto);//Lo añadimos
		LibroEle.appendChild(autorEle);//Lo añadimos al elemento
		
		return LibroEle;
	}
	/*
	 * Generamos el metodo para pasar de una estructura Dom  a un documento Xml
	 */
	public void escribirDocumentAXml(File file) throws TransformerException {

		// creamos una instacia para escribir el resultado mediante Transformer y la factory
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT, "yes");//Añdimos propiedad para contemplar los saltos de linea

		// especificamos dónde escribimos y la fuente de datos
		StreamResult result = new StreamResult(file);//Tipo que demanda para hacer la transformacion, pasamos file
		DOMSource source = new DOMSource(dom);//Fuente de datos Source, le pasamos el dom
		// source tipo de fuente y result como destino y crea el fichero
		trans.transform(source, result);//Transformacion
	}
}
