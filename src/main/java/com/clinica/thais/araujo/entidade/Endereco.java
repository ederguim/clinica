package com.clinica.thais.araujo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String cep;

	@Column
	private String logradouro;

	@Column
	private String numero;

	@Column
	private String complemento;

	@Column
	private String municipio;
	
	@Column
	private String estado;
	
	@Column
	private String bairro;

}
