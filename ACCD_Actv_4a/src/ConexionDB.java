import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class ConexionDB {

	// DATOS DE LA CONEXION
		static final String CONTROLADOR_MYSQL= "com.mysql.jdbc.Driver";
		
		//DATOS DE LA BBDD
		private String host;
		private String bbdd;
		private String user;
		private String pass;
		private String url;
		
		//DATOS POR DEFECTO
		private static final String HOST="localhost";
		private static final String BBDD="accesodatos";
		private static final String USER="root";
		private static final String PASS="GABI4450";
		
		//Conexion
		static Connection conexion = null;// maneja la conexió
		
		//Instancia unica
		private static ConexionDB instance = null;
		
		public ConexionDB(String HOST,String BBDD,String USER,String PASS) {
			this.host=HOST;
			this.bbdd=BBDD;
			this.user=USER;
			this.pass=PASS;
			this.url="jdbc:mysql://"+this.host+"/"+this.bbdd;
		}
		
		//Implementar SingleTon
		public static ConexionDB getInstance(String HOST,String BBDD,String USER,String PASS) {
			if(instance == null) {
			         instance = new ConexionDB(HOST,BBDD,USER,PASS);
			}
			return instance;
			}
	public boolean connectDB(){
		try{
			//Lo primero es cargar el controlador Mysql el cual automaticamente se registra
			Class.forName(CONTROLADOR_MYSQL);
			//Conectarnos a la BBDD
			conexion =  DriverManager.getConnection(this.url,this.user,this.pass);
		   }
		//Excepcion en el caso de error de sql
		catch( SQLException excepcionSql ) 
		{
			excepcionSql.printStackTrace();
			return false;
		}
		//Excepcion en el caso de clase no encontrada
		catch(ClassNotFoundException noEncontroClase)
		{
			noEncontroClase.printStackTrace();
			return false;
		}
		
		return true;
	}
	//Creamos un metodo que nos devolvera la conexion
	public Connection getConexion(){
		return this.conexion;
	}
}
		

