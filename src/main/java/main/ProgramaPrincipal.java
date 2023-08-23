package main;

import java.util.Date;
import java.util.List;

import aluno.Aluno;
import aluno.GerenciarAluno;
import console.Console;

public class ProgramaPrincipal {

	private final int CADASTRAR = 1;
	private final int EDITAR = 2;
	private final int LISTAR = 3;
	private final int REMOVER = 4;
	private final int SAIR = 9;

	private Console console;
	private Aluno aluno;
	private GerenciarAluno gerAluno;

	public ProgramaPrincipal() {
		console = new Console();
		gerAluno = new GerenciarAluno();
	}

	public static void main(String[] args) {
		new ProgramaPrincipal().executar();
	}

	private void executar() {
		int opcao = 0;

		do {
			mostrarMenuNaTela();
			
			opcao = console.readInt("Escolha uma opcao:");
			

			if (opcao == CADASTRAR) {
				cadastrarAluno();
			} else if (opcao == EDITAR) {
				editarAluno();
			} else if (opcao == REMOVER) {
				removerAluno();
			} else if (opcao == LISTAR) {
				listarAluno();
			}
		} while (opcao != SAIR);
	}
	
	private void cadastrarAluno() {
		aluno = new Aluno();
		
		String nome = console.readLine("Digite o nome do aluno");
		String login = console.readLine("Digite o login do aluno");
		Date dataNascimento = console.readDate("Digite a data de nascimento do aluno");
		String matricula = console.readLine("Digite a matrícula do aluno");
		
		aluno.setNome(nome);
		aluno.setLogin(login);
		aluno.setDataNascimento(dataNascimento);
		aluno.setMatricula(matricula);
		
		gerAluno.cadastrar(aluno);
	}
	
	private void editarAluno() {
		int novoId = console.readInt("Digite o novo id");
		aluno = gerAluno.findById(novoId);
		String novoNome = console.readLine("Digite o novo nome do aluno");
		String novoLogin = console.readLine("Digite o novo login do aluno");
		Date novaDataNascimento = console.readDate("Digite a nova data de nascimento do aluno");
		String novaMatricula = console.readLine("Digite a nova matrícula do aluno");
		
		aluno.setNome(novoNome);
		aluno.setLogin(novoLogin);
		aluno.setDataNascimento(novaDataNascimento);
		aluno.setMatricula(novaMatricula);
		
		gerAluno.atualizar(aluno);
	}
	
	private void removerAluno() {
		int removerId = console.readInt("Digite o id para remover");
		aluno = gerAluno.findById(removerId);
		
		gerAluno.remover(aluno);
	}
	
	public void listarAluno() {

		List<Aluno> aluno= gerAluno.listar();

		for (int i = 0; i < aluno.size(); i++) {
			System.out.println("\n Id: " + aluno.get(i).getId());
			System.out.println("Nome do Aluno: " + aluno.get(i).getNome());
			System.out.println("Login do Aluno: " + aluno.get(i).getLogin());
			System.out.println("Data de Nascimento do aluno: " + aluno.get(i).getDataNascimento());
			System.out.println("Numero de matricula: " + aluno.get(i).getMatricula());
		}
	}
	
	private void mostrarMenuNaTela()
	{
		System.out.println("\n--- SUPER PROGRAMA DE CADASTRO DE ALUNOS ---");
		System.out.println("");
		System.out.println("1 - Cadastrar aluno");
		System.out.println("2 - Editar aluno");
		System.out.println("3 - Listar alunos");
		System.out.println("4 - Remover aluno");
		System.out.println("9 - Sair");
	}
}
