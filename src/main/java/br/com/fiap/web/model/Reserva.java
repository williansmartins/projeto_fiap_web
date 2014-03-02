package br.com.fiap.web.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="reserva")
public class Reserva
    implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String loc;
    @OneToMany(targetEntity=Passageiro.class, fetch=FetchType.LAZY) 
    private List<Passageiro> passageiros;
    
    @ManyToMany(targetEntity=Trecho.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="reserva_x_itinerario", 
    joinColumns={@JoinColumn(name="id_reserva",referencedColumnName="id", table="Reserva")}, 
    inverseJoinColumns={@JoinColumn(name="id_itinerario", referencedColumnName="id",table="Itinerario")})
    private List<Trecho> itinerarios;
    
    public Reserva() {
	super();
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }
    
    public void setPassageiros(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }
    
    public List<Trecho> getItinerarios() {
        return itinerarios;
    }

    public void setItinerarios(List<Trecho> itinerarios) {
        this.itinerarios = itinerarios;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
