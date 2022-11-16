package com.fiap.stellantis.service;

import org.springframework.http.ResponseEntity;

import com.fiap.stellantis.entities.Veiculo;

public interface IVeiculoService {

	public ResponseEntity saveVeiculo(Veiculo veiculo);

}
