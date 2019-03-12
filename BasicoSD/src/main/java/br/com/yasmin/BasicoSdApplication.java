package br.com.yasmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import br.com.yasmin.domain.Pessoa;
import br.com.yasmin.repository.PessoaRepository;

@SpringBootApplication
public class BasicoSdApplication {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public static void main(String[] args) {
		
		ApplicationContext c = SpringApplication.run(BasicoSdApplication.class, args);
		
		BasicoSdApplication ba = c.getBean(BasicoSdApplication.class);
		
		Pessoa p1 = new Pessoa();
		p1.setNome("Yasmin");
		
		ba.pessoaRepository.save(p1);
		
		List<Pessoa> pessoas = ba.pessoaRepository.findAll();
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.getNome());
		}
	}

}
