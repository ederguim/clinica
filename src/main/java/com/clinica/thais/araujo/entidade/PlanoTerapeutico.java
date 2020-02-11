package com.clinica.thais.araujo.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PlanoTerapeutico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Lob
	@Column(name = "objetivo")
	private String objetivo;
	
	@Lob
	@Column(name = "queixa")
	private String queixa;
	
	@Column(name = "pa")
	private String pa;
	
	@Column(name = "glicemia")
	private String glicemia;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_cadastro;
}
