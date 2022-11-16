package com.fiap.stellantis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.stellantis.entities.Veiculo;
import com.fiap.stellantis.repositories.VeiculoRepository;
import com.fiap.stellantis.service.IVeiculoService;

@RestController
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private IVeiculoService veiculoService;
	
	

	@GetMapping(path = "/veiculos")
	public ResponseEntity<List<Veiculo>> getVeiculos() {
		List<Veiculo> getVeiculos = veiculoRepository.findAll();
		return new ResponseEntity<List<Veiculo>>(getVeiculos, HttpStatus.OK);
		}

	@PostMapping(path = "/veiculos")
	public ResponseEntity criarVeiculo(@RequestBody Veiculo veiculo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.saveVeiculo(veiculo));
	}

	@PutMapping(path = "/veiculos/{id}")
	public ResponseEntity atualizarVeiculo(@PathVariable Long id,@RequestBody Veiculo veiculo) {
		Optional<Veiculo> optionalVeiculo = veiculoRepository.findById(id);

		if (optionalVeiculo.isPresent()) {
			veiculo.setId(id);
			veiculoRepository.save(veiculo);
	        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.saveVeiculo(veiculo));
		}
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
	}

	@DeleteMapping(path = "/veiculos/{id}")
	public ResponseEntity deletarVeiculo(	 Long id) {
		veiculoRepository.deleteById(id);
        return ResponseEntity.status(200).build();
	}
}
