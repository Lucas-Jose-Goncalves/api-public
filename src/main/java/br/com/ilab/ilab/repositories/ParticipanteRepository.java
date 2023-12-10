package br.com.ilab.ilab.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ilab.ilab.entities.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
	Optional<Participante> findByIdentificador(String identificador);
	Optional<Participante> findByEmail(String email);
}
