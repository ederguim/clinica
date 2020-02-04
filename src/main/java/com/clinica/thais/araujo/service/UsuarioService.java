package com.clinica.thais.araujo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.thais.araujo.entidade.Usuario;
import com.clinica.thais.araujo.repository.UsuarioRepository;

@Service("usuarioService")
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll() {
		return findAll();
	}

	public Usuario findOne(Long id) {
		return findOne(id);
	}

	public void delete(Usuario usuario) {
		repository.delete(usuario);
	}

	public Usuario findOneByUsername(String username) {
		return repository.findOneByUsername(username);
	}

	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}
}
