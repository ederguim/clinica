package com.clinica.thais.araujo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.thais.araujo.entidade.Anamnese;
import com.clinica.thais.araujo.entidade.Bioimpedancia;
import com.clinica.thais.araujo.entidade.Cliente;
import com.clinica.thais.araujo.entidade.PlanoTerapeutico;
import com.clinica.thais.araujo.entidade.Questionario;
import com.clinica.thais.araujo.service.AnamneseService;
import com.clinica.thais.araujo.service.BioimpedanciaService;
import com.clinica.thais.araujo.service.ClienteService;
import com.clinica.thais.araujo.service.PlanoTerapeuticoService;
import com.clinica.thais.araujo.service.QuestionarioService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private QuestionarioService questionarioService;
	
	@Autowired
	private BioimpedanciaService bioimpedanciaService;
	
	@Autowired
	private PlanoTerapeuticoService planoTerapeuticoService;
	
	@Autowired
	private AnamneseService anamneseService;

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
		if (clienteService.findOneByUsername(cliente.getNome()) != null) {
			throw new RuntimeException("Cliente já cadastrado!");
		}
		return new ResponseEntity<Cliente>(clienteService.save(cliente), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/alterar", method = RequestMethod.PUT)
	public Cliente updateCliente(@RequestBody Cliente cliente) {
		Cliente cliente_ = clienteService.findOneByUsername(cliente.getNome());
		if (cliente_ != null && cliente_.getId() != cliente.getId()) {
			throw new RuntimeException("Cliente já cadastrado");
		}
		return clienteService.save(cliente);

	}

	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public List<Cliente> users() {
		return clienteService.findAll();
	}

	@RequestMapping(value = "/cliente-by-id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> userById(@PathVariable Long id) {
		Cliente cliente = clienteService.findOne(id);
		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/questionario-by-id-cliente/{id}", method = RequestMethod.GET)
	public List<Questionario> findByQuestionario_ClienteId(@PathVariable Long id) {
			return questionarioService.findByClienteId(id);
	}
	
	@RequestMapping(value = "/bioimpedancia-by-id-cliente/{id}", method = RequestMethod.GET)
	public List<Bioimpedancia> findByBioimpedancia_ClienteId(@PathVariable Long id) {
			return bioimpedanciaService.findByClienteId(id);
	}
	
	@RequestMapping(value = "/planto-terapeutico-by-id-cliente/{id}", method = RequestMethod.GET)
	public List<PlanoTerapeutico> findByPlanto_Terapeutico_ClienteId(@PathVariable Long id) {
			return planoTerapeuticoService.findByClienteId(id);
	}
	
	@RequestMapping(value = "/anamnese-by-id-cliente/{id}", method = RequestMethod.GET)
	public List<Anamnese> findByAnamnese_ClienteId(@PathVariable Long id) {
			return anamneseService.findByClienteId(id);
	}

	@RequestMapping(value = "/cadastrar_questionario", method = RequestMethod.POST)
	public ResponseEntity<Questionario> createQuestionario(@RequestBody Questionario questionario) {
		return new ResponseEntity<Questionario>(questionarioService.save(questionario), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/cadastrar_bioimpedancia", method = RequestMethod.POST)
	public ResponseEntity<Bioimpedancia> createBioimpedancia(@RequestBody Bioimpedancia bioimpedancia) {
		return new ResponseEntity<Bioimpedancia>(bioimpedanciaService.createBioimpedancia(bioimpedancia), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/cadastrar_planto_terapeutico", method = RequestMethod.POST)
	public ResponseEntity<PlanoTerapeutico> createPlanoTerapeutico(@RequestBody PlanoTerapeutico planoTerapeutico) {
		return new ResponseEntity<PlanoTerapeutico>(planoTerapeuticoService.save(planoTerapeutico), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/cadastrar_anamnese", method = RequestMethod.POST)
	public ResponseEntity<Anamnese> createAnamnese(@RequestBody Anamnese anamnese) {
		return new ResponseEntity<Anamnese>(anamneseService.save(anamnese), HttpStatus.CREATED);
	}
}
