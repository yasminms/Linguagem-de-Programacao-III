package br.com.yasmin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class Exercicio1Application {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public static void main(String[] args) {
		ApplicationContext c = SpringApplication.run(Exercicio1Application.class, args);

		Exercicio1Application ex1 = c.getBean(Exercicio1Application.class);

		List<Funcionario> funcionarios = new ArrayList<>();
		
		//Inserir 50 funcionários
		for (int i = 0; i < 50; i++) {
			funcionarios.add(new Funcionario(null, "Funcionário " + i, new Double(i + 1000)));
		}

//		ex1.funcionarioRepository.saveAll(funcionarios);
		
		//Listar os funcionários em ordem crescente por nome
		System.out.println("----------------------------------------");

		List<Funcionario> funcionariosPage = ex1.funcionarioRepository.findAll(new Sort(Sort.Direction.ASC, "nome"));
		
		for (Funcionario funcionario : funcionariosPage) {
			System.out.println(funcionario.toString());
		}
		
		//Listar os funcionários em ordem decrescente por salário
		System.out.println("----------------------------------------");

		List<Funcionario> funcionariosPage2 = ex1.funcionarioRepository.findAll(new Sort(Sort.Direction.DESC, "salario"));

		for (Funcionario funcionario : funcionariosPage2) {
			System.out.println(funcionario.toString());
		}
		
		//Listar os funcionários utilizando o recurso de paginação
		//Exibir a página 2, considerando 10 elementos por página
		
		System.out.println("----------------------------------------");
		Page<Funcionario> funcionariosPage3 = ex1.funcionarioRepository.findAll(PageRequest.of(2, 10));

		for (Funcionario funcionario : funcionariosPage3) {
			System.out.println(funcionario.toString());
		}
	}

}
