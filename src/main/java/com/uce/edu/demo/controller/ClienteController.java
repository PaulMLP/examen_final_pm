package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.VueloLigero;
import com.uce.edu.demo.service.IClienteGestorService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteGestorService clienteGestorService;

	@GetMapping("/buscarVuelos/{origen}/{destino}/{fecha}")
	public String buscarVuelos(@PathVariable("origen") String origen, @PathVariable("destino") String destino,
			@PathVariable("fecha") String fecha, Model modelo) {
		List<VueloLigero> vuelos = this.clienteGestorService.buscarVuelosDisponibles(origen, destino, fecha);
		modelo.addAttribute("vuelos", vuelos);
		return "vistaBusqueda";
	}
	
	@GetMapping("/parametros")
	public String ingresarBusqueda(VueloLigero vueloLigero) {
		return "vistaParametros";
	}
}
