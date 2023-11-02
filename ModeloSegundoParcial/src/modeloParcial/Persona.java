package modeloParcial;

public class Persona implements Comparable<Persona>{
	
	private int dni;
	private String nombre;
	private int edad;

	public Persona(int dni, String nombre, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String toString() {
		return dni + "," + nombre + "," + edad;
	}
	
	@Override
	public int compareTo(Persona p) {
		int comparedEdad = p.getEdad();
		if (this.edad > comparedEdad) {
			return 1;
		}else if (this.edad == comparedEdad) {
			return 0;
		}else {
			return -1;
		}
	}

}


