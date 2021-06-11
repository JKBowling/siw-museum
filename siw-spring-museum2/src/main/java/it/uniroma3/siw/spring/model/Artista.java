package it.uniroma3.siw.spring.model;

import java.time.LocalDate;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.*;

@Entity
@Data
public class Artista {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String cognome;
	
	@Column(nullable=false)
	private String codice;
	
	@Column(nullable=false)
	private String nazione;
	
	@Column(nullable=false)
	private String luogoNascita;
	
	@Column(nullable=false)
	private String luogoMorte;
	
	@Column(nullable=true)
	LocalDate dataNascita;
	
	@Column(nullable=true)
	LocalDate dataMorte;
	
	@OneToMany(mappedBy="autore",cascade=CascadeType.REMOVE)
	List<Opera> opere;

	@lombok.experimental.Tolerate
	public Artista(String nome, String cognome, String codice, String nazione, String luogoNascita,String luogoMorte, LocalDate dataNascita, LocalDate dataMorte) {
		this.nome = nome;
		this.cognome = cognome;
		this.codice = codice;
		this.nazione = nazione;
		this.luogoNascita = luogoNascita;
		this.luogoMorte = luogoMorte;
		this.dataNascita = dataNascita;
		this.dataMorte = dataMorte;
		this.opere=new ArrayList<>();
	}

	public Artista() {
		this.opere=new ArrayList<>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
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
		Artista other = (Artista) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artista [nome=" + nome + ", cognome=" + cognome + ", codice=" + codice + ", nazionalita="
				+ nazione + ", luogoNascita=" + luogoNascita + ", luogoMorte=" + luogoMorte + ", dataNascita="
				+ dataNascita + ", dataMorte=" + dataMorte + ", opere=" + opere + "]";
	}
	
}