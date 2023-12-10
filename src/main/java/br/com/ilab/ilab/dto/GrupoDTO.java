package br.com.ilab.ilab.dto;

import java.util.Date;

import br.com.ilab.ilab.entities.Grupo;

public class GrupoDTO {

	private Long id;

	private String nomeGrupo;

	private String siglaGrupo;

	private Date dataCriacao;

	private Date dataEncerramento;

	public GrupoDTO() {

	}

	public GrupoDTO(Grupo grupo) {
		super();
		this.id = grupo.getId();
		this.nomeGrupo = grupo.getNomeGrupo();
		this.siglaGrupo = grupo.getSiglaGrupo();
		this.dataCriacao = grupo.getDataCriacao();
		this.dataEncerramento = grupo.getDataEncerramento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public String getSiglaGrupo() {
		return siglaGrupo;
	}

	public void setSiglaGrupo(String siglaGrupo) {
		this.siglaGrupo = siglaGrupo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

}
