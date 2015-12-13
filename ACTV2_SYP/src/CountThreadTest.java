
////// Ejemplo 1 - CountThreadTest.java Inicio /////////////
class CountThreadTest implements Runnable{
	int from; // Variable de tipo int al que llamamos from
	int to; //  Variable de tipo int al que llamamos to
	
	/*
	 * Estas dos variables que hemos definido anteriormente se las pasamos a la clase a traves del
	 * constructor , por lo tanto cuando generemos el objeto de esta clase en el main deberemos asignarle
	 * un valor numerico.
	 */
  public CountThreadTest(int from, int to) { // 
		this.from = from;
		this.to = to;
  }

  public void run() {
	  for (int i=from; i<to; i++) {
		  System.out.println(toString() + " i : " + i);
/* 
	Con el metodo run lo que pretendemos es inicializar los hilos o thread, ademas dentro de este hemos 
	generado un bucle for donde a la i le damos el valor de nuestra primera variable (from) , y le indicamos
	que mientras i sea menor que la otra variable to continue, que imprima por pantalla el valor de from.
	Es decir i sera igual a from y hasta que from no sea igual al valor de to continuara con la iteracion, y 
	imprimira por pantalla a traves del metodo tostring el valor de from mas el numero de iteraciones de i.
*/
	  } 
  	} 
/* 
En el main generamos una nueva iteracion que se realizara 10 veces ( cada accion que hemos definido en el metodo run
es decir que por cada posicion de from realizara 10 la iteracion del metodo run) , y dentro de ella generamos un objeto
de la clase al cual le asignamos los valores numericos de from (i*10) y de to ((i+1)*10), lo cual nos da como resultado
algo similar a esto:Thread[Thread-4,5,main] i : 43
Thread[Thread-4,5,main] i : 44
Thread[Thread-4,5,main] i : 45
Thread[Thread-4,5,main] i : 46
Thread[Thread-0,5,main] i : 3
Thread[Thread-5,5,main] i : 50
Thread[Thread-1,5,main] i : 12
.
.
.
*/
  public static void main(String[] args) {
	  for (int i=0; i<10; i++) { // 
		  CountThreadTest t ;
		  t = new CountThreadTest(i*10,(i+1)*10);
		  Thread thread;
		  thread =new Thread(t);
		  thread.start(); // start invoca a run de CountThreadTest
	  } 
  } 
} 
//////// Ejemplo CountThreadTest.java Fin /////////////
