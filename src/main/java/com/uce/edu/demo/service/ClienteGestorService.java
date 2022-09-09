package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.ICompraPasajeRepository;
import com.uce.edu.demo.repository.IVueloRepository;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.CompraPasaje;
import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.repository.modelo.VueloLigero;

@Service
public class ClienteGestorService implements IClienteGestorService {

	@Autowired
	private IVueloRepository vueloRepository;

	@Autowired
	private IClienteRepository clienteRepository;

	@Autowired
	private ICompraPasajeRepository compraPasajeRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public List<VueloLigero> buscarVuelosDisponibles(String origen, String destino, String fechaVuelo) {

		String[] fechaSplit = fechaVuelo.split("/");
		int dia = Integer.parseInt(fechaSplit[0]);
		int mes = Integer.parseInt(fechaSplit[1]);
		int anio = Integer.parseInt(fechaSplit[2]);
		System.out.println(dia+mes+anio);
		LocalDateTime fecha = LocalDateTime.of (anio,mes,dia,0,0);

		return this.vueloRepository.buscarDisponibles(origen, destino, fecha);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void reservarPadaje(String numeroVuelo, Integer cantidadAsientos, String cedula) {

		Cliente c = this.clienteRepository.buscar(cedula);
		Vuelo vuelo = this.vueloRepository.buscarDisponible(numeroVuelo);

		CompraPasaje compraPasaje = new CompraPasaje();
		compraPasaje.setCantidadAsientosComprados(cantidadAsientos);
		compraPasaje.setCliente(c);
		compraPasaje.setEstado("RES");
		compraPasaje.setNumero(cedula);
		compraPasaje.setFechaCompra(LocalDateTime.now());
		compraPasaje.setVuelo(vuelo);
		this.compraPasajeRepository.insertar(compraPasaje);
		
		this.actualizarVuelo(vuelo, cantidadAsientos);

	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizarVuelo(Vuelo vuelo, Integer cantidadAsientos) {
		if (vuelo.getAsientosDisponibles() < cantidadAsientos) {
			throw new RuntimeException();
		}

		vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles() - cantidadAsientos);
		vuelo.setAsientosOcupados(vuelo.getAsientosDisponibles() - cantidadAsientos);
		if (vuelo.getAsientosDisponibles() == 0) {
			vuelo.setEstado("ND");
		}
		this.vueloRepository.actualizar(vuelo);
	}

}
