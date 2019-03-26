package br.com.yasmin.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="salaries")
public class Salario {
	
	@EmbeddedId
	private SalarioId id;
	
	@Column(name="salary")
	private Integer salario;
	
	@Column(name="to_date")
	private LocalDate dataFim;
	
}
