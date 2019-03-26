package br.com.yasmin.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.yasmin.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Funcionario {

	@Id
	@Column(name = "emp_no")
	private Integer id;
	
	@Column(name = "first_name")
	private String nome;
	
	@Column(name = "last_name")
	private String sobrenome;
	
	@Column(name = "birth_date")
	private LocalDate dataNascimento;
	
	@Column(name = "hire_date")
	private LocalDate dataContratacao;
	
	@Column(name = "gender", columnDefinition="enum('m', 'f')")
	@Enumerated(EnumType.STRING)
	private Genero genero;

}
