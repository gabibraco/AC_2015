package gestionficherosapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import gestionficheros.FormatoVistas;
import gestionficheros.GestionFicheros;
import gestionficheros.GestionFicherosException;
import gestionficheros.TipoOrden;

	public class GestionFicherosImpl implements GestionFicheros {
		//Declaracion de objetos y/o atributos
		private File carpetaDeTrabajo = null;
		private Object[][] contenido;
		private int filas = 0;
		private int columnas = 3;
		private FormatoVistas formatoVistas = FormatoVistas.NOMBRES;
		private TipoOrden ordenado = TipoOrden.DESORDENADO;
		
		
		public GestionFicherosImpl() {
			carpetaDeTrabajo = File.listRoots()[0];
			actualiza();
		}

		private void actualiza() {
			String[] ficheros = carpetaDeTrabajo.list(); // obtener los nombres
			// calcular el número de filas necesario
			filas = ficheros.length / columnas;
			if (filas * columnas < ficheros.length) {
				filas++; // si hay resto necesitamos una fila más
			}
			// dimensionar la matriz contenido según los resultados
			contenido = new String[filas][columnas];
			// Rellenar contenido con los nombres obtenidos
			for (int i = 0; i < columnas; i++) {
				for (int j = 0; j < filas; j++) {
					int ind = j * columnas + i;
					if (ind < ficheros.length) {
						contenido[j][i] = ficheros[ind];
					} else {
						contenido[j][i] = "";
					}
				}
			}
		}

		@Override
		public void arriba() {
			System.out.println("holaaa");
			if (carpetaDeTrabajo.getParentFile() != null) {
				carpetaDeTrabajo = carpetaDeTrabajo.getParentFile();
				actualiza();
			}
		}

		@Override
		public void creaCarpeta(String arg0) throws GestionFicherosException {
			File file = new File(carpetaDeTrabajo,arg0);
			try{
				//que no exista -> lanzará una excepción
				if(!file.exists()){
					try{
						//crear la carpeta,sino lanza excepcion.
						file.mkdir();
						//Comprueba los diferentes permisos de escritura, lectura y ejecucion sino lanzara las diferetes excepciones
						if(file.canWrite()&&file.canRead()&& file.canExecute()){
							System.out.println("La Carpeta tiene Permiso de Escritura");
							System.out.println("La Carpeta tiene Permiso de Lectura");
							System.out.println("La Carpeta tiene Permiso de Ejecucion");
						}else{
							throw new Exception ("La Carpeta"+ file.getAbsolutePath()+"no tiene los permisos");
						}
						//Excepcion de sino puede crearse
					}catch(Exception e){
						throw  new GestionFicherosException ("La Carpeta"+file.getAbsolutePath()+"No se puede Crear");
					}
					//Excepcion si ya existe
				}else{
					throw new Exception ("La Carpeta"+ file.getAbsolutePath()+"Existe");
				}
				//Error general al realizar la accion
			}catch(Throwable e){
				throw  new GestionFicherosException ("Error al crear la Carpeta");
			}
			//Llamamos a acualizar, para que actualice nuestra carpeta de trabajo
			actualiza(); 
		}
	
		@Override
		public void creaFichero(String arg0) throws GestionFicherosException {
			File file = new File(carpetaDeTrabajo,arg0);
			try{
				//que no exista -> lanzará una excepción
				if(!file.exists()){
					try{
						//crear la fichero,sino lanza excepcion.
						file.createNewFile();
						//Comprueba los diferentes permisos de escritura, lectura y ejecucion sino lanzara las diferetes excepciones
						if(file.canWrite()&&file.canRead()&& file.canExecute()){
							System.out.println("El Fichero tiene Permiso de Escritura");
							System.out.println("El Fichero tiene Permiso de Lectura");
							System.out.println("El Fichero tiene Permiso de Ejecucion");
						}else{
							throw new Exception ("El Fichero"+ file.getName()+"no tiene los permisos");
						}
						//Excepcion de sino puede crearse
					}catch(Exception e){
						throw  new GestionFicherosException ("El Fichero"+file.getAbsolutePath()+"No se puede Crear");
					}
					//Excepcion si ya existe
				}else{
					throw new FileNotFoundException ("El Fichero"+ file.getAbsolutePath()+"Existe");
				}
				//Error general al realizar la accion
			}catch(Throwable e){
				throw  new GestionFicherosException ("Error al crear el archivo");
			}
			//Llamamos a acualizar, para que actualice nuestra carpeta de trabajo
			actualiza(); 
		}

		@Override
		public void elimina(String arg0) throws GestionFicherosException {
			File file = new File(carpetaDeTrabajo,arg0);
			try{
				//que no exista -> lanzará una excepción
				if(file.exists()){
					try{
						//Elimina la carpeta y/o archivo,sino lanza excepcion.Conel metodo .delete
						file.delete();
						//Comprueba los diferentes permisos de escritura, lectura y ejecucion sino lanzara las diferetes excepciones
						if(file.canWrite()&&file.canRead()&& file.canExecute()){
							System.out.println("La Carpeta tiene Permiso de Escritura");
							System.out.println("La Carpeta tiene Permiso de Lectura");
							System.out.println("La Carpeta tiene Permiso de Ejecucion");
						}else{
							throw new Exception ("La Carpeta y/o Archivo"+ file.getName()+"no tiene los permisos");
						}
						//Excepcion de sino puede crearse
					}catch(Exception e){
						throw  new GestionFicherosException ("La Carpeta y/o Archivo"+file.getAbsolutePath()
								+"No se puede Eliminar");
					}
					//Excepcion si no existe
				}else{
					throw new FileNotFoundException ("La Carpeta y/o Archivo"+ file.getName()+"No Existe");
				}
				//Error general al realizar la accion
			}catch(Exception  e){
				  new GestionFicherosException ("Error no se puede Eliminar" + file.getAbsolutePath());
			}
			//Llamamos a acualizar, para que actualice nuestra carpeta de trabajo
			actualiza(); 
		}

		@Override
		public void entraA(String arg0) throws GestionFicherosException {
			File file = new File(carpetaDeTrabajo, arg0);
			// se controla que el nombre corresponda a una carpeta existente
			if (!file.isDirectory()) {
				throw new GestionFicherosException("Error. Se ha encontrado "
						+ file.getAbsolutePath()
						+ " pero se esperaba un directorio");
			}
			// se controla que se tengan permisos para leer carpeta
			if (!file.canRead()) {
				throw new GestionFicherosException("Alerta. No se puede acceder a "
						+ file.getAbsolutePath() + ". No hay permiso");
			}
			// nueva asignación de la carpeta de trabajo
			carpetaDeTrabajo = file;
			// se requiere actualizar contenido
			actualiza();

		}

		@Override
		public int getColumnas() {
			return columnas;
		}

		@Override
		public Object[][] getContenido() {
			return contenido;
		}

		@Override
		public String getDireccionCarpeta() {
			return carpetaDeTrabajo.getAbsolutePath();
		}

		@Override
		public String getEspacioDisponibleCarpetaTrabajo() {
			return null;
		}

		@Override
		public String getEspacioTotalCarpetaTrabajo() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getFilas() {
			return filas;
		}

		@Override
		public FormatoVistas getFormatoContenido() {
			return formatoVistas;
		}

		@Override
		public String getInformacion(String arg0) throws GestionFicherosException {
			
			StringBuilder strBuilder=new StringBuilder();
			File file = new File(carpetaDeTrabajo,arg0);
			
			/*Definimos la forma que tendra la fecha del archivo donde cogemos los 
			 * ms(milisegundos que nos proporciona funcion last.modified) y le damos 
			 * formato de fecha 
			 */
			Date d = new Date(file.lastModified());
			SimpleDateFormat FechaFormato = new SimpleDateFormat("EEEE MMMM d HH:mm:ss z yyyy");

			//Controlar que existe. Si no, se lanzará una excepción
			//Controlar que haya permisos de lectura. Si no, se lanzará una excepción
			if(file.exists()){
				if(file.canRead()){
					//Título
					strBuilder.append("INFORMACIÓN DEL SISTEMA");
					strBuilder.append("\n\n");
			
					//Nombre
					strBuilder.append("Nombre: ");
					strBuilder.append(arg0);
					strBuilder.append("\n");
			
					//Ubicación
					strBuilder.append("Ruta: ");
					strBuilder.append(file.getAbsolutePath());
					strBuilder.append("\n");
					
					/*Si es directorio: Espacio libre, espacio disponible, 
					espacio total*/
					//bytes
					//Tipo: fichero o directorio
					if(file.isDirectory()){
						strBuilder.append("Tipo: Directorio");
						strBuilder.append("\n");
						
						//Fecha de última modificación
						strBuilder.append("Fecha Ultima Modificacion: ");
						strBuilder.append(FechaFormato.format(d));
						strBuilder.append("\n");
				
						strBuilder.append("Espacio Libre: ");
						strBuilder.append(file.getFreeSpace() +" " + "bytes");
						strBuilder.append("\n");
				
						strBuilder.append("Espacio Disponible: ");
						strBuilder.append(file.getUsableSpace()+" " + "bytes");
						strBuilder.append("\n");
				
						strBuilder.append("Espacio Total: ");
						strBuilder.append(file.getTotalSpace()+" " + "bytes");
						strBuilder.append("\n");
						
					}else{
						strBuilder.append("Tipo: Fichero");
						strBuilder.append("\n");
						
						//Fecha de última modificación)
						strBuilder.append("Fecha Ultima Modificacion: ");
						strBuilder.append(FechaFormato.format(d));
						strBuilder.append("\n");
						
						strBuilder.append("Tamaño Total: ");
						strBuilder.append(file.length()+" "+ "bytes" );
						strBuilder.append("\n");
					}
			
					//Si es un fichero oculto o no
					if(file.isHidden()){
						strBuilder.append("Oculto: si ");
						strBuilder.append("\n");
					}else{
						strBuilder.append("Oculto: no ");
						strBuilder.append("\n");	
					}

				/*Excepciones la primera mostrara un error por pantalla si el archivo
				 * no se puede leer y el segundo si no existe el archivo*/
				}else{
					throw new GestionFicherosException("Error.El archivo" + 
							file.getAbsolutePath() + "No tiene permiso de lectura");
				}
			}else{
				throw new GestionFicherosException("Error.El archivo" + 
						file.getAbsolutePath() + "No existe");
			}
			
			return strBuilder.toString();
	}

		@Override
		public boolean getMostrarOcultos() {
			return carpetaDeTrabajo.isHidden();
		}

		@Override
		public String getNombreCarpeta() {
			return carpetaDeTrabajo.getName();
		}

		@Override
		public TipoOrden getOrdenado() {
			return ordenado;
		}

		@Override
		public String[] getTituloColumnas() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getUltimaModificacion(String arg0){
			return 0;
		}
		@Override
		public String nomRaiz(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int numRaices() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void renombra(String arg0, String arg1)throws GestionFicherosException {
			//Declaramos dos objetos de tipo File diferentes
			File file = new File(carpetaDeTrabajo,arg0);
			File file1 = new File(carpetaDeTrabajo,arg1);
			try{
				//que no exista -> lanzará una excepción
				if(file.exists()){
					try{
						/*Cambia el nombre de la carpeta y/o archivo,sino lanza excepcion.
						 * Como es booleno hay que definir una varible booleana para hacer 
						 * el cambio de nombre.*/
						 boolean cambio = file.renameTo(file1);
						//Comprueba los diferentes permisos de escritura, lectura y ejecucion sino lanzara las diferetes excepciones
						if(file.canWrite()&&file.canRead()&& file.canExecute()){
							file.renameTo(file1);
							System.out.println("La Carpeta tiene Permiso de Escritura");
							System.out.println("La Carpeta tiene Permiso de Lectura");
							System.out.println("La Carpeta tiene Permiso de Ejecucion");
						}else{
							throw new Exception ("La Carpeta"+ file.getAbsolutePath()+"no tiene los permisos");
						}
						
						//Excepcion de sino puede crearse
					}catch(Exception e){
						throw  new GestionFicherosException ("La Carpeta y/o archivo"+file.getName()+"No se puede cambiar de nombre");
					}
					//Excepcion si ya existe
				}else{
					throw new FileNotFoundException ("La Carpeta"+ file.getAbsolutePath()+"No Existe");
				}
				//Error general al realizar la accion
			}catch(Exception  e){
				  new GestionFicherosException ("Carpeta y/o archivo no ha podido cambiar de nombre");
			}
			//Llamamos a acualizar, para que actualice nuestra carpeta de trabajo
			actualiza(); 
		}

		@Override
		public boolean sePuedeEjecutar(String arg0) throws GestionFicherosException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean sePuedeEscribir(String arg0) throws GestionFicherosException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean sePuedeLeer(String arg0) throws GestionFicherosException {
			return false;
		}

		@Override
		public void setColumnas(int arg0) {
			columnas = arg0;
		}

		@Override
		public void setDirCarpeta(String arg0) throws GestionFicherosException {
			File file = new File(arg0);

			// se controla que la dirección exista y sea directorio
			if (!file.isDirectory()) {
				throw new GestionFicherosException("Error. Se esperaba "
						+ "un directorio, pero " + file.getAbsolutePath()
						+ " no es un directorio.");
			}

			// se controla que haya permisos para leer carpeta
			if (!file.canRead()) {
				throw new GestionFicherosException(
						"Alerta. No se puede acceder a  " + file.getAbsolutePath()
								+ ". No hay permisos");
			}

			// actualizar la carpeta de trabajo
			carpetaDeTrabajo = file;

			// actualizar el contenido
			actualiza();

		}

		@Override
		public void setFormatoContenido(FormatoVistas arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void setMostrarOcultos(boolean arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void setOrdenado(TipoOrden arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void setSePuedeEjecutar(String arg0, boolean arg1)
				throws GestionFicherosException {
			// TODO Auto-generated method stub

		}

		@Override
		public void setSePuedeEscribir(String arg0, boolean arg1)
				throws GestionFicherosException {
			// TODO Auto-generated method stub

		}

		@Override
		public void setSePuedeLeer(String arg0, boolean arg1)
				throws GestionFicherosException {
			// TODO Auto-generated method stub

		}

		@Override
		public void setUltimaModificacion(String arg0, long arg1)
				throws GestionFicherosException {
			
		}

	}


