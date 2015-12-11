import java.sql.Date;


public class Actividad {
	private  int Id=0;
	private  String Asignatura="";
	private  String Nombre="";
	private  Date Inicio;
	private  Date Fin;
	private  boolean Entregada;
		
	public Actividad(int Id, String Asignatura, String Nombre, Date Inicio,
			Date Fin, boolean Entregada) {
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Date getInicio() {
		return Inicio;
	}

	public void setInicio(Date inicio) {
		Inicio = inicio;
	}

	public Date getFin() {
		return Fin;
	}

	public void setFin(Date fin) {
		Fin = fin;
	}

	public boolean isEntregada() {
		return Entregada;
	}

	public void setEntregada(boolean entregada) {
		Entregada = entregada;
	}

	public void Actvidad(String Asignatura){
		this.Asignatura=Asignatura;	
	}
	public String getAsignatura() {
		return Asignatura;
	}

	public void setAsignatura(String Asignatura) {
		this.Asignatura = Asignatura;
	}
	

}
