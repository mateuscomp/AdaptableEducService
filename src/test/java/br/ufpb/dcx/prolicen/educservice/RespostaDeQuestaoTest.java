package br.ufpb.dcx.prolicen.educservice;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dcx.prolicen.educservice.helper.AlunoHelper;
import br.ufpb.dcx.prolicen.educservice.helper.ExercicioHelper;
import br.ufpb.dcx.prolicen.educservice.helper.QuestaoMultiplaEscolhaHelper;
import br.ufpb.dcx.prolicen.educservice.helper.RespostaDeQuestaoHelper;
import br.ufpb.dcx.prolicen.educservice.model.AdaptableEducServiceFacade;
import br.ufpb.dcx.prolicen.educservice.model.Aluno;
import br.ufpb.dcx.prolicen.educservice.model.EducServiceFacade;
import br.ufpb.dcx.prolicen.educservice.model.Exercicio;
import br.ufpb.dcx.prolicen.educservice.model.Questao;

public class RespostaDeQuestaoTest {

	private EducServiceFacade facade;

	@Before
	public void init() {
		facade = new AdaptableEducServiceFacade();
	}

	@Test
	public void simulaIntegracaoEntreEntidades() {
		Aluno aluno = AlunoHelper.verificarCriacaoDeUmAlunoValido(facade,
				"Fernando Mateus", "fernando.mateus@dce.ufpb.br", "secretKey");

		Exercicio exercicio = ExercicioHelper
				.verificarCriacaoDeUmExercicioValido(facade, "poscomp2014",
						"estruturaDeDados", "grafo", "vértice", "aresta");

		Questao questaoMultiplaEscolha = QuestaoMultiplaEscolhaHelper
				.verificarCriacaoDeUmQuestaoDeMultiplaEscolhaValida(
						facade,
						"(POSCOMP 2014) Considerando que um grafo possui n vértices e m arestas, "
								+ "assinale a alternativa que apresenta, corretamente, um grafo planar.",
						exercicio, 4, "n = 5, m = 10", "n = 6, m = 15",
						"n = 7, m = 21", "n = 8, m = 12", "n = 9, m = 22");

		RespostaDeQuestaoHelper
				.verificarCriacaoDeUmaRespostaCorretaParaUmaQuestaoDeMultiplaEscolhaValida(
						facade, aluno.getId(), exercicio.getId(),
						questaoMultiplaEscolha.getId(), 4);
	}
}
