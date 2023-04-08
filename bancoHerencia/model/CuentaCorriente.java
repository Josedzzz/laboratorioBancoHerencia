package bancoHerencia.model;

import bancoHerencia.exceptions.CuentaException;


public class CuentaCorriente extends CuentaBancaria {

	float sobregiro;

	public CuentaCorriente(float saldo, float tasa) {
		super(saldo, tasa);
		sobregiro = 0;
	}

	/**
	 * Se retira dinero, pero si este sobrepasa el dinero de la cuenta queda
	 * como sobregiro
	 */
	public void retirar(float cantidad) throws CuentaException {
		float resultado = saldo - cantidad;
		if (resultado < 0) {
			sobregiro = sobregiro - resultado;
			saldo = 0;
		} else {
			super.retirar(cantidad); /* Si no hay sobregiro, se realiza un retiro normal */
		}
	}

	/**
	 * Metodo para consiganar, si existe sobregiro primero se le consigna a este
	 */
	public void consignar(float cantidad) {
		float residuo = sobregiro - cantidad;
		if (sobregiro > 0) {
			if ( residuo > 0) {
				sobregiro = 0;
				saldo = residuo;
			} else {
				sobregiro = -residuo;
				saldo = 0;
			}
		} else {
			super.consignar(cantidad);
		}
	}

	/**
	 * Método que genera el extracto mensual de la cuenta
	 * Invoca el método de la clase padre
	 */
	public void extractoMensual() {
		super.extractoMensual();
	}

	/**
	 * Método que muestra en pantalla los datos de una cuenta corriente
	 */
	public void imprimir() {
		System.out.println("Saldo = $ " + saldo);
		System.out.println("Cargo mensual = $ " + comisionMensual);
		System.out.println("Número de transacciones = " + (numeroConsignaciones + numeroRetiros));
		System.out.println("Valor de sogregiro = $" + (numeroConsignaciones + numeroRetiros));
		System.out.println();
	}
}