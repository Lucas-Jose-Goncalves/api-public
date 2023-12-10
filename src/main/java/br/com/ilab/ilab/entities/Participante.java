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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.ilab.ilab.enums.ParticipanteTipoEnum;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "participanteId", scope = Participante.class)
@Entity
@Table(name = "participante")
public class Participante implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "participante_id")
	private Long participanteId;

	@Column(name = "tipo", nullable = false)
	@Enumerated(EnumType.STRING)
	private ParticipanteTipoEnum tipo;

	@Column(name = "sigla_tipo")
	private String siglaTipo;

	@Column(name = "identificador", unique = true, nullable = false, length = 5)
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).+$", message = "O identificador deve conter pelo menos uma letra e um número obrigatoriamente")
	@Size(min = 2, max = 5, message = "Identificadores maximo 5 caracteres")
	@NotBlank(message = "Campo obrigatório, insira o identificador.")
	private String identificador;

	@Column(name = "nome", nullable = false, length = 40)
	@Size(min = 1, max = 40, message = "Nome com no máximo 40 caracteres")
	@NotBlank(message = "Campo obrigatório, insira o nome.")
	private String nome;

	@Email(message = "Insira um Email válido.")
	@Column(name = "email", unique = true, nullable = false)
	@NotBlank(message = "Campo obrigatório, insira o e-mail.")
	private String email;

	@Column(name = "data_cadastro", nullable = false)
	@NotNull(message = "Campo obrigatório, insira a data de cadastro.")
	private Date dataCadastro;

	public Participante() {

	}

	public Participante(Long participanteId, ParticipanteTipoEnum tipo, String siglaTipo, String identificador,
			String nome, String email, Date dataCadastro) {
		super();
		this.participanteId = participanteId;
		this.tipo = tipo;
		this.siglaTipo = siglaTipo;
		this.identificador = identificador;
		this.nome = nome;
		this.email = email;
		this.dataCadastro = dataCadastro;
	}

	public Long getParticipanteId() {
		return participanteId;
	}

	public void setParticipanteId(Long participanteId) {
		this.participanteId = participanteId;
	}

	public ParticipanteTipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(ParticipanteTipoEnum tipo) {
		this.tipo = tipo;
		if (tipo != null) {
			this.siglaTipo = tipo.getSigla();
		}
	}

	public String getSiglaTipo() {
		return siglaTipo;
	}

	public void setSiglaTipo(String siglaTipo) {
		this.siglaTipo = siglaTipo;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(participanteId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participante other = (Participante) obj;
		return Objects.equals(participanteId, other.participanteId);
	}

}
