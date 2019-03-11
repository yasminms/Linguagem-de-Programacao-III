package revisao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import revisao.model.Curso;
import revisao.model.Departamento;
import revisao.model.Funcionario;

public class Main {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_basico");

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		
		List<Departamento> departamentos = new ArrayList<>();
		List<Funcionario> funcionarios = new ArrayList<>();
		List<Curso> cursos = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			Departamento departamento = new Departamento();
			departamento.setNome("Departamento " + i);
			departamentos.add(departamento);
			manager.persist(departamento);
		}
		
		for (int i = 0; i < 2; i++) {
			Curso curso = new Curso();
			curso.setNome("Curso" + i);
			curso.setFuncionarios(funcionarios);
			cursos.add(curso);
			manager.persist(curso);
		}

		
		for (int i = 0; i < 20; i++) {
			Funcionario funcionario = new Funcionario();
			funcionario.setNomeCompleto("João " + i);
			funcionario.setDataContratacao(new Date(i, i, 2017));
			funcionario.setDataNascimento(new Date(i, i, 1990));
			if (i > 9) {
				funcionario.setCpf("000.000.000-"+String.valueOf(i));
			} else {
				funcionario.setCpf("000.000.000-0"+String.valueOf(i));
			}
			
			if (i > 15) {
				funcionario.setDepartamento(departamentos.get(0));
			} else {
				if (i > 10) {
					funcionario.setDepartamento(departamentos.get(1));
				} else {
					if (i > 5) {
						funcionario.setDepartamento(departamentos.get(2));
					} else {
						if (i >= 0) {
							funcionario.setDepartamento(departamentos.get(3));
						}
					}
				}
			}
			funcionario.setCursos(cursos);
			funcionarios.add(funcionario);
			manager.persist(funcionario);
		}
		
		
		manager.getTransaction().commit();

		manager.close();

		factory.close();
	}

}
