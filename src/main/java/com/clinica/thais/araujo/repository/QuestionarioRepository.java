package com.clinica.thais.araujo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.thais.araujo.entidade.Questionario;

@Repository
public interface QuestionarioRepository extends JpaRepository<Questionario, Long> {

	List<Questionario> findByClienteId(Long cliente_id);
}
