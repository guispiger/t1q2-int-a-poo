package intpo.t1.q2.sistemarh;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JOptionPane;

public class Programa {

	public static void main(String[] args) {
		boolean continuar = true;
		
		Empresa empresa = new Empresa();
		
		Departamento gerencia = new Departamento("Gerência");
		Departamento operacoes = new Departamento("Operações");
		Departamento pD = new Departamento("Pesquisa e Desenvolvimento");
		
		empresa.cadastrarDepartamento(gerencia);
		empresa.cadastrarDepartamento(operacoes);
		empresa.cadastrarDepartamento(pD);
		
		do {
			int operacao = Integer.parseInt(JOptionPane.showInputDialog("Qual operação deseja realizar? ( 1-Cadastrar | 2-Calcular Folha PGTO | 3-Fechar"));
			
			if(operacao == 1) {
				Funcionario funcionario = perguntarDadosNovoFuncionario();
								
				int temDependentes = 1;
				do {
					temDependentes = JOptionPane.showConfirmDialog(null, "Cadastrar dependente?");
					
					if (temDependentes == 0) {
						Boolean espacoDependentes = funcionario.temEspacoDependentes();
						if (!espacoDependentes) {
							JOptionPane.showMessageDialog(null, "Não é possivel cadastrar mais de 2 dependentes!!");
						} else {
							Dependente dependente = perguntarDadosNovoDependente();
							LocalDate hoje = LocalDate.now();
							Period idade = Period.between(dependente.getDataNascimento(), hoje);
							if(dependente.getDependencia() == GrauDependencia.FILHO && idade.getYears() > 18) {
								JOptionPane.showMessageDialog(null, "Não é possivel cadastrar filhos maiores de 18 anos!");
							} else {
								funcionario.cadastrarDependente(dependente);
							}
							
						}		
					}
				} while (temDependentes == 0);
				
				int departamento = Integer.parseInt(JOptionPane.showInputDialog("Qual o departamento: 1-Gerência | 2-Operações | 3-P&D"));
				
				if(departamento == 1) {
					empresa.getDepartamentos()[0].cadastrarFuncionario(funcionario);
				} else if (departamento == 2) {
					empresa.getDepartamentos()[1].cadastrarFuncionario(funcionario);
				} else if (departamento == 3) {
					empresa.getDepartamentos()[2].cadastrarFuncionario(funcionario);
				} else {
					JOptionPane.showMessageDialog(null, "Departamento inexistente!!");
				}
				
				JOptionPane.showMessageDialog(null, "Funcionário cadastrado!!\n" + funcionario);
				
				
			} else if (operacao == 2) {
				
				int operacaoFolha = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a operação a opção desejada: 1-Calcular para empresa | 2-Calcular para Departamento | 3-Calcular para funcionário"));
				
				FolhaPgto olerite = new FolhaPgto();
				
				if (operacaoFolha == 1) {
					BigDecimal valorAPagar = olerite.calcularValorPagar(empresa);
					JOptionPane.showMessageDialog(null, "Valor a pagar: " + valorAPagar);
					
				} else if (operacaoFolha == 2) {
					int departamento = Integer.parseInt(JOptionPane.showInputDialog("Qual o departamento: (1-Gerência | 2-Operações | 3-P&D)"));
					BigDecimal valorAPagar = olerite.calcularValorPagar(empresa.getDepartamentos()[departamento-1]);
					JOptionPane.showMessageDialog(null, "Valor a pagar: " + valorAPagar);
					
				} else if (operacaoFolha == 3) {
					int matricula = Integer.parseInt(JOptionPane.showInputDialog("Digite a matrícula do funcionário:"));
					Funcionario funcionario = empresa.localizarFuncionario(matricula);
					if(funcionario == null) {
						JOptionPane.showMessageDialog(null, "Matricula localizada");
					} else {
						BigDecimal valorAPagar = olerite.calcularValorPagar(funcionario);
						JOptionPane.showMessageDialog(null, "Valor a pagar: " + valorAPagar);
					}
						
				} else {
					JOptionPane.showMessageDialog(null, "Opção incorreta!!");
				}
				
			} else {
				continuar = false;
			}
			
			
		} while (continuar);
		
	}
	
	
	public static Funcionario perguntarDadosNovoFuncionario() {
		String nome = JOptionPane.showInputDialog("Digite o nome:");
		String sobrenome = JOptionPane.showInputDialog("Digite o sobrenome:");
		String cpf = JOptionPane.showInputDialog("Digite o cpf:");
		String stringDataContratacao = JOptionPane.showInputDialog("Digite a data de contratação: Exemplo(31/01/2004)", "dd/mm/yyyy");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		LocalDate dataContratacao = LocalDate.parse(stringDataContratacao, formatter);
		BigDecimal salario = new BigDecimal(JOptionPane.showInputDialog("Digite o salário:"));
		Cargo cargo = Cargo.valueOf(JOptionPane.showInputDialog("Digite o cargo:\n" + Cargo.mostrarOpcoes()));
		
		Funcionario func = new Funcionario(nome, sobrenome, cpf, dataContratacao, salario, cargo);
		return func;
	}
	
	public static Dependente perguntarDadosNovoDependente() {
		String nomeDepen = JOptionPane.showInputDialog("Nome do dependente:");
		String stringDataNascimentoDepen = JOptionPane.showInputDialog("Data nascimento dependente: Exemplo(31/01/2004)", "dd/mm/yyyy");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		LocalDate dataNascimentoDepen = LocalDate.parse(stringDataNascimentoDepen, formatter);
		GrauDependencia dependencia = GrauDependencia.valueOf(JOptionPane.showInputDialog("Grau de dependência:\n" + GrauDependencia.mostrarOpcoes()));
		
		Dependente dependente = new Dependente(nomeDepen, dataNascimentoDepen, dependencia);
		
		return dependente;
	}
	
}
