package com.clinica.thais.araujo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.thais.araujo.entidade.Bioimpedancia;

@Repository
public interface BioimpedanciaRepository extends JpaRepository<Bioimpedancia, Long> {

	List<Bioimpedancia> findByClienteId(Long clienteId);
}
