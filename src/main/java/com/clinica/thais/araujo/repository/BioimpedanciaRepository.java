package com.clinica.thais.araujo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clinica.thais.araujo.entidade.Bioimpedancia;

@Repository
public interface BioimpedanciaRepository extends JpaRepository<Bioimpedancia, Long> {
	
//	@Query(name = "SELECT b.* FROM Bioimpedancia as b WHERE b.cliente.id = ?1", nativeQuery = true)
	List<Bioimpedancia> findByBioimpedancia_ClienteId(Long clienteId);


}
