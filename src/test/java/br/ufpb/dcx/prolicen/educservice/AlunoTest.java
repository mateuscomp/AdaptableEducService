package br.ufpb.dcx.prolicen.educservice;

import org.junit.Test;

import br.ufpb.dcx.prolicen.educservice.helper.AlunoHelper;

public class AlunoTest extends AdaptableEducServiceTest {

	@Test
	public void cadastrarEVerificarAlunosValidos() {
		AlunoHelper.verificarCriacaoDeUmAlunoValido(facade,
				"Fernando de Oliveira", "fernando.mateus@dce.ufpb.br",
				"mySecrectKey");
		AlunoHelper.verificarCriacaoDeUmAlunoValido(facade, "Ayla Rebouças",
				"ayla@dce.ufpb.br", "herSecrectKey");
		AlunoHelper.verificarCriacaoDeUmAlunoValido(facade, "Rodrigo Vilar",
				"rodrigovilar@dce.ufpb.br", "hisSecrectKey");
	}
}
