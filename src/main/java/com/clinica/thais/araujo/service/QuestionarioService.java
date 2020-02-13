package com.clinica.thais.araujo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.thais.araujo.entidade.Questionario;
import com.clinica.thais.araujo.repository.QuestionarioRepository;

@Service("questionarioService")
@Transactional
public class QuestionarioService {

	@Autowired
	private QuestionarioRepository repository;
	
	public Questionario save(Questionario questionario) {
		return repository.save(questionario);
	}

	public List<Questionario> findAll() {
		return repository.findAll();
	}


	public Questionario findOne(Long id) {
		return repository.findOne(id);
	}

	public List<Questionario> findByClienteId(Long cliente_id) {
		return repository.findByClienteId(cliente_id);
	}
}
