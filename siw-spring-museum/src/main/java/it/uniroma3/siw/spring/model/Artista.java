package it.uniroma3.siw.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import lombok.Data;

@Entity
@Data
public class Artista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@Column
	private LocalDate dataNascita;
	
	@Column
	private String luogoNascita;
	
	@Column
	private LocalDate dataMorte;
	
	@Column
	private String luogoMorte;
	
	@Column
	private String nazione;
	
	@Column(unique = true)
	private String code;
	
	@OneToMany(mappedBy = "autore")
	private List<Opera> opere;
	
	public Artista() {
		
		this.opere = new ArrayList<Opera>();
		
	}
	
	@lombok.experimental.Tolerate
	public Artista(String nome, String cognome, LocalDate dataNascita, String luogoNascita, String nazione, String code) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.nazione = nazione;
		this.code = code;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artista [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", luogoNascita=" + luogoNascita + ", dataMorte=" + dataMorte + ", luogoMorte=" + luogoMorte
				+ ", nazione=" + nazione + ", code=" + code + ", opere=" + opere + "]";
	}
	
	

}
