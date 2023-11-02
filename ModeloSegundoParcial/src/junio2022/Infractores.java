package junio2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Infractores {
	
	/* Ejercicio 1 (6p):
	 * 
	 * Se recibe un archivo "infractores.in" con las patentes de los autos
	 * registrados por una cámara que censa exceso de velocidad. Los datos
	 * vienen de la siguiente manerea: chapa patente(Alfanumerica) y separado
	 * por un espacio en blanco la velocidad censada.
	 * 
	 * La cámara está ubicada en un sector que tiene un límite de velocidad de
	 * 80 km/h. Cada multa por exceso de velocidad es de $50000
	 * 
	 * Se pide informar en un archivo "multados.out" cada una de las patentes
	 * infractoras y el monto a cobrar por todas sus infracciones. Puede ocurrir
	 * que la cámara tome por error alguna velocidad por debajo de la
	 * maxima, en ese caso se debe ignorar.
	 */

	private Map<String, Integer> infractores = new HashMap<String, Integer>();
	
	public void leerInfractores(String entrada){
		try {
			FileReader fr = new FileReader(new File(entrada));
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] lineaSpliteada = linea.split(" ");
				String patente = lineaSpliteada[0];
				int vel = Integer.parseInt(lineaSpliteada[1]);
				if (vel >= 80) {
					int multas = 1;
					if (infractores.containsKey(patente)) {
						multas = infractores.get(patente) + 1;
					}
					infractores.put(patente, multas);
				}
			}
			br.close();
		} catch(IOException e) {
			System.err.println("Falla al leer Archivo");
		}
		//System.out.println(infractores);	
	};
	
	public void escribirMultados(String salida){
		try {
			FileWriter fw = new FileWriter(new File(salida));
			BufferedWriter bw = new BufferedWriter(fw);
			for(Entry<String, Integer> cu : infractores.entrySet()){
				String linea = cu.getKey() + " : " + (cu.getValue() * 50000);
				bw.write(linea);
				bw.newLine();		
			}
			bw.close();
		} catch(IOException e) {
			System.err.println("Error al escribir archivo");
		}		
	};
	
	public static void main(String args[]) throws IOException{
		Infractores i = new Infractores();
		
		i.leerInfractores("src/infractores.in");
		i.escribirMultados("src/multados.out");
		
		
	};
	
}
