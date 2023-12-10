package br.com.ilab.ilab.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.ilab.ilab.dto.GrupoDTO;
import br.com.ilab.ilab.entities.Grupo;
import br.com.ilab.ilab.exceptions.UnprocessableEntityException;
import br.com.ilab.ilab.repositories.GrupoRepository;

@Service
public class GrupoService {

	@Autowired
	GrupoRepository grupoRepository;

	// GetAll
	public List<GrupoDTO> findAll() {
		List<Grupo> grupo = grupoRepository.findAll();
		List<GrupoDTO> grupoDTO = grupo.stream().map(c -> new GrupoDTO(c)).collect(Collectors.toList());
		return grupoDTO;
	}

	// Get ID
	public GrupoDTO findById(Long id) throws UnprocessableEntityException {
		Optional<Grupo> grupo = grupoRepository.findById(id);
		if (grupo.isEmpty()) {
			throw new UnprocessableEntityException("Grupo '" + id + "' não encontrado");
		}
		GrupoDTO grupoDTO = new GrupoDTO(grupo.get());
		return grupoDTO;
	}

	// Get Sigla
	public GrupoDTO findBySiglaGrupo(String sigla) throws UnprocessableEntityException {
		Optional<Grupo> grupo = grupoRepository.findBySiglaGrupo(sigla);
		if (grupo.isEmpty()) {
			throw new UnprocessableEntityException("Grupo '" + sigla + "' não encontrado");
		}
		GrupoDTO grupoDTO = new GrupoDTO(grupo.get());
		return grupoDTO;
	}

	// Post
	@Transactional
	public GrupoDTO insert(GrupoDTO grupoDTO) throws UnprocessableEntityException {
		Optional<Grupo> grupoNomeGrupoExistente = grupoRepository.findByNomeGrupo(grupoDTO.getNomeGrupo());
		Optional<Grupo> grupoSiglaGrupoExistente = grupoRepository.findBySiglaGrupo(grupoDTO.getSiglaGrupo());

		if (grupoNomeGrupoExistente.isPresent()) {
			throw new UnprocessableEntityException("Nome do Grupo existente, verifique novamente.");
		}
		if (grupoSiglaGrupoExistente.isPresent()) {
			throw new UnprocessableEntityException("Sigla do Grupo existente, verifique novamente.");
		}

		Grupo grupo = new Grupo();
		grupo.setId(grupoDTO.getId());
		grupo.setNomeGrupo(grupoDTO.getNomeGrupo());
		grupo.setSiglaGrupo(grupoDTO.getSiglaGrupo());
		grupo.setDataCriacao(grupoDTO.getDataCriacao());
		grupo.setDataEncerramento(grupoDTO.getDataEncerramento());

		grupo = grupoRepository.save(grupo);
		return new GrupoDTO(grupo);

	}

	// Put Id
	public GrupoDTO update(GrupoDTO grupoEditarDTO, Long id) throws UnprocessableEntityException {
		Optional<Grupo> grupoOpt = grupoRepository.findById(id);
		if (grupoOpt.isEmpty()) {
			throw new UnprocessableEntityException("Grupo '" + id + "' não encontrado");
		}
		Grupo grupo = grupoOpt.get();
		grupo.setId(id);
		grupo.setNomeGrupo(grupoEditarDTO.getNomeGrupo());
		grupo.setSiglaGrupo(grupoEditarDTO.getSiglaGrupo());
		grupo.setDataCriacao(grupoEditarDTO.getDataCriacao());
		grupo.setDataEncerramento(grupoEditarDTO.getDataEncerramento());

		grupo = grupoRepository.save(grupo);

		GrupoDTO grupoDTO = new GrupoDTO(grupo);
		return grupoDTO;

	}

	// Put Sigla
	public GrupoDTO updateSigla(GrupoDTO grupoEditarDTO, String sigla) throws UnprocessableEntityException {
		Optional<Grupo> grupoOpt = grupoRepository.findBySiglaGrupo(sigla);
		if (grupoOpt.isEmpty()) {
			throw new UnprocessableEntityException("Grupo '" + sigla + "' não encontrado");
		}

		Grupo grupo = grupoOpt.get();

		grupo.setNomeGrupo(grupoEditarDTO.getNomeGrupo());
		grupo.setSiglaGrupo(grupoEditarDTO.getSiglaGrupo());
		grupo.setDataCriacao(grupoEditarDTO.getDataCriacao());
		grupo.setDataEncerramento(grupoEditarDTO.getDataEncerramento());

		grupo = grupoRepository.save(grupo);

		GrupoDTO grupoDTO = new GrupoDTO(grupo);
		return grupoDTO;

	}

	// Delete ID
	@Transactional
	public void delete(Long id) throws UnprocessableEntityException {
		Optional<Grupo> grupoOpt = grupoRepository.findById(id);
		if (grupoOpt.isEmpty()) {
			throw new UnprocessableEntityException("Grupo '" + id + "'  não encontrado, verifique novamente.");
		}
		grupoRepository.deleteById(id);
	}

	// Delete Sigla
	@Transactional
	public void deleteSigla(String sigla) throws UnprocessableEntityException {
		Optional<Grupo> grupoOpt = grupoRepository.findBySiglaGrupo(sigla);
		if (grupoOpt.isEmpty()) {
			throw new UnprocessableEntityException("Grupo '" + sigla + "' não encontrado, verifique novamente.");
		}
		grupoRepository.delete(grupoOpt.get());
	}

}
