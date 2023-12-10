package br.com.ilab.ilab.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ilab.ilab.dto.CursoDTO;
import br.com.ilab.ilab.entities.Curso;
import br.com.ilab.ilab.exceptions.UnprocessableEntityException;
import br.com.ilab.ilab.repositories.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	// GetAll
	public List<CursoDTO> findAll() {
		List<Curso> curso = cursoRepository.findAll();
		List<CursoDTO> cursoDTO = curso.stream().map(c -> new CursoDTO(c)).collect(Collectors.toList());
		return cursoDTO;
	}

	// Get ID
	public CursoDTO findById(Long id) throws UnprocessableEntityException {
		Optional<Curso> curso = cursoRepository.findById(id);
		if (curso.isEmpty()) {
			throw new UnprocessableEntityException("Curso '" + id + "' não encontrado");
		}
		CursoDTO cursoDTO = new CursoDTO(curso.get());
		return cursoDTO;
	}

	// Get SIGLA
	public CursoDTO findBySigla(String siglaCurso) throws UnprocessableEntityException {
		Optional<Curso> curso = cursoRepository.findBySiglaCurso(siglaCurso);
		if (!curso.isPresent()) {
			throw new UnprocessableEntityException("Curso '" + siglaCurso + "' não encontrado");
		}
		CursoDTO cursoDTO = new CursoDTO(curso.get());
		return cursoDTO;
	}

	// Post
	@Transactional
	public CursoDTO insert(CursoDTO cursoDTO) throws UnprocessableEntityException {
		Optional<Curso> cursoExistente = cursoRepository.findBySiglaCurso(cursoDTO.getSiglaCurso());

		if (cursoExistente.isPresent()) {
			throw new UnprocessableEntityException(
					"A sigla '" + cursoDTO.getSiglaCurso() + "' do curso já existe no banco de dados.");
		}

		Curso curso = new Curso();
		curso.setId(cursoDTO.getId());
		curso.setPlataforma(cursoDTO.getPlataforma());
		curso.setSiglaCurso(cursoDTO.getSiglaCurso());
		curso.setFormacao(cursoDTO.getFormacao());
		curso.setNomeCurso(cursoDTO.getNomeCurso());
		curso.setDataCadastramento(cursoDTO.getDataCadastramento());

		curso = cursoRepository.save(curso);

		return new CursoDTO(curso);
	}

	// Put Id
	public CursoDTO update(CursoDTO cursoEditarDTO, Long id) throws UnprocessableEntityException {
		Optional<Curso> cursoOpt = cursoRepository.findById(id);
		if (cursoOpt.isEmpty()) {
			throw new UnprocessableEntityException("Curso '" + id + "' não encontrado");
		}
		Curso curso = cursoOpt.get();
		curso.setId(id);
		curso.setPlataforma(cursoEditarDTO.getPlataforma());
		curso.setSiglaCurso(cursoEditarDTO.getSiglaCurso());
		curso.setFormacao(cursoEditarDTO.getFormacao());
		curso.setNomeCurso(cursoEditarDTO.getNomeCurso());
		curso.setDataCadastramento(new Date());

		cursoRepository.save(curso);

		CursoDTO cursoDTO = new CursoDTO(curso);
		return cursoDTO;

	}

	// Put Sigla
	public CursoDTO updateSigla(CursoDTO cursoEditarDTO, String siglaCurso) throws UnprocessableEntityException {
		Optional<Curso> cursoOpt = cursoRepository.findBySiglaCurso(siglaCurso);
		if (cursoOpt.isEmpty()) {
			throw new UnprocessableEntityException("Curso '" + siglaCurso + "' não encontrado");
		}

		Curso curso = cursoOpt.get();

		curso.setPlataforma(cursoEditarDTO.getPlataforma());
		curso.setSiglaCurso(siglaCurso);
		curso.setFormacao(cursoEditarDTO.getFormacao());
		curso.setNomeCurso(cursoEditarDTO.getNomeCurso());
		curso.setDataCadastramento(new Date());

		cursoRepository.save(curso);

		CursoDTO cursoDTO = new CursoDTO(curso);
		return cursoDTO;

	}

	// Delete
	@Transactional
	public void delete(Long id) throws UnprocessableEntityException {
		Optional<Curso> cursoOpt = cursoRepository.findById(id);
		if (cursoOpt.isEmpty()) {
			throw new UnprocessableEntityException("Curso '" + id + "' não encontrado, verifique novamente.");
		}
		cursoRepository.deleteById(id);
	}

	// Delete Sigla
	@Transactional
	public void deleteSigla(String siglaCurso) throws UnprocessableEntityException {
		Optional<Curso> cursoOpt = cursoRepository.findBySiglaCurso(siglaCurso);
		if (cursoOpt.isEmpty()) {
			throw new UnprocessableEntityException("Curso '" + siglaCurso + "' não encontrado, verifique novamente.");
		}
		cursoRepository.delete(cursoOpt.get());
	}

}
