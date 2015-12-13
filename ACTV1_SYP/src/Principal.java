
public class Principal {
	
	static class HILO1 extends Thread {
		public void run(){
			for(int i=0;i<10;i++){
				System.out.println("Hola hilo 1 " +i);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Finaliza el hilo 1");
		}
	}
	static class HILO2 extends Thread {
		public void run(){
			for(int j=0;j<10;j++){
				System.out.println("Soy el hilo 2 y este es mi ciclo"+j);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Finaliza el hilo 2");
		}
	}

	public static void main(String[] args) {
		HILO1 thread;
		thread = new HILO1();
		thread.start();
		
		HILO2 thread1;
		thread1 = new HILO2();
		thread1.start();
		try {
			thread1.join();
			System.out.println("main terminado");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
