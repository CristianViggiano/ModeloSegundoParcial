package noviembre2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ventas {
	private Map<String, Integer> ventasPorProducto;
	public Ventas() { /* TODO */ }
	
	public void leerVentas(String entrada) {
		ventasPorProducto = new HashMap<String, Integer>();
		try {
			File archivo = new File(entrada);
			
			BufferedReader lector = new BufferedReader(new FileReader(archivo));
			String linea;
			
			while ((linea = lector.readLine()) != null) {
				String[] lineaSpliteada = linea.split(" ");
				String codigoProducto = lineaSpliteada[0];
				Integer cantidadVentas = Integer.parseInt(lineaSpliteada[1]);
				
				if (ventasPorProducto.containsKey(codigoProducto)) {
					ventasPorProducto.put(codigoProducto, ventasPorProducto.get(codigoProducto) + cantidadVentas);
				} else {
					ventasPorProducto.put(codigoProducto, cantidadVentas);
				}
			}
			
			lector.close();
			System.out.println(ventasPorProducto);
		} catch(IOException e) {
			System.err.println("Error al leer el archivo:  " + e.getMessage());
		}
	}
	
	private void escribirArchivo(List<String> contenido, String rutaArchivo) {
		File archivo = new File(rutaArchivo);
		if (!archivo.exists()) {
			try {
				BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, false));
				
				for (String linea : contenido) {
					escritor.write(linea);
					escritor.newLine();
				}
				
				escritor.close();
				System.out.println("Contenido escrito en el archivo exitosamente.");
			} catch(IOException e) {
				System.err.println("Error al escribir en el archivo: " + e.getMessage());
			}
			
		} else {
			System.err.println("El archivo existe. No se puede escribir uno nuevo.");
		}
	}
	
	public void escribirVentasPorProducto(String salida) {
		List<String> codigoProductos = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : ventasPorProducto.entrySet()){
			codigoProductos.add(entry.getKey() + " : " + entry.getValue());
		}
		escribirArchivo(codigoProductos, salida);
		//System.out.println(codigoProductos);
	}
	
	public static void main(String[] args) throws IOException {
		Ventas ventas = new Ventas();
		ventas.leerVentas("src/ventas.in");
		ventas.escribirVentasPorProducto("src/ventasPorProducto.out");
	}
}	
 