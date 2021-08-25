/**
 * 
 */

/**
 * @author Mabera
 *
 */
public class Clientes {
	
	private String Nombre;
	private String N_Cuenta;
	private double Saldo;
	
	public Clientes(String nombre, String n_Cuenta, double saldo) {
		Nombre = nombre;
		N_Cuenta = n_Cuenta;
		Saldo = saldo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	/**
	 * @return the n_Cuenta
	 */
	public String getN_Cuenta() {
		return N_Cuenta;
	}

	/**
	 * @param n_Cuenta the n_Cuenta to set
	 */
	public void setN_Cuenta(String n_Cuenta) {
		N_Cuenta = n_Cuenta;
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return Saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		Saldo = saldo;
	}

	
	
	
}
