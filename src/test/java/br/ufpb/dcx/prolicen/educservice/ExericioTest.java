package br.ufpb.dcx.prolicen.educservice;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dcx.prolicen.educservice.helper.ExercicioHelper;
import br.ufpb.dcx.prolicen.educservice.model.AdaptableEducServiceFacade;
import br.ufpb.dcx.prolicen.educservice.model.EducServiceFacade;
import br.ufpb.dcx.prolicen.educservice.model.Exercicio;

public class ExericioTest {

	private EducServiceFacade facade;

	@Before
	public void init() {
		facade = new AdaptableEducServiceFacade();
	}

	@Test
	public void verificarCadastroDeUmExercicioSemPalavrasChave() {
		Exercicio e = facade.criarExercicio();
		Assert.assertNotNull(e.getId());
	}

	@Test
	public void verificarCadastroDeUmExercicioComPalavrasChave() {
		ExercicioHelper.verificarCriacaoDeUmExercicioValido(facade, "extends",
				"herança", "java", "poo", "lcc");

	}
}
