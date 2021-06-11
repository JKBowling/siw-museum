package it.uniroma3.siw.spring.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.model.Utente;
import it.uniroma3.siw.spring.service.UtenteService;

@Controller
public class UtenteController {
	@Autowired
	private UtenteService utenteService;

	    @Autowired
	    private UtenteValidator utenteValidator;
	    
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value="/addUtente", method = RequestMethod.GET)
	public String addUtente(Model model) {
		logger.debug("addUtente");
		model.addAttribute("utente", new Utente());//in model vengono messi gli oggetti ds passare alla vista successiva 
		return "utenteForm.html";
	}
	
	 @RequestMapping(value = "/utente/{id}", method = RequestMethod.GET)
	    public String getUtente(@PathVariable("id") Long id, Model model) {
	    	model.addAttribute("utente", this.utenteService.utentePerId(id));
	    	return "utente.html";
	    }

	    @RequestMapping(value = "/utente", method = RequestMethod.GET)
	    public String getUtenti(Model model) {
	    		model.addAttribute("utenti", this.utenteService.tutti());
	    		return "utenti.html";
	    }

	@RequestMapping(value="/utente", method = RequestMethod.POST)
	public String newUtente(@ModelAttribute("utente") Utente utente, 
			Model model, BindingResult bindingResult) {
		this.utenteValidator.validate(utente, bindingResult);
		if (!bindingResult.hasErrors()) {
			this.utenteService.inserisci(utente);
			model.addAttribute("utenti", this.utenteService.tutti());
			return "utenti.html";
		}
		return "utenteForm.html";
	}

}