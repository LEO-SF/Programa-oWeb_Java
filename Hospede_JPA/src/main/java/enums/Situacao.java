package enums;

public enum Situacao {
	VAGO(1, "VAGO"), OCUPADO(1, "OCUPADO"), EM_MANUTENCAO(1, "EM MANUTENÇÃO");

	private final int id;
	private final String descricao;

	private Situacao(int id, String descricao){
		this.id = id;
		this.descricao = descricao;
	}

	public int getId(){
		return id;
	}

	public String getNome(){
		return descricao;
	}
}
