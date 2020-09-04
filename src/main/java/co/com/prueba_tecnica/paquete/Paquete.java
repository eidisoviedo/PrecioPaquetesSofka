package co.com.prueba_tecnica.paquete;

public class Paquete {

	private float peso;
	private float precio;

	public Paquete(int peso) {
		this.peso = peso;
	}

	public void calcularPrecio() {
		
		if (peso > 0 && peso <= 25) {
			
			precio = 0;
			
		} else if(peso > 25 && peso <= 300) {
			
			precio = peso * 1500f;
			
		} else if (peso > 300 && peso <= 500) {
			
			precio = peso * 2500f;
		}
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public float getPrecio() {
		return precio;
	}

}