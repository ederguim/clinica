package com.clinica.thais.araujo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.thais.araujo.entidade.Usuario;
import com.clinica.thais.araujo.service.UsuarioService;

@RestController
@RequestMapping(value = "/api")
public class UsuarioController {
	
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<Usuario> users() {
        return usuarioService.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> userById(@PathVariable Long id) {
    	Usuario appUser = usuarioService.findOne(id);
        if (appUser == null) {
            return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Usuario>(appUser, HttpStatus.OK);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> deleteUser(@PathVariable Long id) {
        Usuario appUser = usuarioService.findOne(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = auth.getName();
        if (appUser == null) {
            return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
        } else if (appUser.getUsername().equalsIgnoreCase(loggedUsername)) {
            throw new RuntimeException("You cannot delete your account");
        } else {
            usuarioService.delete(appUser);
            return new ResponseEntity<Usuario>(appUser, HttpStatus.OK);
        }

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
        if (usuarioService.findOneByUsername(usuario.getUsername()) != null) {
            throw new RuntimeException("Username already exist");
        }
        String encode = bCryptPasswordEncoder.encode(usuario.getPassword());
		usuario.setPassword(encode);
        return new ResponseEntity<Usuario>(usuarioService.save(usuario), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public Usuario updateUser(@RequestBody Usuario usuario) {
        if (usuarioService.findOneByUsername(usuario.getUsername()) != null
                && usuarioService.findOneByUsername(usuario.getUsername()).getId() != usuario.getId()) {
            throw new RuntimeException("Username already exist");
        }
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        return usuarioService.save(usuario);
    }

}
