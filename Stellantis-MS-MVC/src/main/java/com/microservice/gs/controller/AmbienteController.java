package com.microservice.gs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.microservice.gs.model.Ambiente;
import com.microservice.gs.repository.AmbienteRepository;

@Controller
public class AmbienteController {

	@Autowired
	private AmbienteRepository ambienteRepository;

	@GetMapping("/ambiente")
	public String ambientePage(Model model) {
		model.addAttribute("ambientelista", ambienteRepository.findAll());
		return "ambiente";
	}

	@GetMapping("/saveAmbienteView")
	public String saveAmbienteView(Model model) {
		Ambiente ambiente = new Ambiente();
		model.addAttribute("ambiente", ambiente);
		return "add_ambiente";
	}

	@PostMapping("/saveAmbiente")
	public String saveAmbiente(@ModelAttribute("ambiente") Ambiente ambiente) {
		ambienteRepository.save(ambiente);
		return "redirect:/ambiente";
	}

	@GetMapping("/updateAmbienteView/{id}")
	public String showUpdateAmbienteView(@PathVariable("id") Long id, Model model) {
		Optional<Ambiente> temp = ambienteRepository.findById(id);
		Ambiente ambiente = temp.get();
		model.addAttribute("ambiente", ambiente);
		return "update_ambiente";
	}

	@GetMapping("/deleteAmbiente/{id}")
	public String deleteAmbiente(@PathVariable("id") Long id) {

		ambienteRepository.deleteById(id);
		return "redirect:/ambiente";
	}
}
