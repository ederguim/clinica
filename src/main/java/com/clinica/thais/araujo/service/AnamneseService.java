package com.clinica.thais.araujo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.thais.araujo.entidade.Anamnese;
import com.clinica.thais.araujo.repository.AnamneseRepository;

@Service("anamneseService")
@Transactional
public class AnamneseService {

	@Autowired
	private AnamneseRepository repository;
	
	public Anamnese save(Anamnese anamnese) {
		anamnese.setData_cadastro(new Date());
		return repository.save(anamnese);
	}

	public List<Anamnese> findAll() {
		return repository.findAll();
	}


	public Anamnese findOne(Long id) {
		return repository.findOne(id);
	}

	public List<Anamnese> findByClienteId(Long cliente_id) {
		return repository.findByClienteId(cliente_id);
	}
}
