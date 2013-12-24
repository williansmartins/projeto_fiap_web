package br.com.fiap.web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.web.model.ClienteEntity;

public class ClienteDaoImpl extends JpaGenericDao<ClienteEntity> implements IClienteDao{
	
	private EntityManager entityManager;
	List<ClienteEntity> lista;
	
	public ClienteDaoImpl() {
		entityManager = getEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public List<ClienteEntity> findEspecific(String s) {
		entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		
		String jpql = "SELECT p FROM Cliente p WHERE p.nome like '%" + s + "%'";
		Query query = entityManager.createQuery(jpql);
		lista = (List<ClienteEntity>)query.getResultList();
		
		
		entityManager.flush();
		
		entityManager.close();
		if(lista.size() > 0){
			return lista;
		}else{
			return null;
		}
	}
}

