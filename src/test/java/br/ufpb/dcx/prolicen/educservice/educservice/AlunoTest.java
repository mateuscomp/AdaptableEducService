package br.ufpb.dcx.prolicen.educservice.educservice;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufpb.dcx.prolicen.educservice.adaptable.impl.AdaptableEducServiceFacade;

public class AlunoTest {

	private EducServiceFacade facade;

	private Aluno aluno;

	@Before
	public void init() {
		facade = new AdaptableEducServiceFacade();
	}

	@Test
	public void cadastrarUmAlunoValido() {
		verificarCriacaoDeUmAlunoValido("Fernando de Oliveira",
				"fernando.mateus@dce.ufpb.br", "mySecrectKey");
		verificarCriacaoDeUmAlunoValido("Ayla Rebouças", "ayla@dce.ufpb.br",
				"herSecrectKey");
		verificarCriacaoDeUmAlunoValido("Rodrigo Vilar",
				"rodrigovilar@dce.ufpb.br", "hisSecrectKey");
	}

	private void verificarCriacaoDeUmAlunoValido(String nome, String login,
			String senha) {
		aluno = this.facade.criarAluno(nome, login, senha);

		Assert.assertEquals(nome, aluno.getNome());
		Assert.assertEquals(login, aluno.getLogin());
		Assert.assertEquals(senha, aluno.getSenha());
	}

	@After
	public void finish() {
		if (aluno != null && aluno.getId() != null) {
			this.facade.removerAluno(aluno.getId());
		}
	}
}
