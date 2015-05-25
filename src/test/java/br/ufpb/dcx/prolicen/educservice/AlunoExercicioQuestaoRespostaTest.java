package br.ufpb.dcx.prolicen.educservice;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dcx.prolicen.educservice.model.AdaptableEducServiceFacade;
import br.ufpb.dcx.prolicen.educservice.model.Aluno;
import br.ufpb.dcx.prolicen.educservice.model.EducServiceFacade;
import br.ufpb.dcx.prolicen.educservice.model.Exercicio;
import br.ufpb.dcx.prolicen.educservice.model.Questao;

public class AlunoExercicioQuestaoRespostaTest {

	private EducServiceFacade facade;

	@Before
	public void init() {
		facade = new AdaptableEducServiceFacade();
	}

	@Test
	public void simulaIntegracaoEntreEntidades() {
		Aluno aluno = this.facade.criarAluno("Fernando Mateus",
				"fernando.mateus@dce.ufpb.br", "secretKey");

		List<String> palavrasChave = new LinkedList<String>();
		palavrasChave.add("poscomp2014");
		palavrasChave.add("estruturaDeDados");
		palavrasChave.add("grafo");
		palavrasChave.add("vértice");
		palavrasChave.add("aresta");

		Exercicio exercicio = this.facade.criarExercicio(palavrasChave);

		String enunciado = "(POSCOMP 2014) Considerando que um grafo possui n vértices e m arestas, "
				+ "assinale a alternativa que apresenta, corretamente, um grafo planar.";
		List<String> alternativas = new LinkedList<String>();
		alternativas.add("n = 5, m = 10");
		alternativas.add("n = 6, m = 15");
		alternativas.add("n = 7, m = 21");
		alternativas.add("n = 8, m = 12");
		alternativas.add("n = 9, m = 22");

		int alternativaCorreta = 4;
		Questao questaoMultiplaEscolha = this.facade.cadastrarQuestaoME(
				exercicio.getId(), enunciado, alternativas, alternativaCorreta);

		this.facade.cadastrarRespostaQuestaoMEPorId(aluno.getId(),
				exercicio.getId(), questaoMultiplaEscolha.getId(),
				alternativaCorreta);
	}
}
