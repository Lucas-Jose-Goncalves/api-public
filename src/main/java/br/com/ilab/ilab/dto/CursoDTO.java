package br.com.ilab.ilab.dto;

import java.util.Date;

import br.com.ilab.ilab.entities.Curso;
import br.com.ilab.ilab.enums.CursoFormacaoEnum;
import br.com.ilab.ilab.enums.CursoPlataformaEnum;

public class CursoDTO {

	private Long id;

	private CursoPlataformaEnum plataforma;

	private String siglaCurso;

	private CursoFormacaoEnum formacao;

	private String nomeCurso;

	private Date dataCadastramento;

	public CursoDTO() {

	}

	public CursoDTO(Curso curso) {
		super();
		this.id = curso.getId();
		this.plataforma = curso.getPlataforma();
		this.siglaCurso = curso.getSiglaCurso();
		this.formacao = curso.getFormacao();
		this.nomeCurso = curso.getNomeCurso();
		this.dataCadastramento = curso.getDataCadastramento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CursoPlataformaEnum getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(CursoPlataformaEnum plataforma) {
		this.plataforma = plataforma;
	}

	public String getSiglaCurso() {
		return siglaCurso;
	}

	public void setSiglaCurso(String siglaCurso) {
		this.siglaCurso = siglaCurso;
	}

	public CursoFormacaoEnum getFormacao() {
		return formacao;
	}

	public void setFormacao(CursoFormacaoEnum formacao) {
		this.formacao = formacao;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Date getDataCadastramento() {
		return dataCadastramento;
	}

	public void setDataCadastramento(Date dataCadastramento) {
		this.dataCadastramento = dataCadastramento;
	}

}
