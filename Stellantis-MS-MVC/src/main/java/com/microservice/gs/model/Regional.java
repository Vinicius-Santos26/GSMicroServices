package com.microservice.gs.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_regional")
public class Regional {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "veiculos_id")
	private List<Veiculo> veiculos;

	public Regional(List<Veiculo> veiculos) {
		this.data = LocalDate.now();
		this.veiculos = veiculos;
	}

	public Regional() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = LocalDate.now();
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	

}
