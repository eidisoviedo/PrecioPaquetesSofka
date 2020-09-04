package co.com.prueba_tecnica.util;

import static co.com.prueba_tecnica.util.Constantes.TITULO_POP_ERROR;
import static co.com.prueba_tecnica.util.Constantes.TITULO_POP_INFORMACION;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class Mensaje {

	public static void mensajeDeError(String mensaje) {
		showMessageDialog(null, mensaje, TITULO_POP_ERROR, ERROR_MESSAGE);
	}

	public static void mensajeInformativo(String mensaje) {
		showMessageDialog(null, mensaje, TITULO_POP_INFORMACION, INFORMATION_MESSAGE);
	}

	private Mensaje() {
	}
}
