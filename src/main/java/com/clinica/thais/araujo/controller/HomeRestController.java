package com.clinica.thais.araujo.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.thais.araujo.entidade.Usuario;
import com.clinica.thais.araujo.service.UsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class HomeRestController {
    
	@Autowired
    private UsuarioService usuarioService;
    
    @Autowired
   	private BCryptPasswordEncoder bCryptPasswordEncoder;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
        if (usuarioService.findOneByUsername(usuario.getUsername()) != null) {
            throw new RuntimeException("Username already exist");
        }
        String encode = bCryptPasswordEncoder.encode(usuario.getPassword());
		usuario.setPassword(encode);
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        usuario.setRoles(roles);
        return new ResponseEntity<Usuario>(usuarioService.save(usuario), HttpStatus.CREATED);
    }

    @RequestMapping("/user")
    public Usuario user(Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = auth.getName();
        return usuarioService.findOneByUsername(loggedUsername);
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> login(@RequestParam String username, @RequestParam String password,
                                                     HttpServletResponse response) throws IOException {
        String token = null;
        Usuario usuario = usuarioService.findOneByUsername(username);
        Map<String, Object> tokenMap = new HashMap<String, Object>();
        if (usuario != null && usuario.getId() != null && bCryptPasswordEncoder.matches(password, usuario.getPassword())) {
            token = Jwts.builder().setSubject(username).claim("roles", usuario.getRoles()).setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
            tokenMap.put("token", token);
            tokenMap.put("user", usuario);
            return new ResponseEntity<Map<String, Object>>(tokenMap, HttpStatus.OK);
        } else {
            tokenMap.put("token", null);
            return new ResponseEntity<Map<String, Object>>(tokenMap, HttpStatus.UNAUTHORIZED);
        }

    }
}
