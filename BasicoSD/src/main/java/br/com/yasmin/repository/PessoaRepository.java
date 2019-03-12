package br.com.yasmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.yasmin.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	
}
