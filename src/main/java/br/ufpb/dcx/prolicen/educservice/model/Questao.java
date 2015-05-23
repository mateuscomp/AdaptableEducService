package br.ufpb.dcx.prolicen.educservice.model;

public abstract class Questao {
	private String id;

	public Questao(String id) {
		this.setId(id);
	}

	public abstract String getDescricao();

	public abstract String getSolucao();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}