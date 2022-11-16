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

import com.microservice.gs.model.Veiculo;
import com.microservice.gs.repository.VeiculoRepository;

@Controller
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@GetMapping("/veiculos")
	public String homePage(Model model) {
		model.addAttribute("veiculolista", veiculoRepository.findAll());
		return "home";
	}

	@GetMapping("/saveVeiculoView")
	public String saveVeiculoView(Model model) {
		Veiculo veiculo = new Veiculo();
		model.addAttribute("veiculo", veiculo);
		return "add_veiculo";
	}

	
	@PostMapping("/saveVeiculo")
	public String saveVeiculo(@ModelAttribute("veiculo") Veiculo veiculo) {
		veiculoRepository.save(veiculo);
		return "redirect:/veiculos";
	}

	@GetMapping("/veiculosUpdateView/{id}")
	public String showUpdateVeiculoView(@PathVariable("id") Long id, Model model) {
		Optional<Veiculo> temp = veiculoRepository.findById(id);
		Veiculo veiculo = temp.get();
		model.addAttribute("veiculo", veiculo);
		return "update_veiculo";
	}

	@GetMapping("/deleteVeiculos/{id}")
	public String deleteVeiculo(@PathVariable("id") Long id) {

		veiculoRepository.deleteById(id);
		return "redirect:/veiculos";
	}
}
