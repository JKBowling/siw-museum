package it.uniroma3.siw.spring.model;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Opera {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String titolo;
	
	@Column(nullable=false)
	private String annoDiCreazione;
	
	@Column(nullable=false)
	private String descrizione;
	
	@Column(nullable=false)
	private String codice;
	
	@ManyToOne
	Collezione collezione;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	Artista autore;

	@lombok.experimental.Tolerate
	public Opera(String titolo, String annoDiCreazione, String descrizione, String codice) {
		this.titolo = titolo;
		this.annoDiCreazione = annoDiCreazione;
		this.descrizione = descrizione;
		this.codice = codice;
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
		Opera other = (Opera) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "Opera [id=" + this.getId() + ", titolo=" + this.getTitolo()+ ", annoDiCreazione=" + this.getAnnoDiCreazione() + ", descrizione="
//				+ this.getDescrizione() + ", codice=" + this.getCodice() + ", collezione=" + this.getCollezione() + ", artista=" + this.getArtista() + "]";
//	}
}
