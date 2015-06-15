package br.ufpb.dcx.prolicen.educservice.helper;

import junit.framework.Assert;
import br.ufpb.dcx.prolicen.educservice.model.Aluno;
import br.ufpb.dcx.prolicen.educservice.model.EducServiceFacade;

public class AlunoHelper {

	public static Aluno verificarCriacaoDeUmAlunoValido(
			EducServiceFacade facade, String nome, String login, String senha) {

		Aluno aluno = facade.criarAluno(nome, login, senha);

		Assert.assertNotNull(aluno.getId());
		Assert.assertEquals(nome, aluno.getNome());
		Assert.assertEquals(login, aluno.getLogin());
		Assert.assertEquals(senha, aluno.getSenha());

		return aluno;
	}

}
