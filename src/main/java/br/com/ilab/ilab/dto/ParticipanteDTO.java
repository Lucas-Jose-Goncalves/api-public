package br.com.ilab.ilab.dto;

import java.util.Date;

import br.com.ilab.ilab.entities.Participante;
import br.com.ilab.ilab.enums.ParticipanteTipoEnum;

public class ParticipanteDTO {

	private Long participanteId;

	private ParticipanteTipoEnum tipo;

	private String siglaTipo;

	private String identificador;

	private String nome;

	private String email;

	private Date dataCadastro;

	public ParticipanteDTO() {
	}

	public ParticipanteDTO(Participante participante) {
		super();
		this.participanteId = participante.getParticipanteId();
		this.tipo = participante.getTipo();
		this.siglaTipo = participante.getSiglaTipo();
		this.identificador = participante.getIdentificador();
		this.nome = participante.getNome();
		this.email = participante.getEmail();
		this.dataCadastro = participante.getDataCadastro();
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
	

}
