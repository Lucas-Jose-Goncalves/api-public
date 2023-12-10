package br.com.ilab.ilab.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Inscricao")
public class Inscricao implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inscricao")
	private Long id;

	@Column(name = "sequencia")	
	private String sequencia;

	@Column(name = "data_registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRegistro;

	@Column(name = "data_inicio_curso")	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicioCurso;

	
	@Column(name = "data_encerramento_curso")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEncerramentoCurso;

	@Column(name = "ultimo_acesso")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimoAcesso;

	@Column(name = "horas_estudo")
	private Double horasEstudo;

	@Column(name = "situacao")
	private String situacao; // N, C, F

	@Column(name = "data_situacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataSituacao;

	@Column(name = "motivo")
	private String motivo;

	@Column(name = "nota_final")
	private Double notaFinal;

	@Column(name = "estado")
	private String estado; // A, R, não se aplica

	@Column(name = "data_conclusao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataConclusao;

	@ManyToOne
	@JoinColumn(name = "sigla_do_curso", referencedColumnName = "sigla_curso")
	@NotNull(message = "Campo obrigatório, insira a sigla do curso.")
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "sigla_do_grupo", referencedColumnName = "sigla_grupo")	
	private Grupo grupo;

	@OneToOne
	@JoinColumn(name = "identificador_participante", referencedColumnName = "identificador")
	@NotNull(message = "Campo obrigatório, insira o identificador.")
	private Participante participante;

	public Inscricao() {
		super();
	}

	public Inscricao(Long id, String sequencia, Date dataRegistro, Date dataInicioCurso, Date dataEncerramentoCurso,
			Date ultimoAcesso, Double horasEstudo, String situacao, Date dataSituacao, String motivo, Double notaFinal,
			String estado, Date dataConclusao, Curso curso, Grupo grupo, Participante participante) {
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
		this.curso = curso;
		this.grupo = grupo;
		this.participante = participante;
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
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
		Inscricao other = (Inscricao) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Inscricao [id=" + id + ", sequencia=" + sequencia + ", dataRegistro=" + dataRegistro
				+ ", dataInicioCurso=" + dataInicioCurso + ", dataEncerramentoCurso=" + dataEncerramentoCurso
				+ ", ultimoAcesso=" + ultimoAcesso + ", horasEstudo=" + horasEstudo + ", situacao=" + situacao
				+ ", dataSituacao=" + dataSituacao + ", motivo=" + motivo + ", notaFinal=" + notaFinal + ", estado="
				+ estado + ", dataConclusao=" + dataConclusao + ", curso=" + curso + ", grupo=" + grupo
				+ ", participante=" + participante + "]";
	}

}
