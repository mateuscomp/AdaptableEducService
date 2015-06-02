package br.ufpb.dcx.prolicen.educservice;

import junit.framework.Assert;

import org.junit.Test;

import br.ufpb.dcx.prolicen.educservice.helper.ExercicioHelper;
import br.ufpb.dcx.prolicen.educservice.model.Exercicio;

public class ExercicioTest extends AdaptableEducServiceTest {

	@Test
	public void verificarCadastroDeUmExercicioSemPalavrasChave() {
		Exercicio e = this.facade.criarExercicio();
		Assert.assertNotNull(e.getId());
	}

	@Test
	public void verificarCadastroDeUmExercicioComPalavrasChave() {
		ExercicioHelper.verificarCriacaoDeUmExercicioValido(facade, "extends",
				"herança", "java", "poo", "lcc");

	}
}
