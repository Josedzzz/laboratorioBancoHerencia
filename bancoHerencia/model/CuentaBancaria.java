package bancoHerencia.model;

import bancoHerencia.exceptions.CuentaException;


public abstract class CuentaBancaria {

	protected float saldo;
	protected int numeroConsignaciones = 0;
	protected int numeroRetiros = 0;
	protected float tasaAnual;
	protected float comisionMensual = 0;


	public CuentaBancaria(float saldo, float tasaAnual) {
		this.saldo = saldo;
		this.tasaAnual = tasaAnual;
	}

	/**
	 * Consigna una cantidad dada y suma el número de consignaciones
	 * @param cantidad
	 */
	public void consignar(float cantidad) {
		saldo = saldo + cantidad;
		numeroConsignaciones = numeroConsignaciones + 1;
	}

	/**
	 * Retira dinero siempre y cuando este exista en la cuenta
	 * @param cantidad
	 * @throws CuentaException
	 */
	public void retirar(float cantidad) throws CuentaException {
		float nuevoSaldo = saldo - cantidad;
		if (nuevoSaldo >= 0) {
			saldo -= cantidad;
			numeroRetiros = numeroRetiros + 1;
		} else {
			throw new CuentaException("El saldo excede el valor actual");
		}
	}

	/**
	 * Calcula el interes a partir de obtener la tasa mensual y actualiza
	 * el saldo aplicando el interes
	 */
	public void calcularInteres() {
		float tasaMensual = tasaAnual / 12;
		float interesMensual = saldo * tasaMensual;
		saldo += interesMensual;
	}

	/**
	 * Método que genera un extracto aplicando al saldo actual una
	 * comisión y calculando sus intereses
	 */
	public void extractoMensual() {
		saldo -= comisionMensual;
		calcularInteres();
	}
}