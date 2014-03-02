package br.com.fiap.web.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.web.model.Voo;

public class VooDaoImpl extends JpaGenericDao<Voo> implements IVooDao{
	
	private EntityManager entityManager;
	List<Voo> lista;
	
	public VooDaoImpl() {
		entityManager = getEntityManager();
	}
	
}

