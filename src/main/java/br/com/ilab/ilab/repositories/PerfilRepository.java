package br.com.ilab.ilab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ilab.ilab.entities.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
