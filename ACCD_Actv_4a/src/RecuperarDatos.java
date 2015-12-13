import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.ResultSetMetaData;
public class RecuperarDatos {
	//DEVOLVER DATOS
	private static String DATOS_LIST="SELECT * FROM Acceso";
	//Declaramos nuestras columnas
	private static String ID_COL="Id";
	private static String ASIGNATURA_COL="Asignatura";
	private static String NOMBRE_COL="Nombre";
	private static String INICIO_COL="Inicio";
	private static String FIN_COL="Fin";
	private static String ENTREGADA_COL="Entregada";
	private static String COLUMNAS[]={ID_COL,ASIGNATURA_COL,NOMBRE_COL,INICIO_COL,FIN_COL,ENTREGADA_COL};
	
	private ArrayList<Actividad> Consulta=null;
	
	//Conexion
	private Connection conexion = null;// maneja la conexión
	Statement instruccion = null;
	ResultSet conjuntoResultados = null;
	
	//Recuperamos la conexion
	public RecuperarDatos(Connection conexion) {
		this.conexion=conexion;
	}
	//Generamos un nuevo metodo quue nos devolvera los datos al cual propagamos una excepcion 
	public void getDatos(String asignaturaCol) throws SQLException {
		try{
			//Creamos nuestra Instruccion que nos preparara el Statement para la conexion
			instruccion =  this.conexion.createStatement();
			//Creamos el Resulset al cual le pasamos la instruccion que queremos realizar 
			conjuntoResultados = instruccion.executeQuery(DATOS_LIST);

			//Listaremos por pantalla los datos
				while( conjuntoResultados.next() ) {
						System.out.print(conjuntoResultados.getInt(ID_COL)+";");
						System.out.print(conjuntoResultados.getString(ASIGNATURA_COL)+";");
						System.out.print(conjuntoResultados.getString(NOMBRE_COL)+";");
						System.out.print(conjuntoResultados.getDate(INICIO_COL)+";");
						System.out.print(conjuntoResultados.getDate(FIN_COL)+";");
						System.out.println(conjuntoResultados.getBoolean(ENTREGADA_COL));
					}// fin de while
				}
		 catch (SQLException e) {
			 //Tratamos una excepcion , que ns dara un error en caso de existir un error de identificacion
				if(e.getSQLState().equals("28000"))
					System.out.println("Error de autentificación");
				else 
					throw e;
				e.printStackTrace();
		 }
				finally{
					try{
						//Tratamos la excepcion en el caso de que la conexion no este cerrada 
						if(conexion!=null && !conexion.isClosed())
							conexion.close();
					}catch(SQLException e){
						 //Registramos los errores que se pueden producir en el cierre
						Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, e);
					}
						
						//Tratamos la excepcion en el caso de que la instruccion no este cerrada 
						try{
							if(instruccion!=null && !instruccion.isClosed())
								instruccion.close();
						}catch(SQLException e){
							 //Registramos los errores que se pueden producir en el cierre
							Logger.getLogger(ConexionDB.class.getName()).log(Level.WARNING, null, e);
						}
				}
		}
}