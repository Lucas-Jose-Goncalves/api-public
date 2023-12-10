package br.com.ilab.ilab.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ilab.ilab.dto.ParticipanteDTO;
import br.com.ilab.ilab.entities.Participante;
import br.com.ilab.ilab.exceptions.UnprocessableEntityException;
import br.com.ilab.ilab.repositories.ParticipanteRepository;

@Service
public class ParticipanteService {

	@Autowired
	ParticipanteRepository participanteRepository;

	// GetAll
	public List<ParticipanteDTO> findAll() {
		List<Participante> participante = participanteRepository.findAll();
		List<ParticipanteDTO> participantesDTO = participante.stream().map(c -> new ParticipanteDTO(c))
				.collect(Collectors.toList());
		return participantesDTO;
	}

	// Get ID
	public ParticipanteDTO findById(Long id) throws UnprocessableEntityException {
		Optional<Participante> participante = participanteRepository.findById(id);
		if (participante.isEmpty()) {
			throw new UnprocessableEntityException("Participante '"+id+"' não encontrado");
		}
		ParticipanteDTO participanteDTO = new ParticipanteDTO(participante.get());
		return participanteDTO;
	}

	// Get IDENTIFICADOR
	public ParticipanteDTO findByIdentificador(String identificador) throws UnprocessableEntityException {
		Optional<Participante> participante = participanteRepository.findByIdentificador(identificador);
		if (participante.isEmpty()) {
			throw new UnprocessableEntityException("Participante '"+identificador+"' não encontrado");
		}
		ParticipanteDTO participanteDTO = new ParticipanteDTO(participante.get());
		return participanteDTO;
	}

	// Post
	@Transactional
	public ParticipanteDTO insert(ParticipanteDTO participanteDTO) throws UnprocessableEntityException {
		Optional<Participante> participanteIdentificador = participanteRepository
				.findByIdentificador(participanteDTO.getIdentificador());
		Optional<Participante> participanteEmail = participanteRepository
				.findByEmail(participanteDTO.getEmail());

		if (participanteIdentificador.isPresent()) {
			throw new UnprocessableEntityException("Identificador '"+participanteDTO.getIdentificador()+"' do Participante existente, tente novamente.");
		}

		if (participanteEmail.isPresent()) {
			throw new UnprocessableEntityException("Email '"+participanteDTO.getEmail()+"' do Participante existente, tente novamente.");
		}

		Participante participante = new Participante();
		participante.setParticipanteId(participanteDTO.getParticipanteId());
		participante.setTipo(participanteDTO.getTipo());

		participante.setIdentificador(participanteDTO.getIdentificador());
		participante.setNome(participanteDTO.getNome());
		participante.setEmail(participanteDTO.getEmail());
		participante.setDataCadastro(participanteDTO.getDataCadastro());

		participante = participanteRepository.save(participante);
		return new ParticipanteDTO(participante);

	}

	// Put Id
	public ParticipanteDTO update(ParticipanteDTO participanteEditarDTO, Long id) throws UnprocessableEntityException {
		Optional<Participante> participanteOpt = participanteRepository.findById(id);
		if (participanteOpt.isEmpty()) {
			throw new UnprocessableEntityException("Participante '"+id+"' não encontrado");
		}
		Participante participante = participanteOpt.get();

		participante.setParticipanteId(id);
		participante.setTipo(participanteEditarDTO.getTipo());
		participante.setIdentificador(participanteEditarDTO.getIdentificador());
		participante.setNome(participanteEditarDTO.getNome());
		participante.setEmail(participanteEditarDTO.getEmail());
		participante.setDataCadastro(participanteEditarDTO.getDataCadastro());

		participante = participanteRepository.save(participante);

		ParticipanteDTO participanteDTO = new ParticipanteDTO(participante);
		return participanteDTO;

	}

	// Put IDENTIFICADOR
	public ParticipanteDTO updateIdentificador(ParticipanteDTO participanteEditarDTO, String identificador)
			throws UnprocessableEntityException {
		Optional<Participante> participanteOpt = participanteRepository.findByIdentificador(identificador);
		if (participanteOpt.isEmpty()) {
			throw new UnprocessableEntityException("Participante '"+identificador+"' não encontrado");
		}
		Participante participante = participanteOpt.get();

		participante.setTipo(participanteEditarDTO.getTipo());
		participante.setIdentificador(participanteEditarDTO.getIdentificador());
		participante.setNome(participanteEditarDTO.getNome());
		participante.setEmail(participanteEditarDTO.getEmail());
		participante.setDataCadastro(participanteEditarDTO.getDataCadastro());

		participante = participanteRepository.save(participante);

		ParticipanteDTO participanteDTO = new ParticipanteDTO(participante);
		return participanteDTO;

	}

	// Delete ID
	@Transactional
	public void delete(Long id) throws UnprocessableEntityException {
		Optional<Participante> participanteOpt = participanteRepository.findById(id);
		if (participanteOpt.isEmpty()) {
			throw new UnprocessableEntityException("Participante '"+id+"' não encontrado, verifique novamente.");
		}
		participanteRepository.deleteById(id);
	}

	// Delete Sigla
	@Transactional
	public void deleteSigla(String identificador) throws UnprocessableEntityException {
		Optional<Participante> participanteOpt = participanteRepository.findByIdentificador(identificador);
		if (participanteOpt.isEmpty()) {
			throw new UnprocessableEntityException("Participante '"+identificador+"' não encontrado, verifique novamente.");
		}
		participanteRepository.delete(participanteOpt.get());
	}

}
