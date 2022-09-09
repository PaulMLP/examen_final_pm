package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.repository.modelo.VueloLigero;

public interface IClienteGestorService {

	public List<VueloLigero> buscarVuelosDisponibles(String origen, String destino, String fechaVuelo);
	
	public void reservarPadaje(String numeroVuelo, Integer cantidadAsientos, String cedula);
	
	public void actualizarVuelo(Vuelo vuelo, Integer cantidadAsientos);
}
