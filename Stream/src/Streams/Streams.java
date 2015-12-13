package Streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Streams {

	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("entrada.txt");
		BufferedReader br = new BufferedReader(fr);
		
		
		//FileWriter fw = new FileWriter("salida.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt"));
		
		String str;
		while((str=br.readLine())!=null){
			System.out.println("He leido  " +str);
			bw.write(str + "\n");
			
			
		}
		bw.close();
		fr.close();
	}
	

}
