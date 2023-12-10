package br.com.ilab.ilab.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.ilab.ilab.exceptions.CursoException;

public enum CursoPlataformaEnum {

	MOODLE(1, "Moodle"), RISE(2, "Rise");

	private Integer codigo;
	private String plataforma;

	private CursoPlataformaEnum(Integer codigo, String plataforma) {
		this.codigo = codigo;
		this.plataforma = plataforma;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	@JsonCreator
	public static CursoPlataformaEnum verifica(Integer value) throws CursoException {
		for (CursoPlataformaEnum c : values()) {
			if (value.equals(c.getCodigo())) {
				return c ;
			}
		}
		throw new CursoException("Curso preenchido incorretamente.");
	}

}
