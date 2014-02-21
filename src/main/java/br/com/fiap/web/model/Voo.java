package br.com.fiap.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="voo")
public class Voo
    implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String horario;
    private Date data;
    public Voo() {
	super();
    }

    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    
    public void setHorario(String horario) {
        this.horario = horario;
    }

    
    public Date getData() {
        return data;
    }

    
    public void setData(Date data) {
        this.data = data;
    }

    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
}
