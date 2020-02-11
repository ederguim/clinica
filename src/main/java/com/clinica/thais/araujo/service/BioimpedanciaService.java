package com.clinica.thais.araujo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.thais.araujo.entidade.Bioimpedancia;
import com.clinica.thais.araujo.repository.BioimpedanciaRepository;

@Service("bioimpedanciaService")
@Transactional
public class BioimpedanciaService {

	@Autowired
	private BioimpedanciaRepository repository;
	
	public Bioimpedancia save(Bioimpedancia bioimpedancia) {
		bioimpedancia.setData_cadastro(new Date());
		bioimpedancia.setData_avaliacao(new Date());
		return repository.save(bioimpedancia);
	}

	public List<Bioimpedancia> findAll() {
		return repository.findAll();
	}


	public Bioimpedancia findOne(Long id) {
		return repository.findOne(id);
	}

	public List<Bioimpedancia> findByBioimpedancia_ClienteId(Long clienteId) {
		return repository.findByBioimpedancia_ClienteId(clienteId);
	}
}
