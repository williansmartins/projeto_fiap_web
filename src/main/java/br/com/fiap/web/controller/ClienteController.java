package br.com.fiap.web.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.fiap.web.dao.ClienteDaoImpl;
import br.com.fiap.web.dao.JpaGenericDao;
import br.com.fiap.web.model.ClienteEntity;
import br.com.fiap.web.utils.Redirecionador;

@ManagedBean(name="cliente_controller")
@SessionScoped
public class ClienteController {
	
	private ClienteEntity entity;
	private JpaGenericDao<ClienteEntity> dao = new ClienteDaoImpl();
	List<ClienteEntity> lista;

	public ClienteController(){
		entity = new ClienteEntity();
		listagem();
	}
	
	public String login(){
		List<ClienteEntity> lista = dao.findEspecific(entity);
		HttpSession session = (HttpSession)FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSession(true);
				
		if( lista.size() > 0 ) {
			session.setAttribute("autenticado_chave", "ok");
			listagem();
			new Redirecionador().redirecionar("lista_clientes.xhtml");
			return "";
		}else{
            FacesContext.getCurrentInstance().addMessage("field_id", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usu�rio ou senha incorreta", "error message2")); 
		}
		return "";
	}
	
	public String listagem(){
		entity = new ClienteEntity();
		lista = dao.findAll();
		new Redirecionador().redirecionar("lista_clientes.xhtml");
		return "";
	}
	
	public String save(){
		if(entity.getId() == null)
		dao.insert(entity);
		dao.update(entity);
		entity = new ClienteEntity();
		return listagem();
	}
	
	public void remove(){
		dao.delete(entity.getId());
		listagem();
	}	
	
	public String incAlt(){
		entity = dao.findById(entity.getId());
		new Redirecionador().redirecionar("inserir_cliente.xhtml");
		return "";
	}	
	
	public String prepareInsert(){
		entity = new ClienteEntity();
		System.out.println("insert");
		new Redirecionador().redirecionar("inserir_cliente.xhtml");
		return "";
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
