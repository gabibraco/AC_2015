package Programa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;

public class Datos {
	
	/*
	 * Metodo para insertar en la tabla Empresa al que le pasamos por parametro los 
	 * datos introducidos por consola. 
	 */
	public void InsertarEmpresa(int codigo,String cif,String name,int empleados,String Direccion){
		//Declaramos nuestra session, y la abrimos
		 Session session = HibernateUtilities.getSessionFactory().openSession();
		//Empezamos la session
		session.beginTransaction();
		//Declaramos el objeto de tipo empresa
		Empresa emp = new Empresa();
		emp.setId(codigo);
		emp.setCif(cif);
		emp.setNombre(name);
		emp.setDireccion(Direccion);
		emp.setEmpleados(empleados);
		//Salvamos los datos intoducidos
		session.save(emp);
		//Forzamos el almacenamiento de datos comit
		session.getTransaction().commit();
		//Cerramos la sesion
		session.close(); 
		
	}
	/*
	 * Metodo para recuperar los datos de la tabla Empresa al que le pasamos por parametro los 
	 * datos introducidos por consola. 
	 */
	public void RecuperarEmpresa(int codigo){
		//Declaramos nuestra session, y la abrimos
		 Session session = HibernateUtilities.getSessionFactory().openSession();
		//Empezamos la session
		session.beginTransaction();
		//Creamos el objeto de tipo empresa que recuperara o buscara dentro de la tabla
		Empresa emp = session.load(Empresa.class,codigo);
		//Llamamos al metodo de empresa para imprimir por pantalla el resultado
		emp.print();
		//Forzamos el almacenamiento ccommit
		session.getTransaction().commit();
		//Cerramos la sesion
		session.close(); 
		
	}
	/*
	 * Metodo para insertar en la tabla Pedido al que le pasamos por parametro los 
	 * datos introducidos por consola. 
	 */
	public void InsertarPedido(int codigo ,String fecha){
		//Generamos un dato de tipo fecha
		Date date=new Date();
		//Damos el formato a la fecha
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//Transformamos el string a fecha
		try {
			date=df.parse(fecha);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		//Declaramos nuestra session, y la abrimos
		 Session session = HibernateUtilities.getSessionFactory().openSession();
		//Empezamos la sesion
		session.beginTransaction();
		//Declaramos el objeto de tipo Pedido
		Pedio pido = new Pedio();
		pido.setId(codigo);
		pido.setFecha(date);
		//Salvamos los datos
		session.save(pido);
		//Forzamos el almacenamiento
		session.getTransaction().commit();
		//Cerramos la sesion
		session.close(); 	
	}
	/*
	 * Metodo para recuperar los datos de la tabla Pedido al que le pasamos por parametro los 
	 * datos introducidos por consola. 
	 */
	public void RecuperarPedido(int codigo){
		//Declaramos nuestra session, y la abrimos
		 Session session = HibernateUtilities.getSessionFactory().openSession();
		//Empezamos la sesion
		session.beginTransaction();
		//Buscamos en la tabla 
		Pedio pido  = session.load(Pedio.class,codigo);
		//Imprimos por pantalla
		pido.print();
		//Cerramos la sesion
		session.getTransaction().commit();
		//Cerramos la sesion
		session.close(); 
	}
	/*
	 * Metodo para insertar en la tabla item al que le pasamos por parametro los 
	 * datos introducidos por consola. 
	 */
	public void InsertarItem(int codigo,String name,int cantidad){
		//Declaramos nuestra session, y la abrimos
		 Session session = HibernateUtilities.getSessionFactory().openSession();
		//Empezamos la sesion
		session.beginTransaction();
		//Declaramos un objeto de tipo item
		Item detalle = new Item();
		detalle.setId(codigo);
		detalle.setNombre(name);
		detalle.setCantidad(cantidad);
		//Salvamos los datos
		session.save(detalle);
		//Forzamos el almacenamiento
		session.getTransaction().commit();
		//Cerramos la sesion
		session.close(); 
	}
	/*
	 * Metodo para recuperar datos de la tabla item al que le pasamos por parametro los 
	 * datos introducidos por consola. 
	 */
	public void RecuperarItem(int codigo){
		//Declaramos nuestra session, y la abrimos
		 Session session = HibernateUtilities.getSessionFactory().openSession();
		//Empezamos la sesion
		session.beginTransaction();
		//Buscamos en la tabla 
		Item detalle = session.load(Item.class,codigo);
		//Imprimimos por pantalla
		detalle.print();
		//Forzamos el almacenamiento
		session.getTransaction().commit();
		//Cerramos la sesion
		session.close(); 
		
	}
}
