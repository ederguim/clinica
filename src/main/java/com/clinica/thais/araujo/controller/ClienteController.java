package com.clinica.thais.araujo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.thais.araujo.entidade.Cliente;
import com.clinica.thais.araujo.service.ClienteService;

@RestController
public class ClienteController {
    
	@Autowired
    private ClienteService clienteService;

	 @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
	        if (clienteService.findOneByUsername(cliente.getNome()) != null) {
	            throw new RuntimeException("Cliente já cadastrado!");
	        }
	        return new ResponseEntity<Cliente>(clienteService.save(cliente), HttpStatus.CREATED);
	    }

}
