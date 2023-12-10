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

import br.com.ilab.ilab.dto.GrupoDTO;
import br.com.ilab.ilab.services.GrupoService;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

	@Autowired
	GrupoService grupoService;

	@GetMapping
	public ResponseEntity<List<GrupoDTO>> listarGrupos() {
		return ResponseEntity.ok(grupoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<GrupoDTO> buscar(@PathVariable Long id) {
		GrupoDTO grupoDTO = grupoService.findById(id);
		if (grupoDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(grupoDTO);
	}

	@GetMapping("/sigla/{siglaGrupo}")
	public ResponseEntity<GrupoDTO> buscar(@PathVariable String siglaGrupo) {
		GrupoDTO grupoDTO = grupoService.findBySiglaGrupo(siglaGrupo);
		if (grupoDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(grupoDTO);
	}
	
	@PostMapping
	public ResponseEntity<GrupoDTO> inserir(@Valid @RequestBody GrupoDTO grupoInserirDTO) {
		GrupoDTO grupoDTO = grupoService.insert(grupoInserirDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(grupoDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(grupoDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GrupoDTO> update(@Valid @RequestBody GrupoDTO grupoEditarDTO, @PathVariable Long id) {
		GrupoDTO grupoDTO = grupoService.update(grupoEditarDTO, id);
		if (grupoDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(grupoDTO);

	}
	
	@PutMapping("/sigla/{siglaGrupo}")
	public ResponseEntity<GrupoDTO> update(@Valid @RequestBody GrupoDTO grupoEditarDTO, @PathVariable String siglaGrupo) {
		GrupoDTO grupoDTO = grupoService.updateSigla(grupoEditarDTO, siglaGrupo);
		if (grupoDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(grupoDTO);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		grupoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping("/sigla/{siglaGrupo}")
	public ResponseEntity<Void> deleteSigla(@PathVariable String siglaGrupo) {
		grupoService.deleteSigla(siglaGrupo);
		return ResponseEntity.noContent().build();
	}

}
















