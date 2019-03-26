package com.example.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	List<Funcionario> findByNome(String nome);
	
	List<Funcionario> findByNomeAndSobrenome(String nome, String sobrenome);
	
	List<Funcionario> findByNomeOrSobrenome(String nome, String sobrenome);
	
	List<Funcionario> findBySalarioBetween(BigDecimal valor1, BigDecimal valor2);
	
	List<Funcionario> findBySalarioLessThan(BigDecimal valor);
	
	List<Funcionario> findBySalarioLessThanEqual(BigDecimal valor);
	
	List<Funcionario> findBySalarioGreaterThan(BigDecimal valor);
	
	List<Funcionario> findBySalarioGreaterThanEqual(BigDecimal valor);

}
