package br.com.ilab.ilab.controller;

import java.net.URI;
import java.util.List;

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

import br.com.ilab.ilab.dto.CursoDTO;
import br.com.ilab.ilab.services.CursoService;
import javax.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@GetMapping
	public ResponseEntity<List<CursoDTO>> listar() {
		return ResponseEntity.ok(cursoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CursoDTO> buscar(@PathVariable Long id) {
		CursoDTO cursoDTO = cursoService.findById(id);
		if (cursoDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cursoDTO);
	}
	
	@GetMapping("/sigla/{siglaCurso}")
	public ResponseEntity<CursoDTO> buscar(@PathVariable String siglaCurso) {
		CursoDTO cursoDTO = cursoService.findBySigla(siglaCurso);
		if (cursoDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cursoDTO);
	}

	@PostMapping
	public ResponseEntity<CursoDTO> inserir(@Valid @RequestBody CursoDTO cursoInserirDTO) {
		CursoDTO cursoDTO = cursoService.insert(cursoInserirDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cursoDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(cursoDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CursoDTO> update(@Valid @RequestBody CursoDTO cursoEditarDTO, @PathVariable Long id) {
		CursoDTO cursoDTO = cursoService.update(cursoEditarDTO, id);
		if (cursoDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cursoDTO);

	}
	@PutMapping("/sigla/{siglaCurso}")
	public ResponseEntity<CursoDTO> update(@Valid @RequestBody CursoDTO cursoEditarDTO, @PathVariable String siglaCurso) {
		CursoDTO cursoDTO = cursoService.updateSigla(cursoEditarDTO, siglaCurso);
		if (cursoDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cursoDTO);
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		cursoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping("/sigla/{siglaCurso}")
	public ResponseEntity<Void> deleteSigla(@PathVariable String siglaCurso) {
		cursoService.deleteSigla(siglaCurso);
		return ResponseEntity.noContent().build();
	}

}
