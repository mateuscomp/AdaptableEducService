package br.ufpb.dcx.prolicen.educservice;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

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
		String extendsHeranca = "extends";
		String heranca = "heranca";
		String java = "java";
		String poo = "poo";
		String lcc = "lcc";

		List<String> palavrasChave = new LinkedList<String>();
		palavrasChave.add(extendsHeranca);
		palavrasChave.add(heranca);
		palavrasChave.add(java);
		palavrasChave.add(poo);
		palavrasChave.add(lcc);

		Exercicio e = facade.criarExercicio(palavrasChave);
		
		Assert.assertNotNull(e.getId());
		Assert.assertEquals(extendsHeranca, e.getPalavrasChave().get(0));
		Assert.assertEquals(heranca, e.getPalavrasChave().get(1));
		Assert.assertEquals(java, e.getPalavrasChave().get(2));
		Assert.assertEquals(poo, e.getPalavrasChave().get(3));
		Assert.assertEquals(lcc, e.getPalavrasChave().get(4));
	}
}
