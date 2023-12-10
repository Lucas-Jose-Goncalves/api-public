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

import br.com.ilab.ilab.dto.InscricaoDTO;
import br.com.ilab.ilab.repositories.InscricaoRepository;
import br.com.ilab.ilab.services.InscricaoService;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

	@Autowired
	private InscricaoService inscricaoService;

	@GetMapping
	public ResponseEntity<List<InscricaoDTO>> listar() {
		return ResponseEntity.ok(inscricaoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<InscricaoDTO> buscar(@PathVariable Long id) {
		InscricaoDTO inscricaoDTO = inscricaoService.findById(id);
		if (inscricaoDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(inscricaoDTO);
	}
	
	//Get Consulta-Curso
	@GetMapping("/consulta-curso/{siglaCurso}")
	public ResponseEntity<List<Object[]>> consultaPorCurso(@PathVariable String siglaCurso) {
		List<Object[]> resultadoConsulta = inscricaoService.consultarPorCurso(siglaCurso);
		return ResponseEntity.ok(resultadoConsulta);
	}

	@PostMapping
	public ResponseEntity<InscricaoDTO> inserir(@Valid @RequestBody InscricaoDTO inscricaoInserirDTO) {
		InscricaoDTO inscricaoDTO = inscricaoService.insert(inscricaoInserirDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(inscricaoDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(inscricaoDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<InscricaoDTO> update(@Valid @RequestBody InscricaoDTO inscricaoEditarDTO,
			@PathVariable Long id) {
		InscricaoDTO inscricaoDTO = inscricaoService.update(inscricaoEditarDTO, id);
		if (inscricaoDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(inscricaoDTO);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		inscricaoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
