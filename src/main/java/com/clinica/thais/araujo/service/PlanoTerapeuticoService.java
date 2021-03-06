package com.clinica.thais.araujo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.thais.araujo.entidade.PlanoTerapeutico;
import com.clinica.thais.araujo.repository.PlanoTerapeuticoRepository;

@Service("planoTerapeuticoService")
@Transactional
public class PlanoTerapeuticoService {

	@Autowired
	private PlanoTerapeuticoRepository repository;
	
	public PlanoTerapeutico save(PlanoTerapeutico planoTerapeutico) {
		return repository.save(planoTerapeutico);
	}

	public List<PlanoTerapeutico> findAll() {
		return repository.findAll();
	}


	public PlanoTerapeutico findOne(Long id) {
		return repository.findOne(id);
	}

	public List<PlanoTerapeutico> findByClienteId(Long cliente_id) {
		return repository.findByClienteId(cliente_id);
	}
}
