package unidad4;

/**
 * clase que contiene los objetos de tipo CCuenta corriente, estos objetos hacen
 * referencia a las cuentas que utilizan los usuarios para gestionar sus
 * cantidades.
 * 
 * Los métodos de la otra clase, main están orientados a trabajar con estos
 * atributos y métodos.
 * 
 * @author manuelramosillana
 *
 */
public class CCuenta {

	// Propiedades de la Clase Cuenta
	protected String nombre;
	private String cuenta;
	private double saldo;
	private double tipoInterés;

	
	public CCuenta() {
	}

	
	public CCuenta(String nom, String cue, double sal, double tipo) {
		nombre = nom;
		cuenta = cue;
		saldo = sal;
		tipoInterés = tipo;
	}

	public void asignarNombre(String nom) {
		nombre = nom;
	}

	public String obtenerNombre() {
		return nombre;
	}

	public double estado() {
		return saldo;
	}

	/**
	 * Método que recibe una cantidad de 'dinero' por parte del usuario y la suma al
	 * saldo 'o dinero' que ya tenía esta CCuenta.
	 * 
	 * @param cantidad Cantidad de dinero que se va a ingresar
	 * @throws Exception (En el caso de que la cantidad sea menor a cero, no se
	 *                   podrá sumar y el método arrojará una excepción)
	 */
	public void ingresar(double cantidad) throws Exception {
		if (cantidad < 0) {
			throw new Exception("No se puede ingresar una cantidad negativa");
		}
		setSaldo(saldo + cantidad);
	}

	/**
	 * Método similar al anterior, pero que en este caso restará la cantidad de
	 * 'dinero' que el usuario indique del saldo que tiene la CCuenta.
	 * 
	 * @param cantidad Cantidad de dinero que se va a retirar
	 * @throws Exception (Si no existiese 'dinero' suficiente para retirarlo se
	 *                   arrojaría una excepción. Al igual que si la cantidad a
	 *                   retirar fuese negativa)
	 */
	public void retirar(double cantidad) throws Exception {
		if (cantidad < 0) {
			throw new Exception("No se puede retirar una cantidad negativa");
		}
		if (estado() < cantidad) {
			throw new Exception("No se hay suficiente saldo");
		}
		setSaldo(saldo - cantidad);
	}

	public String obtenerCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getTipoInterés() {
		return tipoInterés;
	}

	public void setTipoInterés(double tipoInterés) {
		this.tipoInterés = tipoInterés;
	}
}