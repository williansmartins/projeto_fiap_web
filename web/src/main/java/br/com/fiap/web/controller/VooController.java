package br.com.fiap.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.fiap.web.dao.JpaGenericDao;
import br.com.fiap.web.dao.TrechoDaoImpl;
import br.com.fiap.web.dao.VooDaoImpl;
import br.com.fiap.web.model.Trecho;
import br.com.fiap.web.model.Voo;
import br.com.fiap.web.utils.Redirecionador;

@ManagedBean(name = "voo_controller")
@SessionScoped
public class VooController
{
    private JpaGenericDao<Voo> dao = new VooDaoImpl();
    private JpaGenericDao<Trecho> daoTrecho = new TrechoDaoImpl();
    private Voo entity;
    List<Voo> lista;
    List<Trecho> listaDeTrechos;
    public List<SelectItem> listaDeTrechos2;
    Integer selectItem = new Integer( 0 );
    Trecho trecho;
    Date dataIda;
    Date dataVolta;


    public VooController()
    {
	entity = new Voo();
	trecho = new Trecho();
	listagem();
	listaDeTrechos = daoTrecho.findAll();
    }

    public String save( )
    {
	if ( entity.getId() == 0 )
	{
	    dao.insert( entity );
	} else
	{
	    dao.update( entity );
	}
	entity = new Voo();
	lista = dao.findAll();
	new Redirecionador().redirecionar( "lista_voos.xhtml" );
	return "";
    }

    public String listagem( )
    {
	entity = new Voo();
	lista = dao.findAll();
	// new Redirecionador().redirecionar( "lista_voos.xhtml" );
	return "";
    }

    public String remove( )
    {
	dao.delete( entity.getId() );
	listagem();
	return "";
    }

    public String incAlt( )
    {
	entity = dao.findById( entity.getId() );
	new Redirecionador().redirecionar( "inserir_voo.xhtml" );
	return "";
    }

    public String prepareInsert( )
    {
	entity = new Voo();
	System.out.println( "vamos inserir?" );
	new Redirecionador().redirecionar( "inserir_voo.xhtml" );
	return "";
    }

    public String buscarVoos( )
    {
	String origem = trecho.getOrigem();
	String destino = trecho.getDestino();

	System.out.println( "Origem: " + origem );
	System.out.println( "Destino: " + destino );
	System.out.println( "Data Ida: " + dataIda );
	System.out.println( "Data Volta: " + dataVolta );

	//BRUNO - buscar os vôos com os parâmetros passados
	lista = dao.findAll();

	new Redirecionador().redirecionar( "resultado_busca_voos_simples.xhtml" );
	return "resultado_busca_voos_simples.xhtml";
    }

    public void reservar( )
    {
	System.out.println( "Reservando o vôo: " + entity.getId() );
	//BRUNO - Efetivar a reserva
	new Redirecionador().redirecionar( "reserva_sucesso.xhtml" );
    }

    // GETTERS AND SETTERS
    public List<SelectItem> getListaDeTrechos2( )
    {
	if ( listaDeTrechos2 == null )
	{
	    listaDeTrechos2 = new ArrayList<SelectItem>();
	}
	List<Trecho> trechos = daoTrecho.findAll();
	listaDeTrechos2.clear();

	for ( Trecho item : trechos )
	{
	    listaDeTrechos2.add( new SelectItem( item.getId(), item.getOrigem()
		    + item.getDestino() ) );
	}

	return listaDeTrechos2;
    }

    public void setListaDeTrechos2( List<SelectItem> itens )
    {
	this.listaDeTrechos2 = itens;
    }

    public List<Trecho> getListaDeTrechos( )
    {
	return listaDeTrechos;
    }

    public void setListaDeTrechos( List<Trecho> listaDeTrechos )
    {
	this.listaDeTrechos = listaDeTrechos;
    }

    public Trecho getTrecho( )
    {
	return trecho;
    }

    public void setTrecho( Trecho trecho )
    {
	this.trecho = trecho;
    }

    public Voo getEntity( )
    {
	return entity;
    }

    public void setEntity( Voo entity )
    {
	this.entity = entity;
    }

    public List<Voo> getLista( )
    {
	return lista;
    }
    public Integer getSelectItem( )
    {
	return selectItem;
    }
    
    public void setSelectItem( Integer selectItem )
    {
	this.selectItem = selectItem;
    }

    public void setLista( List<Voo> lista )
    {
	this.lista = lista;
    }

    public Date getDataIda( )
    {
	return dataIda;
    }

    public void setDataIda( Date dataIda )
    {
	this.dataIda = dataIda;
    }

    public Date getDataVolta( )
    {
	return dataVolta;
    }

    public void setDataVolta( Date dataVolta )
    {
	this.dataVolta = dataVolta;
    }
}
