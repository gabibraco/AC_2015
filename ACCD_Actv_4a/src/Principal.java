
public class Principal {
	private static final String ASIGNATURA_COL = null;
	private static  String Asigntura = null;
	static ConexionDB Principal;
	static RecuperarDatos recuperar;
	static InsertarDatos insertar;
	public static void main(String[] args) throws Throwable {
		
		
		
		Principal = ConexionDB.getInstance("localhost","accesodatos","root","GABI4450");
		if  (Principal.connectDB()==true){
			System.out.println("Conexion con exito");
			insertar = new InsertarDatos(Principal.getConexion());
			insertar.setDatos();
			recuperar =new RecuperarDatos(Principal.getConexion());
			recuperar.getDatos(ASIGNATURA_COL);
			
		}else {
			System.out.println("error");
		}
			
	}

}
