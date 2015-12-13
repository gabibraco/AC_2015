import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class ConexionDB {

	public static void main(String[] args) {
		
		 Connection conexion;
		 String HOST="jdbc:mysql://localhost/accesodatos";
		 String USER="root";
		 String PASS="GABI4450";
		
				
				//Lo primero es cargar el controlador MySQL el cual automáticamente se registra
				try {
					Class.forName("com.mysql.jdbc.Driver");
					try {
						conexion =  DriverManager.getConnection(HOST,USER,PASS);
						System.out.println("Conexion con exito");
						//Crea el statement para la conexion( prepara la conexion)
						Statement instruccion=(Statement) conexion.createStatement();
						//Pide los datos de la tabla usuarios ( o los recoje)
						ResultSet conjuntoResultados=instruccion.executeQuery("SELECT * FROM Acceso");
						//Listaremos por pantalla los datos
						while(conjuntoResultados.next()){
						//Aqui añadimos el nombre de usuario al ArrayList usuarios
							System.out.println("fila:"+
										 conjuntoResultados.getObject("ID")+
										 conjuntoResultados.getObject("Asignatura")+
										 conjuntoResultados.getObject("Nombre")+
										 conjuntoResultados.getObject("Inicio")+
										 conjuntoResultados.getObject("Fin")+
										 conjuntoResultados.getObject("Entregada"));
						
						
					} 
						conexion.close();
						}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}

	


