package com.clinica.thais.araujo.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cliente_sequence")
	@SequenceGenerator(name = "cliente_sequence", sequenceName = "CLIENTE_SEQ")
	private Long id;
	
	@Column(name = "cpf")
	private Long cpf;
	
	@Column(name = "nome")
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_nascimento;
	
	@Column(name = "estado_civil")
	private String estado_civil;
	
	@Column(name = "profissao")
	private String profissao;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telefone")
	private String telefone;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data_cadastro;

	@Lob
	@Column(name = "image")
	private byte[] image;
}