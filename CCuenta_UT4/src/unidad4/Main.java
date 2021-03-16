package unidad4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase contiene el método principal para iniciar el programa, el menu con
 * las opciones para el usuario y el método que gestiona las peticiones del
 * usuario.
 *
 * @author manuelramosillana
 *
 */
public class Main {
	static BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Método principal. entrada de datos con opción, cuenta en la que se van a
	 * realizar las operaciones, y cantidad con la que se va a operar
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CCuenta cuenta1;
		double saldoActual;
		int opcion = 0;
		cuenta1 = new CCuenta("Juan López", "1000-2365-85-123456789", 2500, 0);
		do {
			try {
				System.out.println("MENÚ DE OPERACIONES");
				System.out.println("-------------------");
				System.out.println("1 - Ingresar");
				System.out.println("2 - Retirar");
				System.out.println("3 - Finalizar");
				opcion = Integer.parseInt(dato.readLine());
				if (opcion == 1) {
					System.out.println("¿Cuánto desea ingresar?: ");
					float ingresar = Integer.parseInt(dato.readLine());
					operativa_cuenta(cuenta1, ingresar, opcion);
				} else if (opcion == 2) {
					System.out.println("¿Cuánto desea retirar?: ");
					float retirar = Integer.parseInt(dato.readLine());
					operativa_cuenta(cuenta1, retirar, opcion);
				} else if (opcion == 3) {
					System.out.println("Finalizamos la ejecución");
				} else {
					System.err.println("Opción errónea");
				}

			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		} while (opcion != 3);
		saldoActual = cuenta1.estado();
		System.out.println("El saldo actual es: " + saldoActual);
	}

	/**
	 * metodo que con un try catch realiza las operaciones en función de la opción
	 * que se le ha pasado por parametros.
	 * 
	 * @param cuenta1  Cuenta sobre la que el usuario va a realizar las operaciones
	 * @param cantidad Cantidad con la que se va a realizar la operación
	 * @param opcion   Elije el tipo de operación ( Ingresar, Retirar, Finalizar )
	 */
	public static void operativa_cuenta(CCuenta cuenta1, float cantidad, int opcion) {
		if (opcion == 2) {
			try {
				cuenta1.retirar(cantidad);
			} catch (Exception e) {
				System.out.print("Fallo al retirar");
			}
		} else if (opcion == 1) {
			try {
				System.out.println("Ingreso en cuenta");
				cuenta1.ingresar(cantidad);
			} catch (Exception e) {
				System.out.print("Fallo al ingresar");
			}
		}
	}
}