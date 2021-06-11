package it.uniroma3.siw.spring.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Utente;
import it.uniroma3.siw.spring.repository.UtenteRepository;

@Service
public class UtenteService {

	@Autowired 
	private UtenteRepository utenteRepository;

	@Transactional
	public Utente inserisci(Utente utente) {
		return utenteRepository.save(utente);
	}

	@Transactional
	public List<Utente> utentePerNomeAndCognome(String nome, String cognome) {
		return utenteRepository.findByNomeAndCognome(nome, cognome);
	}
	
	@Transactional
	public List<Utente> utentePerCellulare(String cellulare) {
		return utenteRepository.findByCellulare(cellulare);
	}
	
	@Transactional
	public Utente utentePerId(Long id){
		Optional<Utente> optional = utenteRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public List<Utente> tutti(){
		return (List<Utente>) utenteRepository.findAll();
	}

	@Transactional
	public boolean alreadyExists(Utente u) {
		List<Utente> listaUtenti=this.utenteRepository.findByNomeAndCognome(u.getNome(),u.getCognome());
		if(listaUtenti.size()>0)
			return true;
		else
			return false;
	}

}
