package intpo.t1.q2.sistemarh;


public class Departamento {
	private String nome;
	private Funcionario[] funcionarios = new Funcionario[1];
	private int index = 0;
	
	
	
	public Departamento(String nome) {
		this.nome = nome;
	}

	public void cadastrarFuncionario(Funcionario func) {
		if (index == funcionarios.length) {
			duplicarVetor();
		}
			funcionarios[index] = func;
			index++;
	}
	
	private void duplicarVetor() {
		int novoTamanho = 2 * (this.funcionarios.length);
		Funcionario[] funcTemp = new Funcionario[novoTamanho]; 
		for (int i = 0; i < this.funcionarios.length; i++) {
			funcTemp[i] = this.funcionarios[i];
		}
		
		this.funcionarios = funcTemp;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Funcionario[] getFuncionarios() {
		return funcionarios;
	}
}
