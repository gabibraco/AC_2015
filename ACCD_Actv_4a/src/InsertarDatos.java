import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.ResultSetMetaData;

public class InsertarDatos {
		//DEVOLVER DATOS
		private static String DATOS_LIST="INSERT INTO Acceso (Id,Asignatura,Nombre,Inicio,Fin,Entregada) VALUES (?,?,?,?,?,?)";
		
		//Conexion
		private Connection conexion = null;// maneja la conexión
		Statement instruccion;//Crea el Statement
		
		//Recuperamos la conexion
		public InsertarDatos(Connection conexion) {
			this.conexion=conexion;
		}
		//Generamos un nuevo metodo quue nos devolvera los datos al cual asignamos una excepcion
		public void setDatos() throws Throwable {
			try{
				//Creamos nuestra Instruccion que nos preparara el Statement para la conexion
				PreparedStatement instruccion =  this.conexion.prepareStatement(DATOS_LIST);
				//Definimos los valores a ingresar
				 int ID_COL=20;
				 String ASIGNATURA_COL="EIE";
				 String NOMBRE_COL="1z";
				 Date INICIO_COL=  Date.valueOf("2015-12-03");
				 Date FIN_COL=Date.valueOf("2015-12-04");
				 Boolean ENTREGADA_COL=false;
				//Pasamos los valores a la instruccion para añadirlos a la BBDD con su identificacion de posicion
				 instruccion.setInt(1,ID_COL);
				 instruccion.setString(2,ASIGNATURA_COL);
				 instruccion.setString(3,NOMBRE_COL);
				 instruccion.setDate(4,INICIO_COL);
				 instruccion.setDate(5,FIN_COL);
				 instruccion.setBoolean(6,ENTREGADA_COL);
				 instruccion.executeUpdate();
				
				
				}
			catch (SQLException e) {
				 //Tratamos una excepcion  que nos dara un error en caso de existir un error de identificacion
				if(e.getSQLState().equals("28000"))
					System.out.println("Error de autentificación");
				else 
					throw e;
				e.printStackTrace();
				}
			finally{
				 try{
					 //Traatamos una excepcion en el caso que la instruccion no este cerrada
					if(instruccion!=null && !instruccion.isClosed())
						 //Cerramos la instruccion y lanzamos excepcion en el caso de no cerrarse
							instruccion.close();
				 }catch(SQLException e){
					 e.printStackTrace();
					 //Registramos los errores que se pueden producir en el cierre
					 Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, e);
					}
		}
	}			
}
