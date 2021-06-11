package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente,Long>  {

	public List<Utente> findByNomeAndCognome(String nome,String cognome);
	
	public List<Utente> findByCellulare(String cellulare);
}
