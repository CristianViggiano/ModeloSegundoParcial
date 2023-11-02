package junio2022;

import java.util.ArrayList;
import java.util.List;

/*
 * Ejercicio 2 (4p):
 * 
 *Escribir un método que reciba dos listas como parámetros y devuelva
 *una tercera lista que sea la diferencia entre la primera y la
 *segunda. La diferencia entre dos listas son los objetos que están
 *en la primera lista pero no en la segunda. Considere que los
 *objetos que están contenidos en las listas tienen orden total
 *(implementarán: Comparable y tienen implementado su propio equals
 *y hashCode).
 * 
 */

public class Diferencia {
	
	public List<T> diferencia(List<T> l1, List<T> l2){
		ArrayList<T> salida = new ArrayList<T>();
		for(T a : l1) {
			if (!l2.contains(a)) {
				salida.add(a);
			}
		}
		return salida;
	}
	
	public static void main(String[] args) {
		Diferencia dif = new Diferencia();
		List<T> l1 = new ArrayList<T>();
		List<T> l2 = new ArrayList<T>();
		T t1 = new T(1);
		T t2 = new T(2);
		T t3 = new T(3);
		T t4 = new T(4);
		T t5 = new T(5);
		
		l1.add(t1);
		l1.add(t2);
		l1.add(t3);
		l1.add(t4);
		
		l2.add(t3);
		l2.add(t4);
		l2.add(t5);
		
		System.out.println(dif.diferencia(l1,l2));
	}

}
