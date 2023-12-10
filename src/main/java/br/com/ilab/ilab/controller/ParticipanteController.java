package br.com.ilab.ilab.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ilab.ilab.dto.ParticipanteDTO;
import br.com.ilab.ilab.services.ParticipanteService;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

	@Autowired
	ParticipanteService participanteService;

	@GetMapping
	public ResponseEntity<List<ParticipanteDTO>> listarParticipantes() {
		return ResponseEntity.ok(participanteService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ParticipanteDTO> buscar(@PathVariable Long id) {
		ParticipanteDTO participanteDTO = participanteService.findById(id);
		if (participanteDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(participanteDTO);
	}

	@GetMapping("/identificador/{identificador}")
	public ResponseEntity<ParticipanteDTO> buscar(@PathVariable String identificador) {
		ParticipanteDTO participanteDTO = participanteService.findByIdentificador(identificador);
		if (participanteDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(participanteDTO);
	}

	@PostMapping
	public ResponseEntity<ParticipanteDTO> inserir(@Valid @RequestBody ParticipanteDTO participanteInserirDTO) {
		ParticipanteDTO participanteDTO = participanteService.insert(participanteInserirDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(participanteDTO.getParticipanteId()).toUri();
		return ResponseEntity.created(uri).body(participanteDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ParticipanteDTO> update(@Valid @RequestBody ParticipanteDTO participanteEditarDTO,
			@PathVariable Long id) {
		ParticipanteDTO participanteDTO = participanteService.update(participanteEditarDTO, id);
		if (participanteDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(participanteDTO);

	}

	@PutMapping("/identificador/{identificador}")
	public ResponseEntity<ParticipanteDTO> update(@Valid @RequestBody ParticipanteDTO participanteEditarDTO,
			@PathVariable String identificador) {
		ParticipanteDTO participanteDTO = participanteService.updateIdentificador(participanteEditarDTO, identificador);
		if (participanteDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(participanteDTO);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		participanteService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/identificador/{identificador}")
	public ResponseEntity<Void> deleteSigla(@PathVariable String identificador) {
		participanteService.deleteSigla(identificador);
		return ResponseEntity.noContent().build();
	}

}
