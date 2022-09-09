package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;

public class VueloLigero {

	private String numero;

	private String origen;

	private String destino;

	private String nombreAvion;

	private BigDecimal valorAsiento;

	private String fecha;

	public VueloLigero() {
	}

	

	public VueloLigero(String numero, String origen, String destino, String nombreAvion, BigDecimal valorAsiento,
			String fecha) {
		super();
		this.numero = numero;
		this.origen = origen;
		this.destino = destino;
		this.nombreAvion = nombreAvion;
		this.valorAsiento = valorAsiento;
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "VueloLigero [numero=" + numero + ", origen=" + origen + ", destino=" + destino + ", nombreAvion="
				+ nombreAvion + ", valorAsiento=" + valorAsiento + ", fecha=" + fecha + "]";
	}


	// SET y GET
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getNombreAvion() {
		return nombreAvion;
	}

	public void setNombreAvion(String nombreAvion) {
		this.nombreAvion = nombreAvion;
	}

	public BigDecimal getValorAsiento() {
		return valorAsiento;
	}

	public void setValorAsiento(BigDecimal valorAsiento) {
		this.valorAsiento = valorAsiento;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
