package intpo.t1.q2.sistemarh;

public enum Cargo {
	PRESIDENTE,
	GERENTE,
	CONTADOR,
	SECRETARIO,
	RECEPCIONISTA,
	MOTORISTA,
	ENTEGADOR,
	PROGRAMADOR,
	ENGENHEIRO,
	ENCANADOR,
	COZINHEIRO,
	COBRADOR;
	
	public static String mostrarOpcoes() {
		String cargos = "";
		for (int i = 0; i < Cargo.values().length; i++) {
			cargos = cargos + Cargo.values()[i].toString() + "\n";
		}
		return cargos;
	}

}

