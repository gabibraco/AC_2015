package Programa;

import java.util.Date;



public class Pedio {
	private int id;
	private Date fecha;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void print(){
		System.out.println("Codigo: "+id+" Fecha: "+fecha);
	}
}
