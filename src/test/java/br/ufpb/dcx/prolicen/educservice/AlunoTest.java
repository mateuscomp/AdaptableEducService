package br.ufpb.dcx.prolicen.educservice;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dcx.prolicen.educservice.helper.AlunoHelper;
import br.ufpb.dcx.prolicen.educservice.model.AdaptableEducServiceFacade;
import br.ufpb.dcx.prolicen.educservice.model.EducServiceFacade;

public class AlunoTest {

	private EducServiceFacade facade;

	@Before
	public void init() {
		facade = new AdaptableEducServiceFacade();
	}

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
