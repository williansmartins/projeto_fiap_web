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
			return "seguro/lista_clientes.xhtml?faces-redirect=true";
		}else{
            FacesContext.getCurrentInstance().addMessage("field_id", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha incorreta", "error message2")); 
		}
		return "";
	}
	
	public String listagem(){
		entity = new ClienteEntity();
		lista = dao.findAll();
		return "seguro/lista_clientes.xhtml?faces-redirect=true";
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
		return "seguro/inserir_cliente.xhtml";
	}	
	
	public String prepareInsert(){
		entity = new ClienteEntity();
		System.out.println("insert");
		return "seguro/inserir_cliente.xhtml?faces-redirect=true";
	}	
	
	public String metodo(){
		System.out.println("ESPECIAL:" + entity.getNome());
		return "false";
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
