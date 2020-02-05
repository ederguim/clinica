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

import org.hibernate.annotations.Type;

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
	
	@Column(name = "nome")
	private String nome;
	
	@Lob
	@Column(name = "image")
	private byte[] image;
	
	@Column(name = "cpf")
	private Long cpf;
	
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
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "peso")
	private String peso;
	
	@Column(name = "altura")
	private String altura;

	@Column(name = "imc")
	private String imc;

	@Type(type="true_false")
	@Column(name = "doenca_cronica")
	private Boolean doenca_cronica;

	@Column(name = "desc_doenca")
	private String desc_doenca;

	@Type(type="true_false")
	@Column(name = "evac_regular")
	private Boolean evac_regular;

	@Type(type="true_false")
	@Column(name = "hist_famil")
	private Boolean hist_famil;

	@Column(name = "tipo_pele")
	private String tipo_pele;

	@Column(name = "liq_diaria")
	private String liq_diaria;

	@Type(type="true_false")
	@Column(name = "exa_recente")
	private Boolean exa_recente;

	@Column(name = "desc_exame")
	private String desc_exame;

	@Type(type="true_false")
	@Column(name = "aler_medic")
	private Boolean aler_medic;

	@Column(name = "desc_alerg")
	private String desc_alerg;

	@Type(type="true_false")
	@Column(name = "uso_medicamento")
	private Boolean uso_medicamento;

	@Column(name = "desc_uso_medicamento")
	private String desc_uso_medicamento;
	
	@Type(type="true_false")
	@Column(name = "ativ_fisica")
	private Boolean ativ_fisica;

	@Column(name = "desc_ativ_fisica")
	private String desc_ativ_fisica;

	@Column(name = "circ_abdom_1")
	private String circ_abdom_1;

	@Column(name = "circ_abdom_2")
	private String circ_abdom_2;

	@Column(name = "circ_abdom_3")
	private String circ_abdom_3;

	@Column(name = "objetivo")
	private String objetivo;
	
	@Column(name = "queixa")
	private String queixa;
	
	@Column(name = "pa")
	private String pa;
	
	@Column(name = "glicemia")
	private String glicemia;
	
	@Column(name = "anamnese")
	private String anamnese;
}
