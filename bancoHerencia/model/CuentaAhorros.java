package bancoHerencia.model;

import bancoHerencia.exceptions.CuentaException;


public class CuentaAhorros extends CuentaBancaria {

	private boolean activa;

	public CuentaAhorros(float saldo, float tasa) {
		super(saldo, tasa);
		if (saldo < 10000) /* Si el saldo es menor a 10000, la cuenta no se activa */
			activa = false;
		else
			activa = true;
	}

	/**
	 * Metodo que dado una cantidad de dinero la restira usando los metodos
	 * de la clase padre
	 */
	public void retirar(float cantidad) throws CuentaException {
		if (activa) {
			super.retirar(cantidad);
		}
	}

	/**
	 * Metodo que dado una canridad de dinero consigna el dineron usando los
	 * metodos de la clase padre
	 */
	public void consignar(float cantidad) {
		if (activa) {
			super.consignar(cantidad);
		}
	}

	/**
	 * Método que genera el extracto mensual de una cuenta de ahorros
	 * Si hay mas de 4 retiros se cobra 1000 como comisión mensual por retiro
	 * Tiene que tener mas de 10000 para estar activa
	 */
	public void extractoMensual() {
		if (numeroRetiros > 4) {
			comisionMensual += (numeroRetiros - 4) * 1000;
		}
		super.extractoMensual();
		if ( saldo < 10000 ) {
			activa = false;
		}
	}

	/**
	 * Método que muestra en pantalla los datos de una cuenta de ahorros
	 */
	public void imprimir() {
		System.out.println("Saldo = $ " + saldo);
		System.out.println("Comisión mensual = $ " + comisionMensual);
		System.out.println("Número de transacciones = "+ (numeroConsignaciones + numeroRetiros));
		System.out.println();
	}
}
