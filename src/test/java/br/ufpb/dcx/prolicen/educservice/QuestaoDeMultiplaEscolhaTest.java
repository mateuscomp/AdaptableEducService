package br.ufpb.dcx.prolicen.educservice;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dcx.prolicen.educservice.model.AdaptableEducServiceFacade;
import br.ufpb.dcx.prolicen.educservice.model.EducServiceFacade;
import br.ufpb.dcx.prolicen.educservice.model.Exercicio;
import br.ufpb.dcx.prolicen.educservice.model.QuestaoMultiplaEscolha;

public class QuestaoDeMultiplaEscolhaTest {

	private EducServiceFacade facade;

	@Before
	public void init() {
		facade = new AdaptableEducServiceFacade();
	}

	@Test
	public void cadastrarUmQuestaoValida() {
		String enunciado = "(POSCOMP 2014) Suponha que o sistema de identificação de funcionários "
				+ "em uma empresa seja composto por um código "
				+ "com quatro dígitos numéricos. Assinale a alternativa "
				+ "que apresenta, corretamente, a quantidade máxima de funcionários que "
				+ "essa empresa pode registrar com esse sistema de identificação, "
				+ "considerando dígitos numéricos distintos.";

		List<String> alternativas = new ArrayList<String>();
		alternativas.add("03024");
		alternativas.add("5040");
		alternativas.add("06561");
		alternativas.add("09000");
		alternativas.add("10000");

		Exercicio exercicio = this.facade.criarExercicio();
		int indiceDaQuestaoCorretaNaLista = 1;

		QuestaoMultiplaEscolha qME = this.facade.cadastrarQuestaoME(
				exercicio.getId(), enunciado, alternativas,
				indiceDaQuestaoCorretaNaLista);

		QuestaoMultiplaEscolha qMEPesquisada = this.facade
				.pesquisarQuestaoMEPorId(exercicio.getId(),
						String.valueOf(qME.getId()));

		Assert.assertEquals(qME.getEnunciado(), qMEPesquisada.getEnunciado());
		Assert.assertEquals(qME.getAlternativaCorreta(),
				qMEPesquisada.getAlternativaCorreta());
		Assert.assertEquals(qME.getDescricao(), qMEPesquisada.getDescricao());
		Assert.assertEquals(qME.getSolucao(), qMEPesquisada.getSolucao());

		for (int i = 0; i < alternativas.size(); i++) {
			Assert.assertEquals(alternativas.get(i), qMEPesquisada
					.getAlternativas().get(i));
		}
	}
}
