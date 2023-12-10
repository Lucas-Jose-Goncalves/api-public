package br.com.ilab.ilab.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Grupo")
public class Grupo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_grupo")
	private Long id;

	@Column(name = "nome_grupo", unique = true, length = 20)
	@Size(min = 2, max = 20, message = "Nome Grupo deve conter até 20 caracteres, verifique novamente")
	@Pattern(regexp = "^[a-zA-Z0-9 ]*[a-zA-Z][a-zA-Z0-9 ]*$", message = "O nome do grupo deve ser alfanumérico.")
	@NotBlank(message = "Campo obrigatório, insira o nome do grupo.")
	private String nomeGrupo;


	@Size(min = 2, max = 5) // sigla de no máximo 5 caracteres
	@Column(name = "sigla_grupo", unique = true)
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).+$", message = "A sigla Grupo deve conter até 5 caracteres e ter pelo menos uma letra e um número obrigatoriamente")
	@NotBlank(message = "Campo obrigatório, insira a sigla do grupo.")
	private String siglaGrupo;

	@Column(name = "data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull(message = "Campo obrigatório, insira a data de criação.")
	private Date dataCriacao;

	@Column(name = "data_encerramento")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull(message = "Campo obrigatório, insira a data de encerramento.")
	private Date dataEncerramento;

	public Grupo() {

	}

	public Grupo(Long id, String nomeGrupo, String siglaGrupo, Date dataCriacao, Date dataEncerramento) {
		super();
		this.id = id;
		this.nomeGrupo = nomeGrupo;
		this.siglaGrupo = siglaGrupo;
		this.dataCriacao = dataCriacao;
		this.dataEncerramento = dataEncerramento;
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

	@Override
	public String toString() {
		return "Grupo [id=" + id + ", nomeGrupo=" + nomeGrupo + ", siglaGrupo=" + siglaGrupo + ", dataCriacao="
				+ dataCriacao + ", dataEncerramento=" + dataEncerramento + "]";
	}
}
