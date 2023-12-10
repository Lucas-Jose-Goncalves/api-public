package br.com.ilab.ilab.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.ilab.ilab.exceptions.CursoException;

public enum CursoFormacaoEnum {

	FORMACAO_BASICA("Formação Básica"), FORMACAO_BASICA_AVANCADA("Formação Básica Avançada"),
	FORMACAO_AVANCADA("Formação Avançada"), FORMACAO_AUTOMACAO_BASICA("Formação de Automação Básica"),
	FORMACAO_AUTOMACAO_ESPECIALIZADA("Formação de Automação Especializada"),
	FORMACAO_REQUISITOS("Formação de Requisitos"), FORMACAO_CERTIFICACAO("Formação para Certificação"),
	FORMACAO_LIDERANCA_TESTE("Formação de Liderança de Teste"), FORMACAO_AGILIDADE("Formação em Agilidade");

	private String descricao;

	private CursoFormacaoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@JsonCreator
	public static CursoFormacaoEnum verifica(String value) throws CursoException {
		for (CursoFormacaoEnum c : values()) {
			if (value.equals(c.getDescricao())) {
				return c;
			}
		}
		throw new CursoException("Formação preenchida incorretamente.");
	}

}
