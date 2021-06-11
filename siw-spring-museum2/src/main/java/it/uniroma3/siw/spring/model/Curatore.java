package it.uniroma3.siw.spring.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Curatore {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
    private String cognome;
    
    @Column(nullable=false)
	private String email;
    
    @Column(nullable=true)
    LocalDate dataNascita;
    
    @Column(nullable=false)
    String luogoNascita;
	
	@Column(nullable=false)
	private String telefono;
	
	@Column(nullable=false,unique=true)
	private String matricola;
	
	@OneToMany(mappedBy="curatore")
	List<Collezione> collezione;
	
	

	public Curatore() {
		collezione=new ArrayList<>();
	}

	@lombok.experimental.Tolerate
	public Curatore(String nome, String cognome, String email, String telefono,String luogoNascita,LocalDate dataNascita, String matricola) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.telefono = telefono;
		this.matricola = matricola;
		this.luogoNascita=luogoNascita;
		this.dataNascita=dataNascita;
		this.collezione=new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Curatore [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", telefono="
				+ telefono + ", matricola=" + matricola + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curatore other = (Curatore) obj;
		if (matricola == null) {
			if (other.matricola != null)
				return false;
		} else if (!matricola.equals(other.matricola))
			return false;
		return true;
	}	
}
