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

import com.fiap.stellantis.entities.Ambiente;
import com.fiap.stellantis.entities.Regional;
import com.fiap.stellantis.repositories.AmbienteRepository;

@RestController
public class AmbienteController {

	@Autowired
	private AmbienteRepository ambienteRepository;

	@GetMapping(path = "/ambiente")
	public ResponseEntity<List<Ambiente>> getAmbientes() {
		List<Ambiente> getAmbientes = ambienteRepository.findAll();
		return new ResponseEntity<List<Ambiente>>(getAmbientes, HttpStatus.OK);
	
	}

	@PostMapping(path = "/ambiente")
	public ResponseEntity criarAmbiente(@RequestBody Ambiente ambiente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ambienteRepository.save(ambiente));
	}

	@PutMapping(path = "/ambiente/{id}")
	public ResponseEntity atualizarAmbiente(@PathVariable Long id,@RequestBody Ambiente ambiente) {
		Optional<Ambiente> optionalAmbiente = ambienteRepository.findById(id);

		if (optionalAmbiente.isPresent()) {
			ambiente.setId(id);
			ambienteRepository.save(ambiente);
	        return ResponseEntity.status(HttpStatus.CREATED).body(ambienteRepository.save(ambiente));
		}
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
	}

	@DeleteMapping(path = "/ambiente/{id}")
	public ResponseEntity deletarAmbiente(@PathVariable Long id) {
		ambienteRepository.deleteById(id);
        return ResponseEntity.status(200).build();
	}
}
