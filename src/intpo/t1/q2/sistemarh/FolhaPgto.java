package intpo.t1.q2.sistemarh;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class FolhaPgto {
		
	public BigDecimal calcularValorPagar(Funcionario funcionario) {
		
		BigDecimal valor = funcionario.getSalario();
		
		//adicional de dependentes
		int nDependentes = funcionario.contarDependentes();
		valor = valor.add(BigDecimal.valueOf(nDependentes).multiply(new BigDecimal("105.99")));
		
		//adicional de tempo de trabalho
		LocalDate hoje = LocalDate.now();
		Period tempoServico = Period.between(funcionario.getDataContratacao(), hoje);
		valor = valor.add(BigDecimal.valueOf(tempoServico.getYears()).multiply(new BigDecimal("100")));
		
		//deducoes
		BigDecimal deducoes = valor.multiply(new BigDecimal(Imposto.INPS.getValor()));
		deducoes = deducoes.add(valor.multiply(new BigDecimal(Imposto.INSS.getValor())));
		deducoes = deducoes.add(valor.multiply(new BigDecimal(Imposto.SEGUROOBRIGATORIO.getValor())));
		if(funcionario.getCargo() == Cargo.ENGENHEIRO) {
			deducoes = deducoes.add(valor.multiply(new BigDecimal(Imposto.SINDICATO.getValor())));
		}
		valor = valor.subtract(deducoes);
		
		return valor;
	}
	
	public BigDecimal calcularValorPagar(Departamento departamento) {
		
		BigDecimal valor = new BigDecimal("0");
		
		for (int i = 0; i < departamento.getFuncionarios().length; i++) {
			if(departamento.getFuncionarios()[i] !=null) {
				valor = valor.add(calcularValorPagar(departamento.getFuncionarios()[i]));
			}
		}
		
		return valor;
	}
	
	public BigDecimal calcularValorPagar(Empresa empresa) {
		
		BigDecimal valor = new BigDecimal("0");
		
		for (int i = 0; i < empresa.getDepartamentos().length; i++) {
			if(empresa.getDepartamentos()[i] != null) {
				valor = valor.add(calcularValorPagar(empresa.getDepartamentos()[i]));
			}
		}
		
		return valor;
	}
	
	
}
