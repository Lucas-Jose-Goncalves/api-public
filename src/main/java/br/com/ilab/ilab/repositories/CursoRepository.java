package br.com.ilab.ilab.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ilab.ilab.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {	
	Optional<Curso> findBySiglaCurso(String siglaCurso);
}
