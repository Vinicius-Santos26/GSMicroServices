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

import com.fiap.stellantis.entities.Regional;
import com.fiap.stellantis.entities.Veiculo;
import com.fiap.stellantis.repositories.RegionalRepository;

@RestController
public class RegionalController {

	@Autowired
	private RegionalRepository regionalRepository;

	@GetMapping("/regional")
	public ResponseEntity<List<Regional>> getRegional() {
		List<Regional> getRegional = regionalRepository.findAll();
		return new ResponseEntity<List<Regional>>(getRegional, HttpStatus.OK);
	}

	@PostMapping("/regional")
	public ResponseEntity criarRegional(@RequestBody Regional regional) {
        return ResponseEntity.status(HttpStatus.CREATED).body(regionalRepository.save(regional));
}

	@PutMapping(path = "/regional/{id}")
	public ResponseEntity atualizarRegional(@PathVariable Long id,@RequestBody Regional regional) {
		Optional<Regional> optionalRegional = regionalRepository.findById(id);

		if (optionalRegional.isPresent()) {
			regional.setId(id);
			regionalRepository.save(regional);
	        return ResponseEntity.status(HttpStatus.CREATED).body(regionalRepository.save(regional));
		}
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
	}

	@DeleteMapping(path = "/regional/{id}")
	public ResponseEntity deletarRegional(@PathVariable Long id) {
		regionalRepository.deleteById(id);
		return ResponseEntity.status(200).build();
	}
}
