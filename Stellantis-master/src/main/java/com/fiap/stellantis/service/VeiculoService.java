package com.fiap.stellantis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fiap.stellantis.entities.Regional;
import com.fiap.stellantis.entities.Veiculo;
import com.fiap.stellantis.repositories.RegionalRepository;
import com.fiap.stellantis.repositories.VeiculoRepository;

@Service
public class VeiculoService implements IVeiculoService {

	@Autowired
    public RegionalRepository regionalRepository;
    @Autowired
    public VeiculoRepository veiculoRepository;

    public ResponseEntity saveVeiculo(Veiculo veiculo){

        try {

            List<Veiculo> veiculos = new ArrayList<>();
            veiculos.add(veiculoRepository.save(veiculo));

            Regional regionalModel = new Regional(veiculos);
            regionalRepository.save(regionalModel);

            return ResponseEntity.ok("Veiculo: " + veiculo.toString() + " Regional: "+regionalModel.toString());

        }catch (Exception e){

            return ResponseEntity.internalServerError().body("Obtivemos um erro: " + e.getMessage());

        }
    }

}
