/*
 * Actividad4:Realiza un programa en el que crees una clase 
 * llamada Animal y tres objetos de dicha clase: Tortuga, liebre, 
 * guepardo. Asigna un hilo a cada uno de ellos de forma que se 
 * ejecuten concurrentemente y  utiliza la asignación de prioridades 
 * para establecer quién llegará el primero.
 */
public class Animal extends Thread{
	//Definimmos una variable que recogera el nombre del animal
	private String nombre;
	
public Animal(String nombre){	
	this.nombre=nombre;
}
	//Declaramos el metodo run , donde definimos el bucle
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("Corre el animal "+ nombre +i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Finaliza el Animal "+ nombre);
	}
	public static void main(String[] args) {
		
		//Declaramos el Objeto tortuga con min_priority
		Animal tortuga = new Animal("Tortuga");
		tortuga.setPriority(MIN_PRIORITY);
		tortuga.start();
		
		//Declaramos el Objeto liebre con min_priority
		Animal liebre =new Animal("Liebre");
		liebre.setPriority(NORM_PRIORITY);
		liebre.start();
		
		//Declaramos el Objeto guepardo con min_priority
		Animal guepardo =new Animal("Guepardo");
		guepardo.setPriority(MAX_PRIORITY);
		guepardo.start();
	
	}
}
