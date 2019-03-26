package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.domain.Funcionario;
import com.example.repository.FuncionarioRepository;

@SpringBootApplication
public class ExercicioQueryApplication {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	private static List<Funcionario> funcionarios = new ArrayList<>();
	
	public static void main(String[] args) {

		ApplicationContext c = SpringApplication.run(ExercicioQueryApplication.class, args);

		ExercicioQueryApplication ex = c.getBean(ExercicioQueryApplication.class);

		funcionarios.add(new Funcionario(null, "Yasmin", "Moraes", new BigDecimal(1000)));
		funcionarios.add(new Funcionario(null, "João", "Carlos", new BigDecimal(2000)));
		funcionarios.add(new Funcionario(null, "Matheus", "Correia", new BigDecimal(3000)));
		funcionarios.add(new Funcionario(null, "Joana", "Silva", new BigDecimal(4000)));
		
		ex.funcionarioRepository.saveAll(funcionarios);
		
		System.out.println("\n-----------------------------------------------------------------------------------------------------------");
		System.out.println("FIND BY NOME\n" + ex.funcionarioRepository.findByNome("Yasmin").toString() + "\n");
		System.out.println("FIND BY NOME AND SOBRENOME\n" + ex.funcionarioRepository.findByNomeAndSobrenome("Yasmin", "Moraes") + "\n");
		System.out.println("FIND BY NOME OR SOBRENOME\n" + ex.funcionarioRepository.findByNomeOrSobrenome("Yasmin", "Carlos") + "\n");
		System.out.println("FIND BY SALARIO BETWEEN\n" + ex.funcionarioRepository.findBySalarioBetween(new BigDecimal(2000), new BigDecimal(3000)) + "\n");
		System.out.println("FIND BY SALARIO LESS THAN\n" + ex.funcionarioRepository.findBySalarioLessThan(new BigDecimal(4000)) + "\n");
		System.out.println("FIND BY SALARIO LESS THAN EQUAL\n" + ex.funcionarioRepository.findBySalarioLessThanEqual(new BigDecimal(4000)) + "\n");
		System.out.println("FIND BY SALARIO GREATER THAN\n" + ex.funcionarioRepository.findBySalarioGreaterThan(new BigDecimal(2000)) + "\n");
		System.out.println("FIND BY SALARIO GREATER THAN EQUAL\n" + ex.funcionarioRepository.findBySalarioGreaterThanEqual(new BigDecimal(2000)) + "\n");
		System.out.println("-----------------------------------------------------------------------------------------------------------");

	}

}
