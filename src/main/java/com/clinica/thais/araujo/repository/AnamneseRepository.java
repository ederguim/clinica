package com.clinica.thais.araujo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.thais.araujo.entidade.Anamnese;

@Repository
public interface AnamneseRepository extends JpaRepository<Anamnese, Long> {


}
