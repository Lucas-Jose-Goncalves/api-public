package br.com.ilab.ilab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ilab.ilab.entities.Inscricao;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {	
	
	@Query(value = "select "
			+ "c.sigla_curso as sigla_do_curso, "
			+ "g.sigla_grupo as sigla_do_grupo, "
			+ "p.nome as nome_participante, "
			+ "i.data_inicio_curso, "
			+ "i.horas_estudo, "
			+ "i.situacao, "
			+ "i.data_situacao, "
			+ "i.motivo, "
			+ "i.nota_final, "
			+ "i.estado, "
			+ "i.data_conclusao "
			+ "from inscricao i "
			+ "join curso c on i.sigla_do_curso = c.sigla_curso "
			+ "join grupo g on i.sigla_do_grupo = g.sigla_grupo "
			+ "join participante p on i.identificador_participante = p.identificador "
			+ "where c.sigla_curso = :siglaCurso", nativeQuery = true)
	List<Object[]> consultaCursos(@Param("siglaCurso") String siglaCurso);
	
}
