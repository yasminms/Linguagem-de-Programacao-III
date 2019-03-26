package br.com.yasmin.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SalarioId implements Serializable {

	
	@Column(name = "emp_no")
	private Integer id;
	
	@Column(name = "from_date")
	private LocalDate dataInicio;
}
