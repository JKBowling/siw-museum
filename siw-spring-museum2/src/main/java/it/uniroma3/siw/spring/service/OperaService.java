package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.model.Collezione;
import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.repository.OperaRepository;

@Service
public class OperaService {
	
	@Autowired
	private OperaRepository operaRepository;
	
	@Transactional
	public Opera inserisci(Opera curatore){
		return operaRepository.save(curatore);
	}
	
	@Transactional
	public List<Opera> operaPerNome(String nome){
		return operaRepository.findByTitolo(nome);
	}
	
	@Transactional
	public List<Opera> operaPerAutore(Artista autore){
		return operaRepository.findByAutore(autore);
	}
	
	@Transactional
	public List<Opera> operaPerCollezione(Collezione collezione){
		return operaRepository.findByCollezione(collezione);
	}
	
	@Transactional
	public List<Opera> tutti(){
		return (List<Opera>)operaRepository.findAll();
	}
	
	@Transactional
	public Opera operaPerId(Long id){
		
		Optional<Opera> optional = operaRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}
	
	@Transactional
	public boolean alreadyExist(Opera opera){
		
		List<Opera> opere = this.operaRepository.findByTitolo(opera.getTitolo());
		if (opere.size() > 0)
			return true;
		else
			return false;
	}

}
