package com.clinica.thais.araujo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.thais.araujo.entidade.PlanoTerapeutico;

@Repository
public interface PlanoTerapeuticoRepository extends JpaRepository<PlanoTerapeutico, Long> {

	List<PlanoTerapeutico> findByClienteId(Long cliente_id);
}
