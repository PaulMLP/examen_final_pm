package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.repository.modelo.VueloLigero;

@Repository
@Transactional
public class VueloRepositoryImpl implements IVueloRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<VueloLigero> buscarDisponibles(String origen, String destino, LocalDateTime fechaVuelo) {
		TypedQuery<VueloLigero> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.VueloLigero(vl.numero, vl.origen, vl.destino, vl.avion.nombre, vl.valorAsiento) FROM Vuelo vl WHERE vl.origen = :origen AND vl.destino =:destino AND vl.fechaVuelo =:fechaVuelo ",
				VueloLigero.class);
		myQuery.setParameter("origen", origen);
		myQuery.setParameter("destino", destino);
		myQuery.setParameter("fechaVuelo", fechaVuelo);
		return myQuery.getResultList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Vuelo buscarDisponible(String numero) {
		TypedQuery<Vuelo> myQuery = this.entityManager
				.createQuery("SELECT v FROM Vuelo v WHERE v.numero=:numero AND v.estado = :estado ", Vuelo.class);
		myQuery.setParameter("numero", numero);
		myQuery.setParameter("estado", "DIS");
		try {
			return myQuery.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Vuelo vuelo) {
		this.entityManager.merge(vuelo);
	}

}
