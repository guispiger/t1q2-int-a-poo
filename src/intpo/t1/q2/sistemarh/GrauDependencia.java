package intpo.t1.q2.sistemarh;


public enum GrauDependencia {
	FILHO,
	PAI,
	MAE,
	ESPOSA,
	MARIDO;
	
	public static String mostrarOpcoes() {
		String grauDeDependencia = "";
		for (int i = 0; i < GrauDependencia.values().length; i++) {
			grauDeDependencia = grauDeDependencia + GrauDependencia.values()[i].toString() + "\n";
		}
		return grauDeDependencia;
	}
	
}
