package com.uce.edu.demo.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "compra_pasaje")
public class CompraPasaje {

	@Id
	@Column(name = "copa_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "copa_seq_id")
	@SequenceGenerator(name = "copa_seq_id", sequenceName = "copa_seq_id", allocationSize = 1)
	private Integer id;

	@Column(name = "copa_numero")
	private String numero;

	@Column(name = "copa_fechaCompra")
	private LocalDateTime fechaCompra;

	@Column(name = "copa_cantidad_asientos_comprados")
	private Integer cantidadAsientosComprados;

	@Column(name = "copa_estado")
	private String estado;

	@ManyToOne
	@JoinColumn(name = "vuel_id")
	private Vuelo vuelo;

	@ManyToOne
	@JoinColumn(name = "clie_id")
	private Cliente cliente;

	// SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Integer getCantidadAsientosComprados() {
		return cantidadAsientosComprados;
	}

	public void setCantidadAsientosComprados(Integer cantidadAsientosComprados) {
		this.cantidadAsientosComprados = cantidadAsientosComprados;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
