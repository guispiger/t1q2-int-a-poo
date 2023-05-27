package intpo.t1.q2.sistemarh;

public enum Imposto {
	INSS("0.10"),
	INPS("0.10"),
	SEGUROOBRIGATORIO("0.10"),
	SINDICATO("0.10");
	
	private String valor;
	
	private Imposto(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
	
}
