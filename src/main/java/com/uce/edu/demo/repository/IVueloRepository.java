package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.repository.modelo.VueloLigero;

public interface IVueloRepository {

	public List<VueloLigero> buscarDisponibles(String origen, String destino, LocalDateTime fechaVuelo);
	
	public Vuelo buscarDisponible(String numero);
	
	public void actualizar(Vuelo vuelo);
	

}
