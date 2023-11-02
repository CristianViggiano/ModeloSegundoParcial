package junio2022;

import java.util.Objects;

public class T implements Comparable<T> {
	private int valor;
	
	public T(int valor) {
		this.valor = valor;
	}

	@Override
	public int compareTo(T o) {
		if (this.valor == o.valor) return 1;
		return 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		T other = (T) obj;
		return valor == other.valor;
	}

	@Override
	public String toString() {
		return "[t" + valor + "]";
	}
	
	

}
