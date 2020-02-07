package com.clinica.thais.araujo.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Bioimpedancia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Double peso;
	
	private Double altura;
	
	private Double imc;
	
	private Double gordura;
	
	private Double peso_corporal;
	
	private Double musculo_esqueletico;
	
	private Integer gordura_visceral;
	
	private Double idade_corporal;
	
	private Double medidas_tronco;
	
	private Double medidas_membro;
	
	private Double agua_corporal;
	
	private Double massa_ossea;
	
	private Double metabolismo_basal;
	
	private Double medita_1;
	
	private Double medita_2;
	
	private Double medita_3;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_avaliacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_cadastro;
}
