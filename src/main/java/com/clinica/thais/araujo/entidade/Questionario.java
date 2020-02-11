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

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Questionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Type(type="true_false")
	@Column(name = "doenca_cronica")
	private Boolean doenca_cronica;

	@Lob
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

	@Lob
	@Column(name = "desc_exame")
	private String desc_exame;

	@Type(type="true_false")
	@Column(name = "aler_medic")
	private Boolean aler_medic;

	@Lob
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

	@Lob
	@Column(name = "desc_ativ_fisica")
	private String desc_ativ_fisica;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_cadastro;
}
