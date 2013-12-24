package br.com.fiap.web.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.web.dao.ClienteDaoImpl;
import br.com.fiap.web.dao.JpaGenericDao;
import br.com.fiap.web.model.ClienteEntity;

@ManagedBean(name="cliente_controller")
@SessionScoped
public class ClienteController {
	
	private ClienteEntity entity;
	private JpaGenericDao<ClienteEntity> dao = new ClienteDaoImpl();
	List<ClienteEntity> lista;

	public ClienteController(){
		entity = new ClienteEntity();
		lista = dao.findAll();
	}
	
	public String listagem(){
		entity = new ClienteEntity();
		lista = dao.findAll();
		return "lista_clientes.xhtml?faces-redirect=true";
	}
	
	public void save(){
		dao.insert(entity);
		entity = new ClienteEntity();
		listagem();
	}
	
	public void remove(){
		dao.delete(entity.getId());
		listagem();
	}	
	
	public String incAlt(){
		entity = dao.findById(entity.getId());
		return "inserir_cliente.xhtml";
	}	
	
	public String prepareInsert(){
		entity = new ClienteEntity();
		System.out.println("insert");
		return "inserir_cliente.xhtml?faces-redirect=true";
	}	
	
	//GETTERS AND SETTERS
	
	public ClienteEntity getEntity() {
		return entity;
	}

	public void setEntity(ClienteEntity entity) {
		this.entity = entity;
	}
	
	public List<ClienteEntity> getLista() {
		return lista;
	}

	public void setLista(List<ClienteEntity> lista) {
		this.lista = lista;
	}
}
