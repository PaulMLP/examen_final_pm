package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CompraPasaje;

@Repository
@Transactional
public class CompraPasajeRepositoryImpl implements ICompraPasajeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CompraPasaje compraPasaje) {
		this.entityManager.persist(compraPasaje);
	}

}
