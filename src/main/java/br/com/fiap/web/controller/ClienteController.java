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
	
	public ClienteController(){
		entity = new ClienteEntity();
	}
	
	public String list(){
		entity = new ClienteEntity();
		return "lista_clientes.xhtml?faces-redirect=true";
	}
	
	public String save(){
		dao.insert(entity);
		entity = new ClienteEntity();
		return "lista.xhtml";
	}
	
	public String remove(){
		dao.delete(entity.getId());
		return "lista.xhtml";
	}	
	
	public String incAlt(){
		entity = dao.findById(entity.getId());
		return "inserir.xhtml";
	}	
	
	public String prepareInsert(){
		entity = new ClienteEntity();
		System.out.println("insert");
		return "inserir.xhtml?faces-redirect=true";
	}	
	
	public List<ClienteEntity> getListagem() {
		return dao.findAll();
	}

	
	//GETTERS AND SETTERS
	
	public ClienteEntity getCliente() {
		return entity;
	}

	public void setPedido(ClienteEntity entity) {
		this.entity = entity;
	}
	
	
}
