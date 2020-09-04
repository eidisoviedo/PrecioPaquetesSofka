
package co.com.prueba_tecnica.gestion;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;

import java.util.ArrayList;
import java.util.List;

import co.com.prueba_tecnica.paquete.Paquete;
import static co.com.prueba_tecnica.util.Mensaje.*;

import static co.com.prueba_tecnica.util.Constantes.*;

public class Inicio {

	private static int pesoPermitido = 18000;
	private static float precioDolar = 3715.01f;
	private static List<Paquete> listaDePaquetes = new ArrayList<>();

	public static void main(String[] args) {
		visualizar();
	}

	public static void visualizar() {
		int opcion = 0;
		do {
			try {
				opcion = Integer.parseInt(
						showInputDialog(null, "Registro de Carga BOING 747 \n" 
								+ "\n1. Registrar paquete"
								+ "\n2. Mostrar informacion de carga" 
								+ "\n0. Salir \n", "Menú",
								INFORMATION_MESSAGE)
						);

				switch (opcion) {
					case 0:
						mensajeInformativo(INFO_DESPEDIDA);
						break;
					case 1:
						opcRegistrarPaquete();
						break;
					case 2:
						opcMostrarInformacion();
						break;
	
					default:
						mensajeDeError(ERROR_OPCION_INVALIDA);
						break;
				}
			} catch (NumberFormatException e) {
				mensajeDeError(ERROR_OPCION_INVALIDA);
			}

		} while (opcion != 0);
	}

	public static void opcRegistrarPaquete() {
		int peso = -1;
		do {
			try {
				peso = Integer.parseInt(showInputDialog(null,INFO_INGRESE_PESO, PLAIN_MESSAGE));
				
				if((pesoPermitido - peso) < 0) {
					mensajeInformativo(INFO_CAPACIDAD_ALCANZADA);
				}else {
					if(peso > 0 && peso <= 500) {
						Paquete paquete = new Paquete(peso);
						paquete.calcularPrecio();
						pesoPermitido -= peso;
						listaDePaquetes.add(paquete);
						mensajeInformativo(INFO_TRANSACCION_EXITOSA);
					}else {
						mensajeDeError(ERROR_CAPACIDAD_ALCANZADA);
					}
				}
			} catch (NumberFormatException e) {
				mensajeDeError(ERROR_INGRESO_PESO);
			}
		} while (peso < 0 || peso > 500);

	}

	private static void opcMostrarInformacion() {
		String informacion = "INFORMACIÓN DE CARGA BOING 747"
					.concat("\nCapacidad restante: " + pesoPermitido)			
					.concat("\nNúmero de paquetes: " + numeroDePaquetes())
					.concat("\nPaquete más pesado: " + paqueteMasPesado())
					.concat("\nPaquete más liviano: " + paqueteMasLiviano())	
					.concat("\nPeso promedio de carga: " + pesoPromedioDeCarga())
					.concat("\nPeso total de carga en pesos: $" + precioTotalDeCargaEnPeso())
					.concat("\nPeso total de carga en Dolares: $" + precioTotalDeCargaEnDolar());			
		
		mensajeInformativo(informacion);
	}

	public static int numeroDePaquetes() {
		return listaDePaquetes.size();
	}

	public static float paqueteMasPesado() {
		float peso = 0;
		for (Paquete paquete : listaDePaquetes) {
			if (paquete.getPeso() > peso) {
				peso = paquete.getPeso();
			}
		}
		return peso;
	}

	public static float paqueteMasLiviano() {
		float peso = listaDePaquetes.get(0).getPeso();
		for (Paquete paquete : listaDePaquetes) {
			if (paquete.getPeso() < peso) {
				peso = paquete.getPeso();
			}
		}
		return peso;
	}

	public static float pesoPromedioDeCarga() {
		float promedio = 0;
		for (Paquete paquete : listaDePaquetes) {
			promedio += paquete.getPeso();
		}
		return promedio / listaDePaquetes.size();
	}

	public static float precioTotalDeCargaEnPeso() {
		float precioTotal= 0;
		for (Paquete paquete : listaDePaquetes) {
			precioTotal += paquete.getPrecio();
		}
		return precioTotal;
	}

	public static float precioTotalDeCargaEnDolar() {
		return precioTotalDeCargaEnPeso() / precioDolar;
	}

}
