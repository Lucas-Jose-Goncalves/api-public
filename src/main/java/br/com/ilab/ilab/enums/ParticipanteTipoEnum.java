package br.com.ilab.ilab.enums;

public enum ParticipanteTipoEnum {

	COLABORADOR("COL"), ESTAGIARIO("EST"), TRAINEE("TRA"), EXTERNO("EXT"), SERRATEC("SER");

	private String sigla;	

	private ParticipanteTipoEnum(String sigla) {
		this.sigla = sigla;
	}
	
	public String getSigla() {
		return sigla;
	}

}
