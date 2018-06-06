package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum BatchResult {
	SUCESSO("S"), ERRO("E"), ABORTADO("A"), EMPROCESSAMENTO("P");

	private String value;

	private BatchResult(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
