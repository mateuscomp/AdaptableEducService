package br.ufpb.dcx.prolicen.educservice.educservice;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dcx.prolicen.educservice.adaptable.impl.AdaptableEducServiceFacade;

public class CriacaoDeQuestaoDeMultiplaEscolha {

	private EducServiceFacade facade;

	@Before
	public void init() {
		facade = new AdaptableEducServiceFacade();
	}

	@Test
	public void cadastrarUmQuestaoValida() {
		// Desenvolver um questão real
		String enunciado = "Enunciado da questão 1";

		List<String> alternativas = new ArrayList<String>();
		alternativas.add("Alternativa 1");
		alternativas.add("Alternativa 2");

		this.facade.cadastrarQuestaoME("1", enunciado, alternativas, 1);
	}
}
