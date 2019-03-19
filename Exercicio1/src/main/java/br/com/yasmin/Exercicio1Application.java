package br.com.yasmin;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import br.com.yasmin.domain.Funcionario;
import br.com.yasmin.repository.FuncionarioRepository;

@SpringBootApplication
public class Exercicio1Application extends JFrame implements ActionListener{
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	private JList jList = new JList();
    private DefaultListModel listModel = new DefaultListModel();

	private JLabel lblNome = new JLabel("Nome");
	private JTextField txtNome = new JTextField();
	private JButton btAdd = new JButton("Adicionar");
	private JButton btListar = new JButton("Listar");
	private JTextArea area = new JTextArea();
	
	public Exercicio1Application() {
		super("Manter Funcionários");
		this.setSize(600, 480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setLayout(new FlowLayout());
		this.lblNome.setPreferredSize(new Dimension(50, 30));
		this.txtNome.setPreferredSize(new Dimension(200, 30));
		JScrollPane scroll = new JScrollPane(jList);
		scroll.setPreferredSize(new Dimension(500, 300));
		this.getContentPane().add(lblNome);
		this.getContentPane().add(txtNome);
		this.getContentPane().add(btAdd);
		this.getContentPane().add(btListar);
		this.getContentPane().add(scroll);
		this.setVisible(true);
		this.btAdd.addActionListener(this);
		this.btListar.addActionListener(this);
		jList.setModel(listModel);
	}
	
	public static void main(String[] args) {
		ApplicationContext c = SpringApplication.run(Exercicio1Application.class, args);

		Exercicio1Application ex1 = c.getBean(Exercicio1Application.class);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btAdd) {			
			String nome = txtNome.getText();
			Funcionario funcionario = new Funcionario();
			funcionario.setNome( nome );
			funcionarioRepository.save(funcionario);
			System.out.println("Cadastrando uma pessoa...");			
		} else if ( e.getSource() == btListar ) {
			List<Funcionario> listaFuncionarios = funcionarioRepository.findAll();
			for (Funcionario funcionario : listaFuncionarios) {
				listModel.addElement(funcionario);
			}
		}
	}

}
