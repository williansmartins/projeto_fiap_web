package br.com.fiap.web.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "assento")
public class Assento implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private String numero;
    private String classe;

    public Assento()
    {
	super();
    }

    public int getId( )
    {
	return id;
    }

    public void setId( int id )
    {
	this.id = id;
    }

    public String getDescricao( )
    {
	return descricao;
    }

    public void setDescricao( String descricao )
    {
	this.descricao = descricao;
    }

    public static long getSerialversionuid( )
    {
	return serialVersionUID;
    }

    public String getNumero( )
    {
	return numero;
    }

    public void setNumero( String numero )
    {
	this.numero = numero;
    }

    public String getClasse( )
    {
	return classe;
    }

    public void setClasse( String classe )
    {
	this.classe = classe;
    }

    @Override
    public String toString( )
    {
	return "Assento [id=" + id + ", descricao=" + descricao + ", numero=" + numero + ", classe=" + classe + "]";
    }

}
