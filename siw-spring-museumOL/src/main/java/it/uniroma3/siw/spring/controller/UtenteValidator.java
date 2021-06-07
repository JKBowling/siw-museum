package it.uniroma3.siw.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Utente;
import it.uniroma3.siw.spring.service.UtenteService;

@Component
public class UtenteValidator implements Validator{

	@Autowired
	private UtenteService utenteService;

	//	private static final Logger logger = LoggerFactory.getLogger(UtenteValidator.class);

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");

		if (!errors.hasErrors()) {
//			logger.debug("confermato: valori non nulli");
			if (this.utenteService.alreadyExists((Utente)o)) {
//				logger.debug("e' un duplicato");
				errors.reject("duplicato");
			}
		}
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return Utente.class.equals(aClass);
	}
}
