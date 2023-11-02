package modeloParcial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class RegistroPersonas {
	
	/*
	 * 1-Implementar un método getPersonas  de la class RegistroPersonas
	 * que reciba el nombre de un archivo y devuelva un objeto
	 * LinkedList<Persona> con personas que fueron leídas del archivo de
	 * texto con formato "dni apellido edad" (Integer String Integer);
	 */
	
	public LinkedList<Persona> getPersona(String archivo){		
		LinkedList<Persona> salida = new LinkedList<Persona>();;
		try {
			File f = new File(archivo);
			
			BufferedReader lector = new BufferedReader(new FileReader(f));
			String linea;
			while ((linea = lector.readLine()) != null) {
				String[] lineaSpliteada = linea.split(" ");
				
				int dni = Integer.parseInt(lineaSpliteada[0]);
				String nombre = lineaSpliteada[1];
				int edad = Integer.parseInt(lineaSpliteada[2]);
				
				salida.add(new Persona(dni, nombre, edad));
			}
			lector.close();
		} catch(IOException e) {
			System.err.println("Error al leer el archivo:  " + e.getMessage());
		}
		return salida;
	}
	
	/*
	 * 2-Implementar un método getPersonasMayoresAEdad que reciba un objeto
	 * LinkedList<Persona> y una edad y devuelva otro objeto LinkedList<Persona>
	 * con las personas cuyas edades son mayores a esa edad. Guardar esas personas
	 * en un archivo “personasMayoresDeXX.out”, donde xx sea la edad que se usó
	 * como parámetro. Guardarlo ordenado alfabéticamente
	 */
	
	public LinkedList<Persona> getPersonasMayoresAEdad(LinkedList<Persona> personas, int edad){
		File archivo = new File("src/personasMayoresDe" + edad + ".out");
		LinkedList<Persona> ordenadas = new LinkedList<Persona>();
		Collections.sort(personas);
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, false));
	
			for (Persona persona : personas) {
				if (persona.getEdad() > edad) {
					escritor.write(persona.toString());
					escritor.newLine();
					ordenadas.add(persona);
				}
			}
			
			escritor.close();
			System.out.println("Contenido escrito en el archivo exitosamente.");
		} catch(IOException e) {
			System.err.println("Error al escribir en el archivo: " + e.getMessage());
		}
		return ordenadas;
	}
	
	/*
	 * 3-Implementar un método que devuelva la edad promedio de la muestra de personas.
	 */
	public int getEdadPromedio() {
		int acc = 0;
		LinkedList<Persona> personas;
		personas = getPersona("src/personas.in");
		for (Persona persona : personas) {
			acc += persona.getEdad();
		}
		if (personas.size() == 0 ) return 0;
		return acc/personas.size();
	}
	
	/*
	 * 4. Implementar un método que devuelva la cantidad de personas cuya edad
	 * está por encima de la edad promedio.
	 */
	
	public int getCantidadSobreElPromedio() {
		int acc = 0;
		int edadPromedio = getEdadPromedio();
		LinkedList<Persona> personas;
		personas = getPersona("src/personas.in");
		for (Persona persona : personas) {
			if (persona.getEdad() > edadPromedio)
				acc++;
		}
		return acc;
	}
	
	/*
	 * 5. ¿Cual es la persona de mayor edad?, si hubiera varias, mostrarlas a todas. 
	 */
	public String getMayor() {
		int mayor = 0;
		String salida = "";
		LinkedList<Persona> personas;
		personas = getPersona("src/personas.in");
		for (Persona persona : personas) {
			if (persona.getEdad() > mayor)
				mayor = persona.getEdad();
		}
		for (Persona persona : personas) {
			if (persona.getEdad() == mayor)
				salida += persona.toString() + "\n";
		}
		return salida;
	}
	
	public static void main(String[] args) {
		RegistroPersonas reg = new RegistroPersonas();
		LinkedList<Persona> ordenadas = new LinkedList<Persona>(reg.getPersonasMayoresAEdad(reg.getPersona("src/personas.in"), 35));
		System.out.println(ordenadas);
		System.out.println("Edad Promedio : " + reg.getEdadPromedio());
		System.out.println("Personas sobre la edad Promedio : " + reg.getCantidadSobreElPromedio());
		System.out.println("Personas de Mayor edad:\n" + reg.getMayor());

	}

}
