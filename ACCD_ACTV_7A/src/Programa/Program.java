package Programa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
	//Definicion de variables
	static String name;
	static int edad;
	static int codigo;
	static String cif;
	static boolean fin =true;
	static int Seleccion;
	static int empleados;
	static String direccion;
	static String fecha;
	static int cantidad;
	
	public static void main(String[] args) {
		
		System.out.println("Hola");
		//Creamos un objeto  de la clase datos
		Datos datos = new Datos();
		//Generamos un bucle para volver a pedir los datos por consola hasta que no se quiera
		while(fin){
		//Pedios al usuario que determine una accion a realizar
		System.out.println("Introduce la accion a realizar: " + "\n" +
							"0 Salir" + "\n" +
							"1 Insertar Empresa" + "\n" + 
							"2 Recuperar Empresa" + "\n" + 
							"3 Insertar Pedido" + "\n" +
							"4 Recuperar Pedido" + "\n" +
							"5 Insertar Detalle Pedido"+ "\n" +
							"6 Recuperar Detalle Pedido");
		//Creamos nuestro Scanner
		Scanner entradaEscaner = new Scanner (System.in);
		//Recogemos la eleccion con el scanner y lo asignamos a una varaible Seleccion
		Seleccion = entradaEscaner.nextInt();
		if(Seleccion==0){
			//Variable sera false
			fin=false;
			//Imprimimos por pantalla
			System.out.println("Bye Bye");
			
		}
		//Establecemos las acciones segun la seleccion escogida
		if (Seleccion==1){
			/*
			 * Introducimos los datos que pedimos por consola y lo recogemos 
			 * con Scanner y se lo pasamos a una variable.
			 */
			System.out.println("Introduce Codigo Empresa: ");
			codigo=entradaEscaner.nextInt();
			System.out.println("Introduce CIF Empresa: ");
			cif=entradaEscaner.next();
			System.out.println("Introduce Nombre Empresa: ");
			name=entradaEscaner.next();
			System.out.println("Introduce numero Empleados: ");
			empleados=entradaEscaner.nextInt();
			System.out.println("Introduce Direccion Empresa: ");
			direccion=entradaEscaner.next();
			//Pasamos los datos por parametros
			datos.InsertarEmpresa(codigo,cif,name,empleados,direccion);
			
		}
		if(Seleccion==2){
			//Pedimos por consola el nombre de la persona a recuperar.
			System.out.println("Introduce Codigo Empresa a recuperar: ");
			codigo=entradaEscaner.nextInt();			
			//Pasamos los parametros	
			datos.RecuperarEmpresa(codigo);
			
		}
		if(Seleccion==3){
			//Pedimos por consola los datos
			System.out.println("Introduce codigo Pedido: ");
			codigo=entradaEscaner.nextInt();
			System.out.println("Introduce fecha con formato yyyy-mm-dd: ");
			String fecha=entradaEscaner.next();
			//Pasamos los parametros
			datos.InsertarPedido(codigo,fecha);
		}
		if(Seleccion==4){
			//Pedimos por consola los datos
			System.out.println("Introduce codigo Pedido: ");
			codigo=entradaEscaner.nextInt();
			//Pasamos los parametros	
			datos.RecuperarPedido(codigo);
		}
		if(Seleccion==5){
			//Pedimos por consola los datos
			System.out.println("Introduce codigo detalle Pedido: ");
			codigo=entradaEscaner.nextInt();
			System.out.println("Introduce Nombre producto: ");
			name=entradaEscaner.next();
			System.out.println("Introduce codigo la cantidad: ");
			cantidad=entradaEscaner.nextInt();
			//Pasamos los parametros
			datos.InsertarItem(codigo,name,cantidad);
		}
		if(Seleccion==6){
			//Pedimos por consola los datos
			System.out.println("Introduce codigo pedido para ver detalle: ");
			codigo=entradaEscaner.nextInt();
			//Pasamos los parametros	
			datos.RecuperarItem(codigo);
		  }
		}
	}
}
	/*
	Program p = new Program();
	List<Empresa> resultado =listempresas(name);
	String name = "Manolo";
	//if(!resultado.isEmpty()){
		//Y lo recorremos con el iterator
		Iterator<Empresa> it = resultado.iterator();
			while(it.hasNext()){
				Empresa z=(Empresa)it.next();
				//Imprimimos el resultado en pantalla
				z.print();	
			}*/
		
		
	
			
		//Session session = HibernateUtilities.getSessionFactory().openSession();
		/*
		session.beginTransaction();
		Empresa u = new Empresa();
		u.setCif("X11122233C");
		u.setNombre("Manolo");
		u.setDireccion("C/Turia 5");
		u.setEmpleados(13);
		session.save(u);
		session.getTransaction().commit();
		*/
		/*
		session.beginTransaction();
		Empresa u = session.load(Empresa.class,2);
		System.out.println("Hemos recuperado "+u.getNombre()+" "+u.getDireccion()+" "+u.getCif()+" "+u.getEmpleados());
		session.getTransaction().commit();
		 private static List<Empresa> listempresas(String name) {
			 Session session = HibernateUtilities.getSessionFactory().openSession();
		        session.beginTransaction();
		        List<Empresa> result = ((List<Empresa>)session.createQuery("from Empresa").list());
		        for ( Empresa n1 : result) {
		        	result.add(n1);	
		        		if(n1.getNombre()==name);{
		        			//System.out.println(n1.getNombre()+n1.getDireccion()+n1.getCif()+n1.getEmpleados());
		        		}
		        	}
		        session.getTransaction().commit();        
		        session.close();   
		        return result;
	} */
		 
