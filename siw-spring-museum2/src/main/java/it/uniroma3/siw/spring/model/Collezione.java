package it.uniroma3.siw.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Collezione {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=true)
	private String descrizione;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	private Curatore curatore;
	
	@OneToMany(mappedBy="collezione",cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Opera> opere;
	
	@Column(nullable=false,unique=true)
	private String codice;

	public Collezione() {

	}

	@lombok.experimental.Tolerate
	public Collezione(String nome, String descrizione,String codice) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.codice=codice;
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
		Collezione other = (Collezione) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Collezione [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", curatore1=" + curatore
				+ ", opere=" + opere + ", codice=" + codice + "]";
	}	
	
	
}
