package com.clinica.thais.araujo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.thais.araujo.entidade.Cliente;
import com.clinica.thais.araujo.repository.ClienteRepository;

@Service("clienteService")
@Transactional
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public Cliente findOneByUsername(String nome) {
		return repository.findOneByUsername(nome);
	}
	

	public Cliente save(Cliente cliente) {
		cliente.setData_cadastro(new Date());
		cliente.setData_nascimento(new Date());
		return repository.save(cliente);
	}

}
