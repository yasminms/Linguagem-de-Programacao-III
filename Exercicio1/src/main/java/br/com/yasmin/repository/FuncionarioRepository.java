package br.com.yasmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.yasmin.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
