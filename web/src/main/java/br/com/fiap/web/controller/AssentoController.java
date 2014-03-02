package br.com.fiap.web.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.web.dao.JpaGenericDao;
import br.com.fiap.web.dao.VooDaoImpl;
import br.com.fiap.web.model.Assento;
import br.com.fiap.web.model.Voo;
import br.com.fiap.web.utils.Redirecionador;

@ManagedBean(name = "assento_controller")
@SessionScoped
public class AssentoController
{
    private JpaGenericDao<Voo> daoDeVoos = new VooDaoImpl();
    private Assento entity;
    List<Voo> listaDeVoos;
    Integer idDoVoo = new Integer( 0 );

    Assento assento1;
    Assento assento2;
    Assento assento3;
    Assento assento4;
    Assento assento5;
    
    public AssentoController()
    {
	entity = new Assento();
	assento1 = new Assento();
	assento2 = new Assento();
	assento3 = new Assento();
	assento4 = new Assento();
	assento5 = new Assento();
	listagem();
    }

    public Assento getAssento1( )
    {
	return assento1;
    }

    public void setAssento1( Assento assento1 )
    {
	this.assento1 = assento1;
    }

    public Assento getAssento2( )
    {
        return assento2;
    }

    public void setAssento2( Assento assento2 )
    {
        this.assento2 = assento2;
    }

    public Assento getAssento3( )
    {
        return assento3;
    }

    public void setAssento3( Assento assento3 )
    {
        this.assento3 = assento3;
    }

    public Assento getAssento4( )
    {
        return assento4;
    }

    public void setAssento4( Assento assento4 )
    {
        this.assento4 = assento4;
    }

    public Assento getAssento5( )
    {
        return assento5;
    }

    public void setAssento5( Assento assento5 )
    {
        this.assento5 = assento5;
    }

    public Integer getIdDoVoo( )
    {
	return idDoVoo;
    }

    public void setIdDoVoo( Integer idDoVoo )
    {
	this.idDoVoo = idDoVoo;
    }

    public String listagem( )
    {
	entity = new Assento();
	listaDeVoos = daoDeVoos.findAll();
	new Redirecionador().redirecionar( "lista_assentos.xhtml" );
	return "lista_voos.xhtml";
    }

    public String gerenciar( )
    {
	// entity = dao.findById( entity.getId() );
	new Redirecionador().redirecionar( "gerenciar_assentos.xhtml" );
	return "";
    }

    public String save( )
    {
	System.out.println( ">>" + assento1 );
	System.out.println( ">>" + assento2 );
	System.out.println( ">>" + assento3 );
	System.out.println( ">>" + assento4 );
	System.out.println( ">>" + assento5 );
	// if ( entity.getId() == 0 )
	// {
	// dao.insert( entity );
	// } else
	// {
	// dao.update( entity );
	// }
	// entity = new Voo();
	// listaDeVoos = dao.findAll();
	// new Redirecionador().redirecionar( "lista_voos.xhtml" );
	return "";
    }

    // public String remove( )
    // {
    // dao.delete( entity.getId() );
    // listagem();
    // return "";
    // }

    // public String prepareInsert( )
    // {
    // entity = new Assento();
    // System.out.println( "vamos inserir?" );
    // new Redirecionador().redirecionar( "inserir_voo.xhtml" );
    // return "";
    // }

    public Assento getEntity( )
    {
	return entity;
    }

    public void setEntity( Assento entity )
    {
	this.entity = entity;
    }

    public List<Voo> getListaDeVoos( )
    {
	return listaDeVoos;
    }

    public void setListaDeVoos( List<Voo> lista )
    {
	this.listaDeVoos = lista;
    }
}
