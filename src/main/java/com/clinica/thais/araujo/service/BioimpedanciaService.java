package com.clinica.thais.araujo.service;

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
	
	public List<Bioimpedancia> findAll() {
		return repository.findAll();
	}
	
	public Bioimpedancia createBioimpedancia(Bioimpedancia bioimpedancia) {
		return repository.saveAndFlush(bioimpedancia);
	}

	public Bioimpedancia findOne(Long id) {
		return repository.findOne(id);
	}

	public List<Bioimpedancia> findByClienteId(Long id) {
		return repository.findByClienteId(id);
	}
}
