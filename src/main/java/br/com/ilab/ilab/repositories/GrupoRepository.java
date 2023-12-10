package br.com.ilab.ilab.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ilab.ilab.entities.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long>{
	Optional<Grupo> findBySiglaGrupo(String siglaGrupo);
	Optional<Grupo> findByNomeGrupo(String nomeGrupo);

	
}

