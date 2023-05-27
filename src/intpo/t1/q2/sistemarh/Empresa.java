package intpo.t1.q2.sistemarh;

public class Empresa {
	private Departamento[] departamentos = new Departamento[3];
	private int index = 0;
	
	
	public void cadastrarDepartamento(Departamento departamento) {
		this.departamentos[index] = departamento;
		index++;
	}
	
	public Departamento[] getDepartamentos() {
		return departamentos;
	}
	
	public Funcionario localizarFuncionario(int matricula) {
		Funcionario funcionario = null;
		for (int i = 0; i < this.departamentos.length; i++) {
			for (int j = 0; j < this.departamentos[i].getFuncionarios().length; j++) {
				if(this.departamentos[i].getFuncionarios()[j] !=null) {
					if(this.departamentos[i].getFuncionarios()[j].getMatricula() == matricula) {
						funcionario = this.departamentos[i].getFuncionarios()[j];
					}
				}
			}
		}
		return funcionario;
	}
	
}
