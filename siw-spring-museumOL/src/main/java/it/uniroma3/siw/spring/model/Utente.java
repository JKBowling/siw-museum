package it.uniroma3.siw.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Utente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String cognome;
	
	@Column(nullable=false)
	private String cellulare;

	@lombok.experimental.Tolerate
	public Utente(String nome, String cognome,String email,String cellulare) {
		this.nome = nome;
		this.cognome=cognome;
		this.email = email;
		this.cellulare=cellulare;
	}
	
	public Utente() {
		
	}
}
