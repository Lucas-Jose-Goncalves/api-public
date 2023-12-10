package br.com.ilab.ilab.dto;

import java.util.Date;

import br.com.ilab.ilab.entities.Inscricao;


public class InscricaoDTO {

	private Long id;
	private String sequencia;
	private Date dataRegistro;
	private Date dataInicioCurso;
	private Date dataEncerramentoCurso;
	private Date ultimoAcesso;
	private Double horasEstudo;
	private String situacao;
	private Date dataSituacao;
	private String motivo;
	private Double notaFinal;
	private String estado;
	private Date dataConclusao;
	private String siglaCurso;
	private String siglaGrupo;
	private String identificador;

	public InscricaoDTO(Inscricao inscricao) {
		this.id = inscricao.getId();
		this.sequencia = inscricao.getSequencia();
		this.dataRegistro = inscricao.getDataRegistro();
		this.dataInicioCurso = inscricao.getDataInicioCurso();		
		this.dataEncerramentoCurso = inscricao.getDataEncerramentoCurso();
		this.ultimoAcesso = inscricao.getUltimoAcesso();
		this.horasEstudo = inscricao.getHorasEstudo();
		this.situacao = inscricao.getSituacao();
		this.dataSituacao = inscricao.getDataSituacao();
		this.motivo = inscricao.getMotivo();
		this.notaFinal = inscricao.getNotaFinal();
		this.estado = inscricao.getEstado();
		this.dataConclusao = inscricao.getDataConclusao();
		this.siglaCurso = inscricao.getCurso().getSiglaCurso();
		this.siglaGrupo = inscricao.getGrupo().getSiglaGrupo();
		this.identificador = inscricao.getParticipante().getIdentificador();
		

		
	}

	public InscricaoDTO(Long id) {
		this.id = id;
	}

	public InscricaoDTO() {
		super();
	}



	public InscricaoDTO(Long id, String sequencia, Date dataRegistro, Date dataInicioCurso, Date dataEncerramentoCurso,
			Date ultimoAcesso, Double horasEstudo, String situacao, Date dataSituacao, String motivo, Double notaFinal,
			String estado, Date dataConclusao, String sigla_do_curso, String sigla_do_grupo, String identificador_participante) {
		super();
		this.id = id;
		this.sequencia = sequencia;
		this.dataRegistro = dataRegistro;
		this.dataInicioCurso = dataInicioCurso;
		this.dataEncerramentoCurso = dataEncerramentoCurso;
		this.ultimoAcesso = ultimoAcesso;
		this.horasEstudo = horasEstudo;
		this.situacao = situacao;
		this.dataSituacao = dataSituacao;
		this.motivo = motivo;
		this.notaFinal = notaFinal;
		this.estado = estado;
		this.dataConclusao = dataConclusao;
		this.siglaCurso = sigla_do_curso;
		this.siglaGrupo = sigla_do_grupo;
		this.identificador = identificador_participante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSequencia() {
		return sequencia;
	}

	public void setSequencia(String sequencia) {
		this.sequencia = sequencia;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Date getDataInicioCurso() {
		return dataInicioCurso;
	}

	public void setDataInicioCurso(Date dataInicioCurso) {
		this.dataInicioCurso = dataInicioCurso;
	}

	public Date getDataEncerramentoCurso() {
		return dataEncerramentoCurso;
	}

	public void setDataEncerramentoCurso(Date dataEncerramentoCurso) {
		this.dataEncerramentoCurso = dataEncerramentoCurso;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public Double getHorasEstudo() {
		return horasEstudo;
	}

	public void setHorasEstudo(Double horasEstudo) {
		this.horasEstudo = horasEstudo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Double getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(Double notaFinal) {
		this.notaFinal = notaFinal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public String getSiglaCurso() {
		return siglaCurso;
	}

	public void setSiglaCurso(String siglaCurso) {
		this.siglaCurso = siglaCurso;
	}

	public String getSiglaGrupo() {
		return siglaGrupo;
	}

	public void setSiglaGrupo(String siglaGrupo) {
		this.siglaGrupo = siglaGrupo;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	
	
	}




