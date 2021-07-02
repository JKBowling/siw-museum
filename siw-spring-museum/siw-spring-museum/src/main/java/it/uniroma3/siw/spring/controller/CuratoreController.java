package it.uniroma3.siw.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.model.Curatore;
import it.uniroma3.siw.spring.service.CuratoreService;
import it.uniroma3.siw.spring.validator.CuratoreValidator;

@Controller
public class CuratoreController {
	
	@Autowired
	private CuratoreService curatoreService;
	
	@Autowired
	private CuratoreValidator curatoreValidator;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/admin/addCuratore", method = RequestMethod.GET)
	public String addCuratore(Model model) {
		
			logger.debug("addCuratore");
			model.addAttribute("curatore", new Curatore());
			return "/admin/curatoreForm.html";
			
	}
	
	@RequestMapping(value = "/admin/curatori", method = RequestMethod.GET)
	public String getCuratori(Model model) {
		
		model.addAttribute("curatori", this.curatoreService.tutti());
		return "/admin/curatori.html";
		
	}
	
	@RequestMapping(value = "/admin/curatore", method = RequestMethod.POST)
	public String newCuratore(@ModelAttribute("curatore") Curatore curatore, Model model, BindingResult bindingResult) {
			
			this.curatoreValidator.validate(curatore, bindingResult);
			if(!bindingResult.hasErrors()) {
					this.curatoreService.inserisci(curatore);
					model.addAttribute("curatori", this.curatoreService.tutti());
					return "/admin/curatori.html";
			}
			
			return "/admin/curatoreForm.html";
			
	}
	
}
