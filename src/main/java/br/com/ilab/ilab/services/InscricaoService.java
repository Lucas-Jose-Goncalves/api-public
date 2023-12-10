package br.com.ilab.ilab.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ilab.ilab.dto.InscricaoDTO;
import br.com.ilab.ilab.entities.Curso;
import br.com.ilab.ilab.entities.Grupo;
import br.com.ilab.ilab.entities.Inscricao;
import br.com.ilab.ilab.entities.Participante;
import br.com.ilab.ilab.exceptions.UnprocessableEntityException;
import br.com.ilab.ilab.repositories.CursoRepository;
import br.com.ilab.ilab.repositories.GrupoRepository;
import br.com.ilab.ilab.repositories.InscricaoRepository;
import br.com.ilab.ilab.repositories.ParticipanteRepository;

@Service
public class InscricaoService {

	@Autowired
	private InscricaoRepository inscricaoRepository;

	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private ParticipanteRepository participanteRepository;

	// GetAll
	public List<InscricaoDTO> findAll() {
		List<Inscricao> inscricao = inscricaoRepository.findAll();
		List<InscricaoDTO> inscricaoDTO = inscricao.stream().map(i -> new InscricaoDTO(i)).collect(Collectors.toList());
		return inscricaoDTO;
	}

	// Get ID
	public InscricaoDTO findById(Long id) throws UnprocessableEntityException {
		Optional<Inscricao> inscricao = inscricaoRepository.findById(id);
		if (inscricao.isEmpty()) {
			throw new UnprocessableEntityException("Inscricão '" + id + "'não encontrada");
		}
		InscricaoDTO inscricaoDTO = new InscricaoDTO(inscricao.get());
		return inscricaoDTO;
	}

	// Get Consulta-Curso
	public List<Object[]> consultarPorCurso(String siglaCurso) throws UnprocessableEntityException {
		List<Object[]> consultaCursos = inscricaoRepository.consultaCursos(siglaCurso);
		if (consultaCursos.isEmpty()) {
			throw new UnprocessableEntityException(
					"Curso '" + siglaCurso + "' não encontrado, verifique o código e tente novamente.");
		}
		return consultaCursos;
	}

	// Post
	@Transactional
	public InscricaoDTO insert(InscricaoDTO inscricaoDTO) throws UnprocessableEntityException {
		Inscricao inscricao = new Inscricao();
		inscricao.setSequencia(inscricaoDTO.getSequencia());
		inscricao.setDataRegistro(inscricaoDTO.getDataRegistro());
		inscricao.setDataInicioCurso(inscricaoDTO.getDataInicioCurso());
		inscricao.setDataEncerramentoCurso(inscricaoDTO.getDataEncerramentoCurso());
		inscricao.setUltimoAcesso(inscricaoDTO.getUltimoAcesso());
		inscricao.setHorasEstudo(inscricaoDTO.getHorasEstudo());
		inscricao.setSituacao(inscricaoDTO.getSituacao());
		inscricao.setDataSituacao(inscricaoDTO.getDataSituacao());
		inscricao.setMotivo(inscricaoDTO.getMotivo());
		inscricao.setNotaFinal(inscricaoDTO.getNotaFinal());
		inscricao.setEstado(inscricaoDTO.getEstado());
		inscricao.setDataConclusao(inscricaoDTO.getDataConclusao());

		Optional<Curso> curso = cursoRepository.findBySiglaCurso(inscricaoDTO.getSiglaCurso());
		if (curso.isPresent()) {
			inscricao.setCurso(curso.get());
		} else {
			throw new UnprocessableEntityException(
					"Curso '" + inscricaoDTO.getSiglaCurso() + "' não encontrado, verifique o código novamente.");
		}

		Optional<Grupo> grupo = grupoRepository.findBySiglaGrupo(inscricaoDTO.getSiglaGrupo());
		if (grupo.isPresent()) {
			inscricao.setGrupo(grupo.get());
		} else {
			throw new UnprocessableEntityException(
					"Grupo '" + inscricaoDTO.getSiglaGrupo() + "' não encontrado, verifique o código novamente.");
		}

		Optional<Participante> participante = participanteRepository
				.findByIdentificador(inscricaoDTO.getIdentificador());
		if (participante.isPresent()) {
			inscricao.setParticipante(participante.get());
		} else {
			throw new UnprocessableEntityException("Participante '" + inscricaoDTO.getIdentificador()
					+ "' não encontrado, verifique o código novamente.");
		}

		inscricao = inscricaoRepository.save(inscricao);
		return new InscricaoDTO(inscricao);

	}

	// Put Id
	public InscricaoDTO update(InscricaoDTO inscricaoDTO, Long id) throws UnprocessableEntityException {
		Optional<Inscricao> inscricaoOpt = inscricaoRepository.findById(id);
		if (inscricaoOpt.isEmpty()) {
			throw new UnprocessableEntityException("Inscricão não encontrada");
		}
		Inscricao inscricao = inscricaoOpt.get();
		inscricao.setId(id);
		inscricao.setSequencia(inscricaoDTO.getSequencia());
		inscricao.setDataRegistro(inscricaoDTO.getDataRegistro());
		inscricao.setDataInicioCurso(inscricaoDTO.getDataInicioCurso());
		inscricao.setDataEncerramentoCurso(inscricaoDTO.getDataEncerramentoCurso());
		inscricao.setUltimoAcesso(inscricaoDTO.getUltimoAcesso());
		inscricao.setHorasEstudo(inscricaoDTO.getHorasEstudo());
		inscricao.setSituacao(inscricaoDTO.getSituacao());
		inscricao.setDataSituacao(inscricaoDTO.getDataSituacao());
		inscricao.setMotivo(inscricaoDTO.getMotivo());
		inscricao.setNotaFinal(inscricaoDTO.getNotaFinal());
		inscricao.setEstado(inscricaoDTO.getEstado());
		inscricao.setDataConclusao(inscricaoDTO.getDataConclusao());

		Optional<Curso> curso = cursoRepository.findBySiglaCurso(inscricaoDTO.getSiglaCurso());
		if (curso.isPresent()) {
			inscricao.setCurso(curso.get());
		} else {
			throw new UnprocessableEntityException(
					"Curso '" + inscricaoDTO.getSiglaCurso() + "' não encontrado, verifique o código novamente.");
		}

		Optional<Grupo> grupo = grupoRepository.findBySiglaGrupo(inscricaoDTO.getSiglaGrupo());
		if (grupo.isPresent()) {
			inscricao.setGrupo(grupo.get());
		} else {
			throw new UnprocessableEntityException(
					"Grupo '" + inscricaoDTO.getSiglaGrupo() + "' não encontrado, verifique o código novamente.");
		}

		Optional<Participante> participante = participanteRepository
				.findByIdentificador(inscricaoDTO.getIdentificador());
		if (participante.isPresent()) {
			inscricao.setParticipante(participante.get());
		} else {
			throw new UnprocessableEntityException("Participante '" + inscricaoDTO.getIdentificador()
					+ "' não encontrado, verifique o código novamente.");
		}

		inscricaoRepository.save(inscricao);
		return new InscricaoDTO(inscricao);
	}

	// Delete
	@Transactional
	public void delete(Long id) throws UnprocessableEntityException {
		Optional<Inscricao> inscricaoOpt = inscricaoRepository.findById(id);
		if (inscricaoOpt.isEmpty()) {
			throw new UnprocessableEntityException("Inscricão '" + id + "' não encontrada, verifique novamente.");
		}
		inscricaoRepository.deleteById(id);
	}

}
