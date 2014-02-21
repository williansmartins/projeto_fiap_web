package br.com.fiap.web.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="assento")
public class Assento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private String numero;
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY, orphanRemoval = false)
    @JoinColumn(name="classe", referencedColumnName="id")
    private Classe classe;
    
    @OneToOne
    private Aviao aviao;
    
    public Assento() {
	super();
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Classe getClasse() {
        return classe;
    }
    
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    
    public String getNumero() {
        return numero;
    }

    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public Aviao getAviao() {
        return aviao;
    }
    
    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }
    
}
