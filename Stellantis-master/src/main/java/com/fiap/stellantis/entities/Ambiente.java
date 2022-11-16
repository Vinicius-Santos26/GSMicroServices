package com.fiap.stellantis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tb_ambiente")
public class Ambiente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	private String bairro;

	private String cidade;

	private String estado;

	private String temperatura;

	@Column(name = "qualidade_ar")
	@JsonProperty(namespace = "qualidade_ar")
	private String qualidadeAr;

	public Ambiente(Long id, String bairro, String cidade, String estado, String temperatura, String qualidadeAr) {
		super();
		this.id = id;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.temperatura = temperatura;
		this.qualidadeAr = qualidadeAr;
	}

	public Ambiente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public String getQualidadeAr() {
		return qualidadeAr;
	}

	public void setQualidadeAr(String qualidadeAr) {
		this.qualidadeAr = qualidadeAr;
	}

}