package intpo.t1.q2.sistemarh;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Dependente {
	private String nome;
	private LocalDate dataNascimento;
	private GrauDependencia dependencia;
	
	
		
	public Dependente(String nome, LocalDate dataNascimento, GrauDependencia dependencia) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.dependencia = dependencia;
	}
	
		
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		return  "\nDependente Nome: " + nome + 
				"\nData de Nascimento: " + dataNascimento.format(formatter) + 
				"\nGrau de dependencia: " + dependencia;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public GrauDependencia getDependencia() {
		return dependencia;
	}
	
}
