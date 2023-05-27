package intpo.t1.q2.sistemarh;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

public class Funcionario {
	private String nome;
	private String sobrenome;
	private String cpf;
	private LocalDate dataContratacao;
	private BigDecimal salario;
	private Cargo cargo;
	private int matricula = 0;
	public static int x = 0;
	public Dependente[] dependentes = new Dependente[2];
	private int index = 0;
	
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		
		return 	"Nome: " + nome + 
				"\nSobrenome: " + sobrenome + 
				"\nCpf: " + cpf + 
				"\nData de Contratação: " + dataContratacao.format(formatter) + 
				"\nCargo: " + cargo + 
				"\nSalário: " + salario +
				"\nMatricula: " + matricula +
				"\n=================" +
				"\nDependentes:" + Arrays.toString(dependentes);
	}

	public void cadastrarDependente(Dependente depen) {
			dependentes[index] = depen;
			index++;
	}
	
	public boolean temEspacoDependentes() {
		boolean espaco =  false;
		if (index < dependentes.length) {
			espaco = true;
		}
		return espaco;
	}
	
	public Funcionario(String nome, String sobrenome, String cpf, LocalDate dataContratacao, BigDecimal salario, Cargo cargo) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.dataContratacao = dataContratacao;
		this.salario = salario;
		this.cargo = cargo;
		x = x + 1;
		this.matricula = matricula + x;
	}
	
	public int contarDependentes() {
		int cont = 0;
		
		for (int i = 0; i < this.dependentes.length; i++) {
			if (this.dependentes[i] != null) {
				cont++;
			}
		}
		
		return cont;
		
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public int getMatricula() {
		return matricula;
	}

	
}

