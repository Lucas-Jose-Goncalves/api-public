package br.com.ilab.ilab.enums;

public enum TipoEnum {
	COLABORADOR("Col"),
	ESTAGIARIO("Est"),
	TRAINEE("Tra"),
	EXTERNO("Ext"),
	SERRATEC("Ser");
	
	private final String sigla;
	
	TipoEnum(String sigla){
		this.sigla = sigla;
	}
	
	public String getSigla() {
		return sigla;
	}
}
