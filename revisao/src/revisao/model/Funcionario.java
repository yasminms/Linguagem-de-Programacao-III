package revisao.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="funcionario")
public class Funcionario implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "nome_completo")
	private String nomeCompleto;
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	private String cpf;
	@Column(name = "data_contratacao")
	private Date dataContratacao;
	@ManyToOne @JoinColumn(name = "cod_departamento")
	private Departamento departamento;
	@ManyToMany @JoinTable(name="curso_funcionario", joinColumns=@JoinColumn(name="f_id"), inverseJoinColumns=@JoinColumn(name="c_id")) 
	private List<Curso> cursos;

	public Funcionario() {
		
	}

	public Funcionario(long id, String nomeCompleto, Date dataNascimento, String cpf, Date dataContratacao,
			Departamento departamento, List<Curso> cursos) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.dataContratacao = dataContratacao;
		this.departamento = departamento;
		this.cursos = cursos;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getDataContratacao() {
		return dataContratacao;
	}
	
	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
}
