package Marshaller_XL;

import java.io.File;
import java.util.ArrayList;
import javax.xml.transform.TransformerException;

public class Marshaller_Libro {

	public static void main(String[] args) {
		ArrayList<Libro> libros;
		//Cargamos los datos en el ArrayList
		libros=new ArrayList<Libro>();
		libros.add(new Libro("El mundo aasdde sofia","pepe" ));
		libros.add(new Libro("Jamon,Jamon","Manolito"));
		//Creamos nuestros objeto Marshaller al que le pasamos el ArrayList
		Marshaller marshaller = new Marshaller(libros);
		
		marshaller.crearDocumento();//Creamos el documento
		marshaller.crearArbolDOM();//Creams el arbol
		/*
		 * Para pasar de un estructura DOM  a una XML teemos que declarar el 
		 * fichero xml con la clase file
		 */
		File file = new File("Libro.xml");
		//Tratamos la excepcion de la conversion
		try {
			//Llamamos al metodo para transformar el documento de DOM a xml
			marshaller.escribirDocumentAXml(file);
		} catch (TransformerException e) {			
			e.printStackTrace();
		}
	}
}