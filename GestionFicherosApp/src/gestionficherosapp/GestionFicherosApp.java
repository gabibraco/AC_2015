package gestionficherosapp;

import gestionficheros.MainGUI;

public class GestionFicherosApp {

	public static void main(String[] args) throws Exception {
		/*Introducimos una escepcion , de tal forma que si existe un error 
		 * sera el Main el encargado de gestionarlo*/
		
		try{
			GestionFicherosImpl getFicherosImpl = new GestionFicherosImpl();
			new MainGUI(getFicherosImpl).setVisible(true);
		}catch(Exception e ){
			throw new Exception ("ERROR");
		}finally{
			System.err.println("Continua");
		}
	}

}
