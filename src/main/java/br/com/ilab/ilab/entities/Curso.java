package br.com.ilab.ilab.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import br.com.ilab.ilab.enums.CursoFormacaoEnum;
import br.com.ilab.ilab.enums.CursoPlataformaEnum;

@Entity
@Table(name = "Curso")
public class Curso implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso")
	private Long id;

	@Column
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Campo obrigatório, insira a plataforma.")
	private CursoPlataformaEnum plataforma;

	@Column(name = "sigla_curso", unique = true, length = 6)
	@Size(max = 6, message = "Somente permitido Sigla com 6 caracteres")
	@NotBlank(message = "Campo obrigatório, insira a sigla do curso.")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).+$", message = "A sigla deve conter uma letra e um número obrigatoriamente")
	private String siglaCurso;

	@Column
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Campo obrigatório, insira a formação.")
	private CursoFormacaoEnum formacao;

	@Column(name = "nome_curso", length = 20)
	@Size(max = 20, message = "Somente permitido com 20 caracteres")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "O nome do curso deve conter somente letras.")
	@NotBlank(message = "Campo obrigatório, insira a sigla do curso.")
	private String nomeCurso;

	@Column(name = "data_cadastramento")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull(message = "Campo obrigatório, insira a data de cadastramento.")
	private Date dataCadastramento;

	public Curso() {

	}

	public Curso(Long id, CursoPlataformaEnum plataforma, String siglaCurso, CursoFormacaoEnum formacao,
			String nomeCurso, Date dataCadastramento) {
		this.id = id;
		this.plataforma = plataforma;
		this.siglaCurso = siglaCurso;
		this.formacao = formacao;
		this.nomeCurso = nomeCurso;
		this.dataCadastramento = dataCadastramento;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", plataforma=" + plataforma + ", siglaCurso=" + siglaCurso + ", formacao="
				+ formacao + ", nomeCurso=" + nomeCurso + ", dataCadastramento=" + dataCadastramento + "]";
	}

}
