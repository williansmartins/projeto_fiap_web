package br.com.fiap.web.controller;

import java.util.ArrayList;
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

@ManagedBean(name = "login_controller")
@SessionScoped
public class LoginController
{

    private ClienteEntity entity;
    public ClienteEntity getEntity( )
    {
        return entity;
    }

    public void setEntity( ClienteEntity entity )
    {
        this.entity = entity;
    }

    public List<ClienteEntity> getLista( )
    {
        return lista;
    }

    public void setLista( List<ClienteEntity> lista )
    {
        this.lista = lista;
    }

    private JpaGenericDao<ClienteEntity> dao = new ClienteDaoImpl();
    List<ClienteEntity> lista;

    public LoginController()
    {
	lista = new ArrayList<ClienteEntity>();
	entity = new ClienteEntity("Felipe", "principe", "guerreiro");
    }

    public String login( )
    {
	List<ClienteEntity> lista = dao.findEspecific( entity );
	System.out.println(entity);
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession( true );

	if ( lista.size() > 0 )
	{
	    session.setAttribute( "autenticado_chave", "ok" );
	    session.setAttribute( "nome", entity.getNome() );
	    
	    System.out.println(session.getAttribute( "nome" ));
	    
	    new Redirecionador().redirecionar( "seguro/lista_clientes.xhtml" );
	    return "";
	} else
	{
	    FacesContext.getCurrentInstance().
	    addMessage( "field_id",
            new FacesMessage( FacesMessage.SEVERITY_ERROR, "Usuário ou senha incorreta", "error message2" ) );
	}
	return "";
    }

}
