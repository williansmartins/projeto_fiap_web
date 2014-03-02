package br.com.fiap.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "voo")
public class Voo implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date data;
    private double preco;
    
    public Voo()
    {
	super();
    }

    public double getPreco( )
    {
	return preco;
    }

    public void setPreco( double preco )
    {
	this.preco = preco;
    }

    public int getId( )
    {
	return id;
    }

    public void setId( int id )
    {
	this.id = id;
    }

    public Date getData( )
    {
	return data;
    }

    public void setData( Date data )
    {
	this.data = data;
    }

    public static long getSerialversionuid( )
    {
	return serialVersionUID;
    }

}
