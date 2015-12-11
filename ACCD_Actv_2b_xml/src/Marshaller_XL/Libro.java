package Marshaller_XL;

import java.io.Serializable;

public class Libro implements Serializable{
	//Declaramos nuestras variables
	private String titulo = null;
	private String autor = null;
	//Sobrecarga
	public Libro() {
	}
	//Constructor alque le pasamos los atributos 
	public Libro(String titulo, String autor) {
				this.titulo = titulo;
				this.autor = autor;
			}

			public String gettitulo() {
				return titulo;
			}

			public String getautor() {
				return autor;
			}

			public void settitulo(String titulo) {
				this.titulo = titulo;
			}

			public void setautor(String autor) {
				this.autor = autor;
			}

			public void print() {
				System.out.println("titulo: " + titulo + " y autor " + autor);
			}
	}


