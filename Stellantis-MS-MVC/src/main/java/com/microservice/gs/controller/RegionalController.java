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

import com.microservice.gs.model.Regional;
import com.microservice.gs.repository.RegionalRepository;

@Controller
public class RegionalController {
	@Autowired
	private RegionalRepository regionalRepository;

	@GetMapping("/regional")
	public String homePage(Model model) {
		model.addAttribute("regionallista", regionalRepository.findAll());
		return "regional";
	}

	@GetMapping("/saveRegionalView")
	public String saveRegionalView(Model model) {
		Regional regional = new Regional();
		model.addAttribute("regional", regional);
		return "add_regional";
	}

	@PostMapping("/saveRegional")
	public String saveRegional(@ModelAttribute("regional") Regional regional) {
		regionalRepository.save(regional);
		return "redirect:/regional";
	}

	@GetMapping("/updateRegionalView/{id}")
	public String showUpdateRegionalView(@PathVariable("id") Long id, Model model) {
		Optional<Regional> temp = regionalRepository.findById(id);
		Regional regional = temp.get();
		model.addAttribute("regional", regional);
		return "update_regional";
	}

	@GetMapping("/deleteRegional/{id}")
	public String deleteRegional(@PathVariable("id") Long id) {

		regionalRepository.deleteById(id);
		return "redirect:/regional";
	}
}
